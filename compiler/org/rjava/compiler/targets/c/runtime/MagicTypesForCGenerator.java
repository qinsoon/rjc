package org.rjava.compiler.targets.c.runtime;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import org.rjava.compiler.Constants;
import org.rjava.compiler.RJavaCompiler;
import org.rjava.compiler.exception.RJavaError;
import org.rjava.compiler.semantics.representation.RClass;
import org.rjava.compiler.semantics.representation.RMethod;
import org.rjava.compiler.targets.CodeStringBuilder;
import org.rjava.compiler.targets.GeneratorOptions;
import org.rjava.compiler.targets.c.CLanguageGenerator;

public class MagicTypesForCGenerator extends CLanguageGenerator {
    public static final String[] INCLUDES = {
        "boehm-gc/libatomic_ops/src/atomic_ops.h",
        CLanguageRuntime.RJAVA_CRT + ".h"};
    
    public MagicTypesForCGenerator(GeneratorOptions generatorOptions) {
        super(generatorOptions);
    }
    
    @Override
    public void translate(RClass klass, String source) throws RJavaError {
        currentRClass = klass;
        
        assert (RJavaCompiler.isInternalCompiling() == RJavaCompiler.INTERNAL_COMPILE_MAGIC_TYPES);
        
        generateIntrinsic(klass, source);
        generateMagicTypeHeader(klass, source);
    }
    
    public static final String UNSIGNED_MAGIC_TYPE  = "uintptr_t";
    public static final String SIGNED_MAGIC_TYPE    = "intptr_t";
    
    public static final String SIGNED_MAGIC_TYPE_MAX = "INTPTR_MAX";
    public static final String UNSIGNED_MAGIC_TYPE_MAX = "UINTPTR_MAX";
    
    public static final Map<String, String> MAGIC_TYPE_TO_C_TYPE = new HashMap<String, String>();
    static {
        MAGIC_TYPE_TO_C_TYPE.put(Constants.MAGIC_ADDRESS,           UNSIGNED_MAGIC_TYPE);
        MAGIC_TYPE_TO_C_TYPE.put(Constants.MAGIC_EXTENT,            UNSIGNED_MAGIC_TYPE);
        MAGIC_TYPE_TO_C_TYPE.put(Constants.MAGIC_OBJECTREFERENCE,   UNSIGNED_MAGIC_TYPE);
        MAGIC_TYPE_TO_C_TYPE.put(Constants.MAGIC_OFFSET,            SIGNED_MAGIC_TYPE);
        MAGIC_TYPE_TO_C_TYPE.put(Constants.MAGIC_WORD,              UNSIGNED_MAGIC_TYPE);
        
        MAGIC_TYPE_TO_C_TYPE.put(Constants.MAGIC_ADDRESS + Constants.MAGIC_ARRAY_SUFFIX, UNSIGNED_MAGIC_TYPE + "*");
        MAGIC_TYPE_TO_C_TYPE.put(Constants.MAGIC_EXTENT + Constants.MAGIC_ARRAY_SUFFIX , UNSIGNED_MAGIC_TYPE + "*");
        MAGIC_TYPE_TO_C_TYPE.put(Constants.MAGIC_OBJECTREFERENCE + Constants.MAGIC_ARRAY_SUFFIX, UNSIGNED_MAGIC_TYPE + "*");
        MAGIC_TYPE_TO_C_TYPE.put(Constants.MAGIC_OFFSET + Constants.MAGIC_ARRAY_SUFFIX, SIGNED_MAGIC_TYPE + "*");
        MAGIC_TYPE_TO_C_TYPE.put(Constants.MAGIC_WORD + Constants.MAGIC_ARRAY_SUFFIX, UNSIGNED_MAGIC_TYPE + "*"); 
    }
    
    private void generateMagicTypeHeader(RClass klass, String source) throws RJavaError {
        referencedClasses = new HashSet<String>();
        
        CodeStringBuilder outInc = new CodeStringBuilder();
        CodeStringBuilder outMain = new CodeStringBuilder();
        
        cHeaderSource = getSource(source, ".h");
        
        // include guard
        outInc.append("#ifndef " + name.get(klass).toUpperCase() + "_H" + NEWLINE);
        outInc.append("#define " + name.get(klass).toUpperCase() + "_H" + NEWLINE);
        
        // include rjava lib
        for (String inc : INCLUDES) {
            outInc.append("#include \"" + inc + "\"" + NEWLINE);
        }
        
        outMain.append(NEWLINE);
        
        // define type
        String type = name.get(klass);
        String c_type = MAGIC_TYPE_TO_C_TYPE.get(klass.getName());
        outMain.append("#define " + type + " " + c_type + NEWLINE);
        
        outMain.append(NEWLINE);
        
        // functions
        outMain.append(commentln("function definitions"));
        for (RMethod method : klass.getMethods()) {
            if (method.isConstructor())
                continue;
            
            outMain.append("#define " + name.get(method) + "(");
            if (!method.isStatic()) {
                outMain.append(THIS_PARAMETER);
                if (method.getParameters().size() != 0)
                    outMain.append(",");
            }
            for (int i = 0; i < method.getParameters().size(); i++) {
                outMain.append(FORMAL_PARAMETER + i);
                if (i != method.getParameters().size() - 1)
                    outMain.append(",");
            }
            outMain.append(") \\" + NEWLINE);
            outMain.append(getCMacroFor(method));
            outMain.append(NEWLINE);
            outMain.append(NEWLINE);
        }
        
        outMain.append("#endif");
        
        // get referenced
        for (String reference : referencedClasses) {
            outInc.append("#include \"" + reference + ".h\"" + NEWLINE);
        }
        
        if (RJavaCompiler.DEBUG) {
            RJavaCompiler.debug("Header output to: " + cHeaderSource);
            RJavaCompiler.debug(outInc.toString() + outMain.toString());
        }
        
        writeTo(outInc.toString() + outMain.toString(), Constants.OUTPUT_DIR + cHeaderSource);
        
        translatedCHeader.add(cHeaderSource);
    }
    
    private String getBaseTypeForMagicArrayType(String arrayType) throws RJavaError {
        if (arrayType.endsWith(Constants.MAGIC_ARRAY_SUFFIX)) {
            return arrayType.replace(Constants.MAGIC_ARRAY_SUFFIX, "");
        }
        else throw new RJavaError("Can't find base type for " + arrayType);
    }

    private String getCMacroFor(RMethod method) throws RJavaError {
       String methodName = method.getName();
       String type = method.getKlass().getName();
       String param0 = FORMAL_PARAMETER + "0";
       String param1 = FORMAL_PARAMETER + "1";
       
       /*
        *  special values
        */
       if (methodName.equals("zero")) {
           return "0";
       }
       else if (methodName.equals("isZero")) {
           return THIS_PARAMETER + " == 0"; 
       }
       else if (methodName.equals("max")) {
           if (MAGIC_TYPE_TO_C_TYPE.get(type).equals(SIGNED_MAGIC_TYPE))
               return SIGNED_MAGIC_TYPE_MAX;
           else return UNSIGNED_MAGIC_TYPE_MAX;
       }
       else if (methodName.equals("isMax")) {
           if (MAGIC_TYPE_TO_C_TYPE.get(type).equals(SIGNED_MAGIC_TYPE))
               return THIS_PARAMETER + " == " + SIGNED_MAGIC_TYPE_MAX;
           else return THIS_PARAMETER + " == " + UNSIGNED_MAGIC_TYPE_MAX;
       }
       
       /*
        *  conversions
        */
       else if (methodName.equals("fromIntSignExtend")) {
           return param0 + " >> 31 == 0 ? " + param0 + " & 0x0000ffffl : " + param0 + " | 0xffff0000l"; 
       } 
       else if (methodName.equals("fromIntZeroExtend")) {
           return param0 + " & 0x0000ffffl";
       } 
       else if (methodName.equals("toInt")) {
           return "(uint32_t) " + THIS_PARAMETER;
       }
       else if (methodName.equals("toLong")) {
           return "(uint64_t) " + THIS_PARAMETER;
       }
       else if (methodName.equals("toWord")) {
           return "(" + name.get(method.getReturnType()) + ") " + THIS_PARAMETER;
       }
       // Address only
       else if (methodName.equals("fromLong")) {
           assert (type.equals(Constants.MAGIC_ADDRESS));
           return "(" + MAGIC_TYPE_TO_C_TYPE.get(type) + ")" + param0;
       }
       else if (methodName.equals("toObjectReference")) {
           assert (type.equals(Constants.MAGIC_ADDRESS));
           return THIS_PARAMETER;
       }
       // object reference and word
       else if (methodName.equals("toAddress")) {
           assert(type.equals(Constants.MAGIC_OBJECTREFERENCE) || type.equals(Constants.MAGIC_WORD));
           return THIS_PARAMETER;
       }
       // extend only
       else if (methodName.equals("toOffset")) {
           assert(type.equals(Constants.MAGIC_WORD));
           return "(" + SIGNED_MAGIC_TYPE + ")" + THIS_PARAMETER;
       }
       else if (methodName.equals("toExtent")) {
           assert(type.equals(Constants.MAGIC_WORD));
           return THIS_PARAMETER;
       }
       /*
        * arithmetic operators
        */
       else if (methodName.equals("plus")) {
           return THIS_PARAMETER + " + " + param0;
       }
       else if (methodName.equals("minus")) {
           return THIS_PARAMETER + " - " + param0;
       }
       else if (methodName.equals("diff")) {
           assert (type.equals(Constants.MAGIC_ADDRESS));
           return THIS_PARAMETER + " - " + param0;
       }
       
       /*
        * boolean operators
        */
       else if (methodName.equals("LT") || methodName.equals("sLT")) {
           return THIS_PARAMETER + " < " + param0;
       }
       else if (methodName.equals("LE") || methodName.equals("sLE")) {
           return THIS_PARAMETER + " <= " + param0;
       }
       else if (methodName.equals("GT") || methodName.equals("sGT")) {
           return THIS_PARAMETER + " > " + param0;
       }
       else if (methodName.equals("GE") || methodName.equals("sGE")) {
           return THIS_PARAMETER + " >= " + param0;
       }
       else if (methodName.equals("EQ")) {
           return THIS_PARAMETER + " == " + param0;
       }
       else if (methodName.equals("NE")) {
           return THIS_PARAMETER + " != " + param0;
       }
       
       /*
        * software prefetch operators
        */
       else if (methodName.equals("prefetch")) {
           assert(type.equals(Constants.MAGIC_ADDRESS));
           return "__builtin_prefetch((void*)" + THIS_PARAMETER + ")";
       }
       
       /*
        * memory access operators
        */
       else if (methodName.startsWith("load") || methodName.startsWith("prepare")) {
           String returnType = name.get(method.getReturnType());
           
           String ret = "*((" + returnType + "*)" + THIS_PARAMETER;
           if (method.getParameters().size() == 1)
               ret += " + " + param0;
           ret += ")";
           
           return ret;
       }
       else if (methodName.startsWith("store")) {
           String storeType = name.get(method.getParameters().get(0));
           
           String ret = "*((" + storeType + "*)" + THIS_PARAMETER;
           if (method.getParameters().size() == 2)
               ret += " + " + param1;
           ret += ") = " + param0;
           
           return ret;
       }
       else if (methodName.equals("attempt")) {
           String AO_CAS = "AO_compare_and_swap";
           String ret = AO_CAS + "(" + THIS_PARAMETER;
           if (method.getParameters().size() == 3)
               ret += " + " + FORMAL_PARAMETER + "2";
           ret += ",";
           ret += param0 + "," + param1 + ") != 0";
           return ret;
       }
       
       /*
        * object reference
        */
       else if (methodName.equals("fromObject")) {
           assert(type.equals(Constants.MAGIC_OBJECTREFERENCE));
           return "(" + UNSIGNED_MAGIC_TYPE + ")" + param0;
       }
       else if (methodName.equals("nullReference")) {
           assert(type.equals(Constants.MAGIC_OBJECTREFERENCE));
           return "(" + UNSIGNED_MAGIC_TYPE + ") NULL";
       }
       else if (methodName.equals("toObject")) {
           assert(type.equals(Constants.MAGIC_OBJECTREFERENCE));
           return "(void*)" + THIS_PARAMETER;
       }
       else if (methodName.equals("isNull")) {
           return THIS_PARAMETER + " == (" + UNSIGNED_MAGIC_TYPE + ") NULL";
       }
       
       /* 
        * bitwise operation. Word only
        */
       else if (methodName.equals("and")) {
           assert(type.equals(Constants.MAGIC_WORD));
           return THIS_PARAMETER + " & " + param0;
       }
       else if (methodName.equals("or")) {
           assert(type.equals(Constants.MAGIC_WORD));
           return THIS_PARAMETER + " | " + param0;
       }
       else if (methodName.equals("not")) {
           assert(type.equals(Constants.MAGIC_WORD));
           return "~" + THIS_PARAMETER;
       }
       else if (methodName.equals("xor")) {
           assert(type.equals(Constants.MAGIC_WORD));
           return THIS_PARAMETER + " ^ " + param0;
       }
       else if (methodName.equals("lsh")) {
           assert(type.equals(Constants.MAGIC_WORD));
           return THIS_PARAMETER + " << " + param0;
       }
       else if (methodName.equals("rshl")) {
           assert(type.equals(Constants.MAGIC_WORD));
           return THIS_PARAMETER + " >> " + param0;
       }
       else if (methodName.equals("rsha")) {
           assert(type.equals(Constants.MAGIC_WORD));
           return "((" + SIGNED_MAGIC_TYPE + ")" + THIS_PARAMETER + ") >> " + param0;
       }
       /*
        * array operations
        */
       else if (methodName.equals("create")) {
           assert(type.endsWith(Constants.MAGIC_ARRAY_SUFFIX));
           String base = getBaseTypeForMagicArrayType(type);
           return "(" + base + "*)" + CLanguageRuntime.invokeHelper(CLanguageRuntime.HELPER_RJAVA_NEW_ARRAY, new String[]{param0, "sizeof("+base+")"});
       }
       else if (methodName.equals("get")) {
           assert(type.endsWith(Constants.MAGIC_ARRAY_SUFFIX));
           return CLanguageRuntime.invokeHelper(CLanguageRuntime.HELPER_RJAVA_ACCESS_ARRAY, new String[]{THIS_PARAMETER, param0});
       }
       else if (methodName.equals("set")) {
           assert(type.endsWith(Constants.MAGIC_ARRAY_SUFFIX));
           return CLanguageRuntime.invokeHelper(CLanguageRuntime.HELPER_RJAVA_ACCESS_ARRAY, new String[]{THIS_PARAMETER, param0}) + " = " + param1;
       }
       else if (methodName.equals("length")) {
           assert(type.endsWith(Constants.MAGIC_ARRAY_SUFFIX));
           return CLanguageRuntime.invokeHelper(CLanguageRuntime.HELPER_RJAVA_LENGTH_OF_ARRAY, new String[]{THIS_PARAMETER});
       }
       /*
        * misc
        */
       else if (methodName.equals("one")) {
           // equivalent as XXX.fromIntSignExtend(1)
           // i.e. XXX_fromIntSignExtend_uint32_t(1);
           return name.get(method.getKlass()) + "_fromIntSignExtend_" + JAVA_INT + "(1)";
       }
       return INCOMPLETE_IMPLEMENTATION;
    }
}
