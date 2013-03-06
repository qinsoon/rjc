#ifndef JAVA_LANG_CLASS_H
#define JAVA_LANG_CLASS_H

#include "rjava_crt.h"

typedef struct java_lang_Class {
	RJava_Common_Instance instance_header;
	
	struct RJava_Common_Class* internal;
} java_lang_Class;

typedef struct java_lang_Class_class {
	RJava_Common_Class class_header;
} java_lang_Class_class;

java_lang_Class_class java_lang_Class_class_instance;

#endif