#ifndef JAVA_IO_PRINTSTREAM_H
#define JAVA_IO_PRINTSTREAM_H

#include "java_lang_String.h"
#include "java_lang_Object.h"
#include "rjava_crt.h"

typedef struct java_io_PrintStream {
} java_io_PrintStream;

inline void java_io_PrintStream_println_java_lang_String(java_io_PrintStream* this_parameter, java_lang_String *str);
inline void java_io_PrintStream_println(java_io_PrintStream* this_parameter);
inline void java_io_PrintStream_println_java_lang_Object(java_io_PrintStream* this_parameter, java_lang_Object* obj);
inline void java_io_PrintStream_println_int32_t(java_io_PrintStream* this_parameter, int32_t i);
inline void java_io_PrintStream_println_int64_t(java_io_PrintStream* this_parameter, int64_t i);
inline void java_io_PrintStream_println_double(java_io_PrintStream* this_parameter, double d);
inline void java_io_PrintStream_println_float(java_io_PrintStream* this_parameter, float f);

inline void java_io_PrintStream_print_java_lang_Object(java_io_PrintStream* this_parameter, java_lang_Object* obj);
inline void java_io_PrintStream_print_java_lang_String(java_io_PrintStream* this_parameter, java_lang_String *str);
inline void java_io_PrintStream_print_char(java_io_PrintStream* this_parameter, char c);
inline void java_io_PrintStream_print_int32_t(java_io_PrintStream* this_parameter, int32_t i);
inline void java_io_PrintStream_print_double(java_io_PrintStream* this_parameter, double d);
inline void java_io_PrintStream_print_float(java_io_PrintStream* this_parameter, float f);

#endif