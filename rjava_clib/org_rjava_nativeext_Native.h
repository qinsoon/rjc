#ifndef ORG_RJAVA_NATIVEEXT_NATIVE_H
#define ORG_RJAVA_NATIVEEXT_NATIVE_H

#include "java_lang_String.h"
#include <errno.h>

#define org_rjava_nativeext_Native_errno() \
errno

#define org_rjava_nativeext_Native_strErrno() \
newStringConstant(strerror(errno))

#endif