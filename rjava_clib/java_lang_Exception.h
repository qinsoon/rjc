#ifndef JAVA_LANG_EXCEPTION_H
#define JAVA_LANG_EXCEPTION_H

typedef struct java_lang_Exception {
	java_lang_Object instance_header;
} java_lang_Exception;

typedef struct java_lang_Exception_class {
	java_lang_Object_class class_header;
} java_lang_Exception_class;

java_lang_Exception_class java_lang_Exception_class_instance;
#endif