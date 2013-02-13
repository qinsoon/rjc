#ifndef JAVA_LANG_STRING_H
#define JAVA_LANG_STRING_H

#include <stdbool.h>
#include <string.h>

#include "java_lang_Object.h"

#define RJAVA_STR java_lang_String*

typedef struct java_lang_String {
    java_lang_Object instance_header;
    char internal[10000];
} java_lang_String;

typedef struct java_lang_String_class {
    java_lang_Object_class class_header;
} java_lang_String_class;

java_lang_String_class java_lang_String_class_instance;

java_lang_String* newStringConstant(char* string);
bool java_lang_String_equals_java_lang_Object(void* this_parameter, void* another);
java_lang_String* java_lang_String_toString(void* this_parameter);

#endif
