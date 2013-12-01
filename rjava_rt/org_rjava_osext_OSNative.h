#ifndef ORG_RJAVA_OSEXT_OSNATIVE_H
#define ORG_RJAVA_OSEXT_OSNATIVE_H

#include "java_lang_String.h"
#include <errno.h>

#define org_rjava_osext_OSNative_errno() \
errno

#define org_rjava_osext_OSNative_strErrno() \
newStringConstant(strerror(errno))

double org_rjava_osext_OSNative_random();

#endif