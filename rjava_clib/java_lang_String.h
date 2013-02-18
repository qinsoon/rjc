#ifndef JAVA_LANG_STRING_H
#define JAVA_LANG_STRING_H

#include <stdbool.h>
#include <string.h>

#include "java_lang_Object.h"

#define RJAVA_STR java_lang_String*

struct java_lang_String {
    java_lang_Object instance_header;
    char internal[10000];
};

typedef struct java_lang_String_class {
    java_lang_Object_class class_header;
} java_lang_String_class;

java_lang_String_class java_lang_String_class_instance;

inline java_lang_String* newStringConstant(char* string);
inline bool java_lang_String_equals_java_lang_Object(void* this_parameter, void* another);
inline java_lang_String* java_lang_String_toString(void* this_parameter);
inline char java_lang_String_charAt_int(void* this_parameter, int index);

#endif
