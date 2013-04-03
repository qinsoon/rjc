#ifndef JAVA_LANG_CLASS_H
#define JAVA_LANG_CLASS_H

#include "rjava_crt.h"
#include "java_lang_Object.h"

typedef struct java_lang_Class {
	java_lang_Object instance_header;
	
	struct RJava_Common_Class* internal;
} java_lang_Class;

typedef struct java_lang_Class_class {
    java_lang_Object_class class_header;
} java_lang_Class_class;

java_lang_Class_class java_lang_Class_class_instance;

java_lang_Class* newClassConstant(RJava_Common_Class* internal);

/* this is an intrinsic method */
java_lang_Class* java_lang_Class_forName(RJava_Common_Class* class_instance);
java_lang_Object* java_lang_Class_newInstance(java_lang_Class* this_parameter);

#endif