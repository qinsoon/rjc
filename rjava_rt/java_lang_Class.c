#include "java_lang_Class.h"

java_lang_Class* newClassConstant(RJava_Common_Class* internal) {
    java_lang_Class* ret = (java_lang_Class*) malloc(sizeof(java_lang_Class));
    ret->internal = internal;
    return ret;
}

/* this is an intrinsic method */
java_lang_Class* java_lang_Class_forName(RJava_Common_Class* class_instance){
    return newClassConstant(class_instance);
}

java_lang_Object* java_lang_Class_newInstance(java_lang_Class* this_parameter) {
    return 0;
}