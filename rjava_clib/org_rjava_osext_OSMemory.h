#ifndef ORG_RJAVA_OSEXT_OSMEMORY_H
#define ORG_RJAVA_OSEXT_OSMEMORY_H

#include "org_vmmagic_unboxed_Address.h"
#include "org_vmmagic_unboxed_Extent.h"
#include "org_vmmagic_unboxed_Offset.h"
#include <sys/mman.h>
#include <string.h>

#define var_org_rjava_osext_OSMemory_PROT_NONE 0
#define var_org_rjava_osext_OSMemory_PROT_READ 1
#define var_org_rjava_osext_OSMemory_PROT_WRITE 2
#define var_org_rjava_osext_OSMemory_PROT_EXEC 4

#define var_org_rjava_osext_OSMemory_MAP_PRIVATE 2
#define var_org_rjava_osext_OSMemory_MAP_FIXED 16
#define var_org_rjava_osext_OSMemory_MAP_ANOYMOUS 0x1000

#define var_org_rjava_osext_UnixSysCall_MAP_FAILED -1

#define org_rjava_osext_OSMemory_mmap_org_vmmagic_unboxed_Address_org_vmmagic_unboxed_Extent_int32_t_int32_t_int32_t_org_vmmagic_unboxed_Offset(start, length, prot, flags, fd, offset) \
(org_vmmagic_unboxed_Address) mmap((void*)start, length, prot, flags, fd, offset)

#define org_rjava_osext_OSMemory_mprotect_org_vmmagic_unboxed_Address_org_vmmagic_unboxed_Extent_int32_t(start, length, prot) \
mprotect((void*) start, length, prot)

#define org_rjava_osext_OSMemory_malloc_int32_t(size) \
(org_vmmagic_unboxed_Address) malloc(size)

#define org_rjava_osext_OSMemory_memset_org_vmmagic_unboxed_Address_int32_t_org_vmmagic_unboxed_Extent(start, c, length) \
(org_vmmagic_unboxed_Address) memset((void*) start, c, length)

#endif