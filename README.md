The RJava Compiler (rjc) - archived
===

This is a prototype compiler for RJava (a restricted subset of Java), 
described in the workshop paper: Bypassing portability pitfalls of high-level low-level 
programming (https://dl.acm.org/citation.cfm?doid=2414740.2414746). 

The compiler was intended for two purposes:
1. to allow native execution of MMTk (https://www.jikesrvm.org/UserGuide/MMTk/index.html) outside
Java VM (JikesRVM) so that it can be reused in other projects. 
1. to enable RJava as a general implementation language without any runtime dependency on Java VM.

The compiler achieved a goal of proof of concept. The compiler can compile micro benchmarks, and
non-trivial MMTk code (~10k LOC). More details about the prototype compiler can be found 
[here](document/rjava_manual.pdf). 

The project was stopped for multiple reasons:
1. New languages such as Go and Rust emerged as better choices as system languages with
   more robust tool chains. The need for a custom-made implementation language was largely gone.
1. During the project and the attempt to port the compiled MMTk to VMKit, we realized that MMTk
   has more subtle dependency with its host VM. Simply porting its implementation language
   will not solve the problem and straightly allow us to reuse MMTk. Because of these two points, 
   the motivations for this project are mostly gone.  
1. The performance is hard to get correct. The compiler targets C. We 
   have implemented non-trivial RJava-specific front-end optimizations to general optimized C code,
   and would rely on the C compiler for backend optimizations. 
   We achieved ~60% of the stock performance, but it is not good enough to invest more time into the project.
   Besides, the approach we took was later considered to be sub-optimal 
   (in the IBM paper: https://researcher.watson.ibm.com/researcher/files/us-pengwu/oopsla12-final-dsl.pdf). 
1. It was thought that in RJava, users cannot use Java standard library. However, this does not mean
   RJava has no dependency on Java standard library, e.g. primitive types have their boxed version
   in the library. In practice, we found that still non-trivial proportion of Java standard library is 
   needed. This extends the project beyond its planned scope.  

Usage
---

1. Build RJava Compiler

   ```ant -f mybuild.xml```

    The generated files will show up in the folder 'build'. 

2. Use RJava Compiler

    Strongly suggest using the script 'rjc' in the base folder 
    instead of using the jar, which will auto generate some 
    runtime command line arguments for running the compiler. 

    Example:
     
    to compile `org.rjava.unittest.ext.TestInline.java` which 
    locates at `unittest/src/org/rjava/unittest/ext/`. 
    Use `./rjc -dir unittest/src unittest/src/org/rjava/unittest/exit/TestInline.java`. 
    Generated code can be found in `./output/`.

    Notes:
    1. To name a base directory is essential. The compiler will 
    search Java package based on the base directory. 
    2. If generating code for Mac OSX, use `-host_os mac` (default). 
    To generate code for Linux, use `-host_os linux`.
    3. Use `-m32` to generate 32bits code. 
    4. To include debug information in the binary, use `-dt`, 
    which emits debug info `-g` in gcc compilation. By default (without -dt), 
    use `-O3` in gcc compilation. 

    Example2:
    
    to compile MMTk testbed with marksweep plan. 
    Use `./rjc -dir mmtk/src:mmtk/testbed_src -l testbed_MS.list -m32`.
    Generated code can be found in `./output/`.

    The compiler will load all the files listed in `testbed_MS.list`, 
    and search those source files under the named based directory. 

3. Compile generated C code

    Enter output folder, use `make` to get binary. 
    The RJava class which contains main method will be identified,
    and the output binary will be named after it. 
    To specify another output binary name, use '-o [NAME]'
    when invoking RJava Compiler. 
