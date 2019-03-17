#include "java_lang_String.h"
#include <ctype.h>
#include <stdlib.h>

java_lang_String* newStringConstant_noinline(const char* string) {
    java_lang_String* ret = (java_lang_String*) malloc(sizeof(java_lang_String));
    java_lang_String_rjinit(ret, string);
    return ret;
}

java_lang_String* java_lang_String_toString_noinline(void* this_parameter) {
    return java_lang_String_toString(this_parameter);
}

java_lang_String* java_lang_String_substring_int32_t(void* this_parameter, int32_t start) {
    return java_lang_String_substring_int32_t_int32_t(this_parameter, start, java_lang_String_length(this_parameter));
}

java_lang_String* java_lang_String_substring_int32_t_int32_t(void* this_parameter, int32_t start, int32_t end) {
    int16_t* str = ((java_lang_String*)this_parameter)->internal;
    int substr_len = end - start;
    int16_t* substr = (int16_t*) malloc(substr_len * sizeof(int16_t));
    
    int i = 0;
    for (; i < substr_len; i++) {
        substr[i] = str[start+i];
    }

    java_lang_String* ret = (java_lang_String*) malloc(sizeof(java_lang_String));
    java_lang_String_rjinit_from_int16_tarray(ret, substr_len, substr);
    return ret;
}

java_lang_String* java_lang_String_toLowerCase(void* this_parameter) {
    java_lang_String* old_str = (java_lang_String*)this_parameter;
    int16_t* lower = (int16_t*) malloc(old_str->count * sizeof(int16_t));
    
    int i = 0;
    for (; i < old_str->count; i++) {
        lower[i] = (int16_t)tolower((char)old_str->internal[i]);
    }
    
    java_lang_String* ret = (java_lang_String*) malloc(sizeof(java_lang_String));
    java_lang_String_rjinit_from_int16_tarray(ret, old_str->count, lower);
    return ret;
}

int32_t java_lang_String_indexOf_int32_t_int32_t(void* this_parameter, int32_t ch, int32_t from) {
    java_lang_String* this_str = (java_lang_String*) this_parameter;

    int i = from;
    for (; i < this_str->count; i++) {
        if (this_str->internal[i] == ch)
            return i;
    }
    
    return -1;
}
