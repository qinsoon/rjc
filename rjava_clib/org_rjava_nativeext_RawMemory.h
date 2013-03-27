#ifndef ORG_RJAVA_NATIVEEXT_RAWMEMORY_H
#define ORG_RJAVA_NATIVEEXT_RAWMEMORY_H

#include "org_vmmagic_unboxed_Address.h"

#define org_rjava_nativeext_RawMemory_malloc_int32_t(size) \
(org_vmmagic_unboxed_Address) malloc(size);

#endif