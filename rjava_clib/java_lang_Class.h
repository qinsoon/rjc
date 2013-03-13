#ifndef JAVA_LANG_CLASS_H
#define JAVA_LANG_CLASS_H

#include "java_lang_Object.h"
#include "rjava_crt.h"

typedef struct java_lang_Class {
	java_lang_Object instance_header;
	
	struct RJava_Common_Class* internal;
} java_lang_Class;

typedef struct java_lang_Class_class {
    java_lang_Object_class class_header;
} java_lang_Class_class;

java_lang_Class_class java_lang_Class_class_instance;

#endif