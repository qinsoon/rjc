package org.rjava.compiler.targets.c.runtime;

import static org.rjava.compiler.targets.c.CLanguageGenerator.NEWLINE;
import static org.rjava.compiler.targets.c.CLanguageGenerator.MALLOC;
import static org.rjava.compiler.targets.c.CLanguageGenerator.SIZE_OF;
import static org.rjava.compiler.targets.c.CLanguageGenerator.SEMICOLON;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.rjava.compiler.Constants;
import org.rjava.compiler.RJavaCompiler;
import org.rjava.compiler.exception.RJavaError;
import org.rjava.compiler.semantics.SemanticMap;
import org.rjava.compiler.semantics.representation.RClass;
import org.rjava.compiler.targets.CodeStringBuilder;
import org.rjava.compiler.targets.c.CLanguageGenerator;
import org.rjava.compiler.targets.c.CLanguageNameGenerator;
import org.rjava.compiler.util.HelperMethod;
import org.rjava.compiler.util.HelperVariable;
import org.rjava.compiler.util.Tree;
import org.rjava.compiler.util.TreeBreadthFirstIterator;

public class CLanguageRuntime {
    public static final String ALWAYS_INLINE = "static inline __attribute__((always_inline))";
    
    public static final int DEFAULT_MALLOC      = 0;
    public static final int GC_MALLOC           = 1;
    public static final int GC_MALLOC_PREBUILT  = 2;

    public static final int MEMORY_MANAGEMENT_SCHEME = GC_MALLOC_PREBUILT;
    
    // atomic ops lib
    public static final boolean ATOMIC_OPS_PREBUILT = true;
    
    /*
     * RJava's C implementation helpers
     */
    // include c standard lib
    public static final String[] C_STD_LIB_HEADER = {
        "stdio.h",
        "stdlib.h",
        "stdbool.h",
        "inttypes.h",
        "pthread.h",
        "limits.h"
    };
    // rjava's java.lang lib
    public static final String RJAVA_LIB = "rjava_clib";
    // rjava runtime (including some defines and helpers)
    public static final String RJAVA_CRT = "rjava_crt";
    // runtime define before include (an ugly hack) because we need to define GC_THREADS before including boehm gc header
    public static final HashMap<String, String> RJAVA_RUNTIME_DEFINE_BEFORE_INCLUDE = new HashMap<String, String>();
    static {
        if (MEMORY_MANAGEMENT_SCHEME == GC_MALLOC || MEMORY_MANAGEMENT_SCHEME == GC_MALLOC_PREBUILT)
            RJAVA_RUNTIME_DEFINE_BEFORE_INCLUDE.put("GC_THREADS", "");
    }
    // runtime define
    public static final HashMap<String, String> RJAVA_RUNTIME_DEFINE = new HashMap<String, String>();
    static {
        RJAVA_RUNTIME_DEFINE.put("byte", "char");
        RJAVA_RUNTIME_DEFINE.put("RJAVA_ALWAYS_INLINE", ALWAYS_INLINE);
        
        if (MEMORY_MANAGEMENT_SCHEME == GC_MALLOC || MEMORY_MANAGEMENT_SCHEME == GC_MALLOC_PREBUILT) {
            RJAVA_RUNTIME_DEFINE.put("malloc", "GC_malloc");
        }
    }
    public static final ArrayList<String> EXTRA_INCLUDE = new ArrayList<String>();
    public static final HashMap<String, String> MAKE_SUBTASK = new HashMap<String, String>();
    
    public static final String ATOMIC_LIB_OSX = "libatomic_ops_osx.a";
    public static final String ATOMIC_LIB_OSX_32 = "libatomic_ops_osx_32.a";
    public static final String ATOMIC_LIB_LINUX = "libatomic_ops_linux.a";
    public static final String ATOMIC_LIB_LINUX_32 = "libatomic_ops_linux_32.a";
    
    public static final String GC_OSX = "boehm-gc_osx.a";
    public static final String GC_OSX_32 = "boehm-gc_osx_32.a";
    public static final String GC_LINUX = "boehm-gc_linux.a";
    public static final String GC_LINUX_32 = "boehm-gc_linux_32.a";
    
    static {       
        if (ATOMIC_OPS_PREBUILT) {
            if (RJavaCompiler.hostOS == RJavaCompiler.HOST_MACOSX) {
                if (RJavaCompiler.m32) {
                    MAKE_SUBTASK.put(ATOMIC_LIB_OSX_32, ATOMIC_LIB_OSX_32 + ":\n" +
                            "\tcp prebuilt/" + ATOMIC_LIB_OSX_32 + " " + ATOMIC_LIB_OSX_32 + "\n");
                }
                else {
                    MAKE_SUBTASK.put(ATOMIC_LIB_OSX, ATOMIC_LIB_OSX + ":\n" +
                            "\tcp prebuilt/" + ATOMIC_LIB_OSX + " " + ATOMIC_LIB_OSX + "\n");               
                }
            } else if (RJavaCompiler.hostOS == RJavaCompiler.HOST_LINUX) {
                if (RJavaCompiler.m32) {
                    MAKE_SUBTASK.put(ATOMIC_LIB_LINUX_32, ATOMIC_LIB_LINUX_32 + ":\n" +
                            "\tcp prebuilt/" + ATOMIC_LIB_LINUX_32 + " " + ATOMIC_LIB_LINUX_32 + "\n");
                }
                else {
                    MAKE_SUBTASK.put(ATOMIC_LIB_LINUX, ATOMIC_LIB_LINUX + ":\n" +
                            "\tcp prebuilt/" + ATOMIC_LIB_LINUX + " " + ATOMIC_LIB_LINUX + "\n");               
                }
            }
        } else {
            MAKE_SUBTASK.put("libatomic_ops.a", "libatomic_ops.a:\n" +
                    "\tcd boehm-gc/libatomic_ops;" + (RJavaCompiler.m32 ? "CFLAGS=-m32" : "") + "./configure;make\n" +
                    "\tcp boehm-gc/libatomic_ops/src/.libs/libatomic_ops.a libatomic_ops.a\n");
        }
        
        // malloc lib
        switch (MEMORY_MANAGEMENT_SCHEME) {
        case DEFAULT_MALLOC: 
            CLanguageGenerator.MALLOC = "malloc";
            break;
        case GC_MALLOC:
            CLanguageGenerator.MALLOC = "GC_malloc";
            EXTRA_INCLUDE.add(includeNonStandardHeader("boehm-gc/include/gc.h"));
            MAKE_SUBTASK.put("boehm-gc.a", "boehm-gc.a:\n" +
                    "\tcd boehm-gc;autoreconf -vif;automake --add-missing;" + 
                    (RJavaCompiler.m32 ? "CFLAGS=-m32 " : "") + "./configure --enable-threads=posix --enable-static;make\n" +
                    "\tcp boehm-gc/.libs/libgc.a boehm-gc.a\n");
            break;
        case GC_MALLOC_PREBUILT:
            CLanguageGenerator.MALLOC = "GC_malloc";
            EXTRA_INCLUDE.add(includeNonStandardHeader("boehm-gc/include/gc.h"));
            if (RJavaCompiler.hostOS == RJavaCompiler.HOST_MACOSX) {
                if (RJavaCompiler.m32) {
                    MAKE_SUBTASK.put(GC_OSX_32, GC_OSX_32 + ":\n" +
                        "\tcp prebuilt/" + GC_OSX_32 + " " + GC_OSX_32 + "\n");
                }else MAKE_SUBTASK.put(GC_OSX, GC_OSX + ":\n" +
                        "\tcp prebuilt/" + GC_OSX + " " + GC_OSX +"\n");
            } else if (RJavaCompiler.hostOS == RJavaCompiler.HOST_LINUX) {
                if (RJavaCompiler.m32) {
                    MAKE_SUBTASK.put(GC_LINUX_32, GC_LINUX_32 + ":\n" +
                        "\tcp prebuilt/" + GC_LINUX_32 + " " + GC_LINUX_32 + "\n");
                }else MAKE_SUBTASK.put(GC_LINUX, GC_LINUX + ":\n" +
                        "\tcp prebuilt/" + GC_LINUX + " " + GC_LINUX +"\n");
            }
            break;
        }
    }
    
    /*
     * RJava's C Object
     */
    // related with dyanmic dispatching
    /* rjava class */
    public static final String COMMON_CLASS_STRUCT = "RJava_Common_Class";
    public static final String EMBED_SUPER_CLASS  = "class_header";
    public static final String SUPER_CLASS = "super_class";
    public static final String INTERFACE_LIST = "interfaces";
    public static final String CLASS_STRUCT_SUFFIX = "_class";
    public static final String CLASS_STRUCT_INSTANCE_SUFFIX = "_class_instance";
    public static final String CLASS_NAME = "class_name";
    /* rjava instance/object */
    public static final String POINTER_TO_CLASS_STRUCT = "class_struct";    // in object, pointing to its class
    public static final String EMBED_SUPER_OBJECT = "instance_header";
    public static final String COMMON_INSTANCE_STRUCT = "RJava_Common_Instance";
    /* interface */
    public static final String INTERFACE_LIST_NODE = "RJava_Interface_Node";
    public static final String INTERFACE_STRUCT_SUFFIX = "";
    public static final String INTERFACE_LIST_NODE_ATTR_NAME = "name";
    public static final String INTERFACE_LIST_NODE_ATTR_ADDR = "address";
    public static final String INTERFACE_LIST_NODE_ATTR_NEXT = "next";
    public static final String INTERFACE_LIST_NODE_ATTR_SIZE = "interface_size";
    /* mutex */
    public static final String MUTEX_TYPE = "pthread_mutex_t";
    public static final String INSTANCE_MUTEX = "instance_mutex";
    public static final String CLASS_MUTEX = "class_mutex";
    
    public static final String COND_VAR_TYPE = "pthread_cond_t";
    public static final String INSTANCE_COND_VAR = "instance_cond";
    
    CLanguageGenerator generator;
    CLanguageNameGenerator name;
    
    public CLanguageRuntime(CLanguageGenerator generator) {
        this.generator = generator;
        name = new CLanguageNameGenerator(generator);
    }    
    
    public void generateCRuntime() throws RJavaError {
        /*
         *  generating crt header
         */
        CodeStringBuilder out = new CodeStringBuilder();
        out.append("#ifndef RJAVA_CRT_H" + NEWLINE);
        out.append("#define RJAVA_CRT_H" + NEWLINE);
        
        out.append(CLanguageGenerator.commentln("c std lib"));
        for (String inc : C_STD_LIB_HEADER) {
            out.append(includeStandardHeader(inc) + NEWLINE);
        }
        
        out.append(CLanguageGenerator.commentln("some defines prior to include"));
        for (String key : RJAVA_RUNTIME_DEFINE_BEFORE_INCLUDE.keySet()) {
            out.append("#define " + key + " " + RJAVA_RUNTIME_DEFINE_BEFORE_INCLUDE.get(key) + NEWLINE);
        }
        out.append(NEWLINE);
        
        out.append(CLanguageGenerator.commentln("extra header"));
        for (String inc : EXTRA_INCLUDE) {
            out.append(inc + NEWLINE);
        }
        out.append(NEWLINE);
        
        /* some defines */
        if (RJavaCompiler.debugTarget) {
            // allow external source code to know it is debug mode
            RJAVA_RUNTIME_DEFINE.put("DEBUG_TARGET", "1");
            
            // allow programmatically insert gdb breakpoint
            RJAVA_RUNTIME_DEFINE.put("GDB_BREAKPOINT", "asm volatile(\"int3;\")");
        }
        if (RJavaCompiler.hostOS == RJavaCompiler.HOST_MACOSX) {
            RJAVA_RUNTIME_DEFINE.put("__OS_MACOSX_", "");
        } else if (RJavaCompiler.hostOS == RJavaCompiler.HOST_LINUX) {
            RJAVA_RUNTIME_DEFINE.put("__OS_LINUX_", "");
        }
        
        out.append(CLanguageGenerator.commentln("defines"));
        for (String key : RJAVA_RUNTIME_DEFINE.keySet()) {
            out.append("#define " + key + " " + RJAVA_RUNTIME_DEFINE.get(key) + NEWLINE);
        }
        out.append(NEWLINE);
        
        // class struct and interface list forward declaration
        out.append("typedef struct " + COMMON_CLASS_STRUCT + " " + COMMON_CLASS_STRUCT + SEMICOLON + NEWLINE);
        out.append("typedef struct " + INTERFACE_LIST_NODE + " " + INTERFACE_LIST_NODE + SEMICOLON + NEWLINE);
        out.append(NEWLINE);
        
        // interface list
        out.append("struct " + INTERFACE_LIST_NODE + " {" + NEWLINE);
        out.increaseIndent();
        out.append("char* " + INTERFACE_LIST_NODE_ATTR_NAME + SEMICOLON + NEWLINE);
        out.append("void* " + INTERFACE_LIST_NODE_ATTR_ADDR + SEMICOLON + NEWLINE);
        out.append("int " + INTERFACE_LIST_NODE_ATTR_SIZE + SEMICOLON + NEWLINE);
        out.append(INTERFACE_LIST_NODE + "* " + INTERFACE_LIST_NODE_ATTR_NEXT + SEMICOLON + NEWLINE);
        out.decreaseIndent();
        out.append("}" + SEMICOLON + NEWLINE);
        out.append(NEWLINE);
        
        out.append("struct " + COMMON_CLASS_STRUCT + " {" + NEWLINE);
        out.increaseIndent();
        out.append(COMMON_CLASS_STRUCT + "* " + SUPER_CLASS + SEMICOLON + NEWLINE);
        out.append(INTERFACE_LIST_NODE + "* " + INTERFACE_LIST + SEMICOLON + NEWLINE);
        out.append(MUTEX_TYPE + " " + CLASS_MUTEX + SEMICOLON + NEWLINE);
        if (RJavaCompiler.debugTarget)
            out.append("char* " + CLASS_NAME + SEMICOLON + NEWLINE);
        out.decreaseIndent();
        out.append("}" + SEMICOLON + NEWLINE);
        out.append(NEWLINE);
        
        // instance struct
        out.append("typedef struct " + COMMON_INSTANCE_STRUCT + " {" + NEWLINE);
        out.increaseIndent();
        out.append("void* " + POINTER_TO_CLASS_STRUCT + SEMICOLON + NEWLINE);
        out.append(MUTEX_TYPE + " " + INSTANCE_MUTEX + SEMICOLON + NEWLINE);
        out.append(COND_VAR_TYPE + " " + INSTANCE_COND_VAR + SEMICOLON + NEWLINE);
        out.decreaseIndent();
        out.append("} " + COMMON_INSTANCE_STRUCT + SEMICOLON + NEWLINE);
        
        out.append(NEWLINE);
        
        // types defines
        out.append(CLanguageGenerator.commentln("application type defines"));
        out.append(getTypedefs());
        out.append(NEWLINE);
        
        // helper methods
        out.append(RuntimeHelpers.signature(RuntimeHelpers.CLASS_INIT) + SEMICOLON + NEWLINE);
        for (HelperMethod method : RuntimeHelpers.CRT_HELPERS) {            
            if (method.isInline() && method.getSource() != null) {
                out.append(NEWLINE);
                out.append(CLanguageGenerator.commentln(RuntimeHelpers.signature(method)));
                out.append(RuntimeHelpers.signature(method) + " {" + NEWLINE);
                out.appendWithIndent(method.getSource());
                out.append("}" + NEWLINE + NEWLINE);
            } else {
                out.append(RuntimeHelpers.signature(method) + SEMICOLON + NEWLINE);
            }
        }
        
        out.append("#endif" + NEWLINE);
        
        generator.writeTo(out.toString(), RJavaCompiler.outputDir + RJAVA_CRT + ".h");
        
        /*
         *  generating runtime source - for class init()
         */
        CodeStringBuilder crtSource = new CodeStringBuilder();
        crtSource.append(includeNonStandardHeader(RJAVA_CRT + ".h") + NEWLINE);
        crtSource.append(includeNonStandardHeader(RJAVA_LIB + ".h") + NEWLINE);
        for (String app : generator.getTranslatedCHeader()) {
            crtSource.append(includeNonStandardHeader(app) + NEWLINE);
        }
        crtSource.append(NEWLINE);
        
        // void rjava_class_init()
        crtSource.append(RuntimeHelpers.signature(RuntimeHelpers.CLASS_INIT) + " {" + NEWLINE);
        crtSource.increaseIndent();
        crtSource.append(getRuntimeInitCode());
        crtSource.append(NEWLINE);
        crtSource.append(RuntimeHelpers.invoke(RuntimeHelpers.LIB_INIT, null) + SEMICOLON + NEWLINE);
        crtSource.append(getClassInitMethodBody());
        crtSource.decreaseIndent();
        crtSource.append("}" + NEWLINE);
        
        // runtime helpers
        for (HelperMethod method : RuntimeHelpers.CRT_HELPERS) {
            if (method.getSource() != null && !method.isInline()) {
                crtSource.append(NEWLINE);
                crtSource.append(CLanguageGenerator.commentln(RuntimeHelpers.signature(method)));
                crtSource.append(RuntimeHelpers.signature(method) + " {" + NEWLINE);
                crtSource.appendWithIndent(method.getSource());
                crtSource.append("}" + NEWLINE);
            }
        }
        generator.writeTo(crtSource.toString(), RJavaCompiler.outputDir + RJAVA_CRT + ".c");
    }
    
    public String getRuntimeInitCode() {
        CodeStringBuilder init = new CodeStringBuilder();
        
        init.append(CLanguageGenerator.commentln("init runtime"));
        
        if (MEMORY_MANAGEMENT_SCHEME == GC_MALLOC || MEMORY_MANAGEMENT_SCHEME == GC_MALLOC_PREBUILT) {
            init.append("GC_init()" + SEMICOLON + NEWLINE);
        }
        
        init.append(RuntimeHelpers.invoke(RuntimeHelpers.INIT_THREAD_SUSPENDING, null) + SEMICOLON + NEWLINE);
        
        return init.toString();
    }

    public void copyJavaLibrary() throws RJavaError {
        // copy lib files
        try {
            FileUtils.copyDirectory(new File(RJavaCompiler.rjava_clib), new File(RJavaCompiler.outputDir), false);
            Runtime.getRuntime().exec("chmod -R 777 " + RJavaCompiler.outputDir);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RJavaError("Error when copying lib files: " + e.getMessage());
        }
    }

    public void generateGNUMakefile() throws RJavaError {
        String C_FLAGS = (RJavaCompiler.debugTarget ? "-g " : "-O3 ") + (RJavaCompiler.m32 ? "-m32 " : "");
        if (RJavaCompiler.hostOS == RJavaCompiler.HOST_MACOSX)
            C_FLAGS += "-lpthread ";
        else if (RJavaCompiler.hostOS == RJavaCompiler.HOST_LINUX)
            C_FLAGS += "-pthread -lrt -lm ";
        C_FLAGS += "-std=gnu99 ";
        
        
        /*
         *  generate makefile
         */
        CodeStringBuilder makeFile = new CodeStringBuilder();
        
        makeFile.append("# Make file generated by RJava Compiler" + NEWLINE);
        makeFile.append(NEWLINE);
        
        makeFile.append("ifneq (,)" + NEWLINE);
        makeFile.append("This makefile requires GNU Make." + NEWLINE);
        makeFile.append("endif" + NEWLINE);
        makeFile.append(NEWLINE);

        // are we generating library?
        boolean library = (generator.getMainObj() == null);
        
        // general settings/flags
        makeFile.append(library ? "PROGRAM = lib" : "PROGRAM = " + generator.getMainObj());
        makeFile.append(NEWLINE);
        makeFile.append("C_FILES := $(wildcard *.c)" + NEWLINE);
        makeFile.append("OBJS := $(patsubst %.c, %.o, $(C_FILES))" + NEWLINE);
        makeFile.append("CC = gcc" + NEWLINE);
        makeFile.append("CFLAGS = " + C_FLAGS + NEWLINE);
        makeFile.append("LDFLAGS = " + NEWLINE);
        makeFile.append(NEWLINE);
        
        makeFile.append("all: $(PROGRAM)" + NEWLINE);
        makeFile.append(NEWLINE);
        
        // main obj
        makeFile.append("$(PROGRAM): .depend $(OBJS) ");
        String libs = "";
        for (String lib : MAKE_SUBTASK.keySet())
            libs += lib + " ";
        makeFile.append(libs + NEWLINE);
        makeFile.append("\t$(CC) $(CFLAGS) $(OBJS) " + libs + "$(LDFLAGS) ");
        makeFile.append(library ? "-c -fPIC" : "-o $(PROGRAM)");
        makeFile.append(NEWLINE);
        makeFile.append(NEWLINE);
        
        // generating dependency
        makeFile.append("depend: .depend" + NEWLINE);
        makeFile.append(NEWLINE);
        
        makeFile.append(".depend: cmd = gcc -MM -MF depend $(var); cat depend >> .depend;" + NEWLINE);
        makeFile.append(".depend:" + NEWLINE);
        makeFile.append("\t@echo \"Generating dependencies...\"" + NEWLINE);
        makeFile.append("\t$(foreach var, $(C_FILES), $(cmd))" + NEWLINE);
        makeFile.append("\t@rm -f depend" + NEWLINE);
        makeFile.append(NEWLINE);
        
        makeFile.append("-include .depend" + NEWLINE);
        makeFile.append(NEWLINE);
        
        // compiling all c files
        makeFile.append("%.o: %.c" + NEWLINE);
        makeFile.append("\t$(CC) $(CFLAGS) -c $< -o $@" + NEWLINE);
        makeFile.append(NEWLINE);
        
        makeFile.append("%: %.c" + NEWLINE);
        makeFile.append("\t$(CC) $(CFLAGS) -o $@ $<" + NEWLINE);
        makeFile.append(NEWLINE);
        
        // clean
        makeFile.append("clean:" + NEWLINE);
        makeFile.append("\trm -f .depend *.o" + NEWLINE);
        makeFile.append(NEWLINE);
        
        makeFile.append(".PHONY: clean depend" + NEWLINE);

        // library build
        for (String lib : MAKE_SUBTASK.keySet()) {
            makeFile.append(MAKE_SUBTASK.get(lib));
        }
        
        generator.writeTo(makeFile.toString(), RJavaCompiler.outputDir + "Makefile");
    }
    
    private String getClassInitMethodBody() {
        CodeStringBuilder body = new CodeStringBuilder();
        
        // init c struct for those classes
        for (Tree<RClass> root : SemanticMap.hierarchy.getRoots()) {
            TreeBreadthFirstIterator<RClass> iter = root.getBreadthFirstIterator();
            while (iter.hasNext()) {
                RClass current = iter.next();
                if (generator.getClassInitMap().containsKey(current.getName())) {
                    body.append(CLanguageGenerator.commentln("init for " + name.get(current)));
                    body.append(generator.getClassInitMap().get(current.getName()).toString());
                    body.append("\n\n");
                }
            }
        }
        
        // calling <clinit> for those classes        
        body.append(CLanguageGenerator.commentln("calling <clinit> for RJava classes"));
        for (RClass klass : SemanticMap.dependencyGraph.getClassInitializationOrder()) {
            if (klass.getCLInitMethod() != null) {
                body.append(name.get(klass.getCLInitMethod()) + "();\n");
            }
        }

        return body.toString();
    }
    
    /**
     * (R)Java types may use each other, but C is compiled top-down. Thus we typedefine all the types in advance to avoid warnings. 
     */
    private ArrayList<String> RJavaCStructType = new ArrayList<String>();
    public void addTypedef(String type) {
        RJavaCStructType.add(type);
    }
    private String getTypedefs() {
        CodeStringBuilder defs = new CodeStringBuilder();
        for (String typedef : RJavaCStructType) {
            defs.append("struct " + typedef + SEMICOLON + NEWLINE);
            defs.append("typedef struct " + typedef + " " + typedef + SEMICOLON + NEWLINE);
            defs.append("struct " + typedef + CLASS_STRUCT_SUFFIX + SEMICOLON + NEWLINE);
            defs.append("typedef struct " + typedef + CLASS_STRUCT_SUFFIX + " " + typedef + CLASS_STRUCT_SUFFIX + SEMICOLON + NEWLINE);
        }
        return defs.toString();
    }
    

    
    /**
     * #include <header>
     * @param header
     * @return
     */
    public static String includeStandardHeader(String header) {
        return "#include <" + header + ">";
    }
    
    /**
     * #include "header"
     * @param header
     * @return
     */
    public static String includeNonStandardHeader(String header) {
        return "#include \"" + header + "\"";
    }
}
