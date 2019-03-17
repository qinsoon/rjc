#ifndef JAVA_LANG_THROWABLE_H
#define JAVA_LANG_THROWABLE_H

#include "java_lang_Object.h"

typedef struct java_lang_Throwable {
  java_lang_Object instance_header;
} java_lang_Throwable;

typedef struct java_lang_Throwable_class {
  java_lang_Object_class class_header;
} java_lang_Throwable_class;

java_lang_String* java_lang_Throwable_toString(void* this_parameter);

java_lang_Throwable_class java_lang_Throwable_class_instance;

#endif