#ifndef JAVA_LANG_INTERRUPTEDEXCEPTION_H
#define JAVA_LANG_INTERRUPTEDEXCEPTION_H

#include "java_lang_Exception.h"

typedef struct java_lang_InterruptedException {
	java_lang_Exception instance_header;
} java_lang_InterruptedException;

typedef struct java_lang_InterruptedException_class {
	java_lang_Exception_class class_header;
} java_lang_InterruptedException_class;

java_lang_InterruptedException_class java_lang_InterruptedException_class_intance;

#endif