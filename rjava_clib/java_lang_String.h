#ifndef JAVA_LANG_STRING_H
#define JAVA_LANG_STRING_H

#include <stdbool.h>
#include <string.h>

#include "java_lang_Object.h"
#include "rjava_crt.h"

#define RJAVA_STR java_lang_String*

struct java_lang_String {
    java_lang_Object instance_header;
    char internal[10000];
};

typedef struct java_lang_String_class {
    java_lang_Object_class class_header;
} java_lang_String_class;

java_lang_String_class java_lang_String_class_instance;

inline void java_lang_String_rjinit(void* this_parameter, char* str);
inline java_lang_String* newStringConstant(char* string);
inline bool java_lang_String_equals_java_lang_Object(void* this_parameter, void* another);
inline java_lang_String* java_lang_String_toString(void* this_parameter);
inline char java_lang_String_charAt_int32_t(void* this_parameter, int32_t index);
inline void java_lang_String_rjinit_java_lang_String(void* this_parameter, java_lang_String* str);
inline int32_t java_lang_String_length(void* this_parameter);
inline byte* java_lang_String_getBytes(void* this_parameter);

java_lang_String* java_lang_String_substring_int32_t(void* this_parameter, int32_t index);
java_lang_String* java_lang_String_substring_int32_t_int32_t(void* this_parameter, int32_t start, int32_t end);

inline int32_t java_lang_String_indexOf_int32_t(void* this_parameter, int32_t ch);
inline int32_t java_lang_String_indexOf_int32_t_int32_t(void* this_parameter, int32_t ch, int32_t from);
java_lang_String* java_lang_String_toLowerCase(void* this_parameter);

#endif
