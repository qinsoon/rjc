#include "java_lang_String.h"

bool java_lang_String_equals_java_lang_Object(RJAVA_STR this_parameter, void* another) {
    if (strcmp(this_parameter, (char*)another) == 0) {
        return true;
    } else return false;
}