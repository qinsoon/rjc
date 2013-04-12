#include <stdio.h>
#include "java_io_PrintStream.h"

inline void java_io_PrintStream_println_java_lang_String(java_io_PrintStream* this_parameter, java_lang_String* str) {
  printf("%s\n", str->internal);
}

inline void java_io_PrintStream_print_java_lang_String(java_io_PrintStream* this_parameter, java_lang_String *str) {
    printf("%s", str->internal);
}

inline void java_io_PrintStream_println(java_io_PrintStream* this_parameter){
    printf("\n");
}

inline void java_io_PrintStream_print_char(java_io_PrintStream* this_parameter, char c) {
    printf("%c", c);
}

inline void java_io_PrintStream_println_java_lang_Object(java_io_PrintStream* this_parameter, java_lang_Object* obj) {
    java_lang_String* str = ((java_lang_Object_class*)(((RJava_Common_Instance*)obj) -> class_struct)) -> toString(obj);
    printf("%s\n", str->internal);
}

inline void java_io_PrintStream_print_java_lang_Object(java_io_PrintStream* this_parameter, java_lang_Object* obj) {
    java_lang_String* str = ((java_lang_Object_class*)(((RJava_Common_Instance*)obj) -> class_struct)) -> toString(obj);
    printf("%s", str->internal);
}

inline void java_io_PrintStream_println_int32_t(java_io_PrintStream* this_parameter, int32_t i) {
    printf("%"PRId32"\n", i);
}
inline void java_io_PrintStream_print_int32_t(java_io_PrintStream* this_parameter, int32_t i) {
    printf("%"PRId32, i);
}
inline void java_io_PrintStream_println_int64_t(java_io_PrintStream* this_parameter, int64_t i) {
    printf("%"PRId64"\n", i);
}