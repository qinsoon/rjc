#ifndef JAVA_LANG_NOCLASSDEFFOUNDERROR_H
#define JAVA_LANG_NOCLASSDEFFOUNDERROR_H

#include "java_lang_Exception.h"

typedef struct java_lang_NoClassDefFoundError {
	java_lang_Exception instance_header;
} java_lang_NoClassDefFoundError;

typedef struct java_lang_NoClassDefFoundError_class {
	java_lang_Exception_class class_header;
} java_lang_NoClassDefFoundError_class;

java_lang_NoClassDefFoundError_class java_lang_NoClassDefFoundError_class_intance;

#endif