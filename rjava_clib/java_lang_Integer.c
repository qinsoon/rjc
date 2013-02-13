#include "java_lang_Integer.h"
#include <stdio.h>
#include <stdlib.h>

void java_lang_Integer_rjinit_int(void* this_parameter, int i) {
    ((java_lang_Integer*)this_parameter) -> internal = i;
    ((RJava_Common_Instance*)this_parameter) -> class_struct = &java_lang_Integer_class_instance;
}

int java_lang_Integer_valueOf_int(int i) {
  return i;
}

java_lang_String* java_lang_Integer_toString(void* this_parameter) {
    char* ret = (char*) malloc(sizeof(char) * 50);
    sprintf(ret, "%d", ((java_lang_Integer*)this_parameter) -> internal);
    return newStringConstant(ret);
}
