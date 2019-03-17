#ifndef JAVA_LANG_EXCEPTION_H
#define JAVA_LANG_EXCEPTION_H

#include "java_lang_Throwable.h"

typedef struct java_lang_Exception {
	java_lang_Throwable instance_header;
} java_lang_Exception;

typedef struct java_lang_Exception_class {
	java_lang_Throwable class_header;
} java_lang_Exception_class;

java_lang_Exception_class java_lang_Exception_class_instance;
#endif