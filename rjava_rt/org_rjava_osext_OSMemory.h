#ifndef ORG_RJAVA_OSEXT_OSMEMORY_H
#define ORG_RJAVA_OSEXT_OSMEMORY_H

#include "org_vmmagic_unboxed_Address.h"
#include "org_vmmagic_unboxed_Extent.h"
#include "org_vmmagic_unboxed_Offset.h"
#include <sys/mman.h>
#include <string.h>
#include "rjava_crt.h"

#define var_org_rjava_osext_OSMemory_PROT_NONE      0x0
#define var_org_rjava_osext_OSMemory_PROT_READ      0x1
#define var_org_rjava_osext_OSMemory_PROT_WRITE     0x2
#define var_org_rjava_osext_OSMemory_PROT_EXEC      0x4

#define var_org_rjava_osext_OSMemory_MAP_SHARED     0x01
#define var_org_rjava_osext_OSMemory_MAP_PRIVATE    0x02
#define var_org_rjava_osext_OSMemory_MAP_FIXED      0x10

#ifdef __OS_MACOSX_
#define var_org_rjava_osext_OSMemory_MAP_ANONYMOUS 0x1000
#else
#define var_org_rjava_osext_OSMemory_MAP_ANONYMOUS 0x20
#endif

#define var_org_rjava_osext_OSMemory_MAP_FAILED -1

#define org_rjava_osext_OSMemory_mmap_org_vmmagic_unboxed_Address_org_vmmagic_unboxed_Extent_int32_t_int32_t_int32_t_org_vmmagic_unboxed_Offset(start, length, prot, flags, fd, offset) \
(org_vmmagic_unboxed_Address) mmap((void*)start, length, prot, flags, fd, offset)

#define org_rjava_osext_OSMemory_mprotect_org_vmmagic_unboxed_Address_org_vmmagic_unboxed_Extent_int32_t(start, length, prot) \
mprotect((void*) start, length, prot)

#define org_rjava_osext_OSMemory_malloc_int32_t(size) \
(org_vmmagic_unboxed_Address) malloc(size)

#define org_rjava_osext_OSMemory_memset_org_vmmagic_unboxed_Address_int32_t_org_vmmagic_unboxed_Extent(start, c, length) \
(org_vmmagic_unboxed_Address) memset((void*) start, c, length)

#endif