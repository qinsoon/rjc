#include "java_lang_StringBuffer.h"

java_lang_StringBuffer* java_lang_StringBuffer_append_java_lang_Object(java_lang_StringBuffer* this_parameter, void* obj) {
    int16_t* str;
    int str_size;
    
    if (obj == NULL) {
        str = from_c_char_array("NULL");
        str_size = 4;
    }
    else {
        java_lang_String* appendStr
            = ((java_lang_Object_class*)(((RJava_Common_Instance*)obj) -> class_struct)) -> toString(obj);
        str_size = appendStr->count;
        str = appendStr->internal;
    }
    
    int size_needed = (str_size + this_parameter->curr_buffer_used);
    int old_used = this_parameter->curr_buffer_used;
    
    if (size_needed > this_parameter->curr_buffer_size) {
        printf("need to expand\n");
        int16_t* old_buff = this_parameter->internal;

        int new_size = this_parameter->curr_buffer_size * 2;
        while (new_size < size_needed)
            new_size = new_size * 2;
        
        this_parameter->internal = (int16_t*) malloc(sizeof(int16_t) * new_size);
        this_parameter->curr_buffer_size = new_size;

        memcpy(this_parameter->internal, old_buff, old_used * sizeof(int16_t));
    }
    
    int i = 0;
    for (;i < str_size; i++) {
        this_parameter->internal[old_used + i] = str[i];
    }
    this_parameter->curr_buffer_used = size_needed;
    
    return this_parameter;
}