#ifndef JAVA_LANG_INTEGER_H
#define JAVA_LANG_INTEGER_H

#include "java_lang_Object.h"

typedef struct java_lang_Integer {
    java_lang_Object instance_header;
    int internal;
} java_lang_Integer;

typedef struct java_lang_Integer_class {
    java_lang_Object_class class_header;
} java_lang_Integer_class;

java_lang_Integer_class java_lang_Integer_class_instance;

void java_lang_Integer_rjinit_int(void* this_parameter, int i);
int java_lang_Integer_valueOf_int(int i);
char* java_lang_Integer_toString(void* this_parameter);

#endif
