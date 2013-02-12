#ifndef JAVA_LANG_OBJECT_H
#define JAVA_LANG_OBJECT_H

#include "rjava_lib.h"

typedef struct java_lang_Object java_lang_Object;
struct java_lang_Object {
  RJava_Common_Instance instance_header;
};

typedef struct java_lang_Object_class {
  RJava_Common_Class class_header;
  
  void (*rjinit)(void* this_parameter);
  bool (*equals)(void* this_parameter, java_lang_Object* obj);
  void (*finalize)(void* this_parameter);
  int (*hashcode)(void* this_parameter);
  java_lang_String* (*toString)(void* this_parameter);
  
} java_lang_Object_class;

java_lang_Object_class java_lang_Object_class_instance;

void java_lang_Object_rjinit(void* this_parameter);
bool java_lang_Object_equals_java_lang_Object(void* this_parameter, java_lang_Object* obj);
void java_lang_Object_finalize(void* this_parameter);
int java_lang_Object_hashcode(void* this_parameter);
java_lang_String* java_lang_Object_toString(void* this_parameter);

#endif