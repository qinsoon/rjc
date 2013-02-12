#ifndef JAVA_LANG_STRING_H
#define JAVA_LANG_STRING_H

#include <stdbool.h>
#include <string.h>

#define RJAVA_STR char*

bool java_lang_String_equals_java_lang_Object(RJAVA_STR this_parameter, void* another);

#endif
