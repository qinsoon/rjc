#ifndef JAVA_IO_PRINTSTREAM_H
#define JAVA_IO_PRINTSTREAM_H

#include "java_lang_String.h"
#include "java_lang_Object.h"
#include "rjava_crt.h"
#include <stdio.h>

typedef struct java_io_PrintStream {
} java_io_PrintStream;

RJAVA_ALWAYS_INLINE void java_io_PrintStream_print_java_lang_String(java_io_PrintStream* this_parameter, java_lang_String *str) {
    printf("%s", to_c_char_array(str));
}

RJAVA_ALWAYS_INLINE void java_io_PrintStream_println_java_lang_String(java_io_PrintStream* this_parameter, java_lang_String* str) {
    java_io_PrintStream_print_java_lang_String(this_parameter, str);
    printf("\n");
}

RJAVA_ALWAYS_INLINE void java_io_PrintStream_println(java_io_PrintStream* this_parameter){
    printf("\n");
}

RJAVA_ALWAYS_INLINE void java_io_PrintStream_print_int16_t(java_io_PrintStream* this_parameter, int16_t c) {
    printf("%c", (char)c);
}

RJAVA_ALWAYS_INLINE void java_io_PrintStream_println_int16_t(java_io_PrintStream* this_parameter, int16_t c) {
    java_io_PrintStream_print_int16_t(this_parameter, c);
    printf("\n");
}

RJAVA_ALWAYS_INLINE void java_io_PrintStream_print_java_lang_Object(java_io_PrintStream* this_parameter, java_lang_Object* obj) {
    java_lang_String* str = ((java_lang_Object_class*)(((RJava_Common_Instance*)obj) -> class_struct)) -> toString(obj);
    printf("%s", to_c_char_array(str));
}

RJAVA_ALWAYS_INLINE void java_io_PrintStream_println_java_lang_Object(java_io_PrintStream* this_parameter, java_lang_Object* obj) {
    java_io_PrintStream_print_java_lang_Object(this_parameter, obj);
    printf("\n");
}

RJAVA_ALWAYS_INLINE void java_io_PrintStream_print_int32_t(java_io_PrintStream* this_parameter, int32_t i) {
    printf("%"PRId32, i);
}

RJAVA_ALWAYS_INLINE void java_io_PrintStream_println_int32_t(java_io_PrintStream* this_parameter, int32_t i) {
    java_io_PrintStream_print_int32_t(this_parameter, i);
    printf("\n");
}

RJAVA_ALWAYS_INLINE void java_io_PrintStream_print_int64_t(java_io_PrintStream* this_parameter, int64_t i) {
    printf("%"PRId64, i);
}


RJAVA_ALWAYS_INLINE void java_io_PrintStream_println_int64_t(java_io_PrintStream* this_parameter, int64_t i) {
    java_io_PrintStream_print_int64_t(this_parameter, i);
    printf("\n");
}

RJAVA_ALWAYS_INLINE void java_io_PrintStream_print_double(java_io_PrintStream* this_parameter, double d) {
    printf("%f", d);
}

RJAVA_ALWAYS_INLINE void java_io_PrintStream_println_double(java_io_PrintStream* this_parameter, double d) {
    java_io_PrintStream_print_double(this_parameter, d);
    printf("\n");
}

RJAVA_ALWAYS_INLINE void java_io_PrintStream_print_float(java_io_PrintStream* this_parameter, float f) {
    printf("%f",  f);
}

RJAVA_ALWAYS_INLINE void java_io_PrintStream_println_float(java_io_PrintStream* this_parameter, float f) {
    java_io_PrintStream_print_float(this_parameter, f);
    printf("\n");
}

#endif
