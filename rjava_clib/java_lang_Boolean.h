#ifndef JAVA_LANG_BOOLEAN_H
#define JAVA_LANG_BOOLEAN_H

#include "java_lang_Object.h"
#include "rjava_crt.h"

typedef struct java_lang_Boolean {
    java_lang_Object instance_header;
    bool internal;
} java_lang_Boolean;

typedef struct java_lang_Boolean_class {
    java_lang_Object_class class_header;
} java_lang_Boolean_class;

java_lang_Boolean_class java_lang_Boolean_class_instance;

inline void java_lang_Boolean_rjinit_bool(void* this_parameter, bool i);
inline java_lang_Boolean* java_lang_Boolean_parseBoolean(java_lang_String* str);
inline java_lang_String* java_lang_Boolean_toString(void* this_parameter);
inline java_lang_Boolean* newBooleanConstant(bool i);

#endif
