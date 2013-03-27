#ifndef ORG_RJAVA_NATIVEEXT_UNIXSYSCALL_H
#define ORG_RJAVA_NATIVEEXT_UNIXSYSCALL_H

#include "org_vmmagic_unboxed_Address.h"
#include "org_vmmagic_unboxed_Extent.h"
#include "org_vmmagic_unboxed_Offset.h"
#include <sys/mman.h>

#define var_org_rjava_nativeext_UnixSysCall_PROT_NONE 0
#define var_org_rjava_nativeext_UnixSysCall_PROT_READ 1
#define var_org_rjava_nativeext_UnixSysCall_PROT_WRITE 2
#define var_org_rjava_nativeext_UnixSysCall_PROT_EXEC 4

#define var_org_rjava_nativeext_UnixSysCall_MAP_PRIVATE 2
#define var_org_rjava_nativeext_UnixSysCall_MAP_FIXED 16
#define var_org_rjava_nativeext_UnixSysCall_MAP_ANOYMOUS 0x1000

#define var_org_rjava_nativeext_UnixSysCall_MAP_FAILED (uintptr_t)-1

#define org_rjava_nativeext_UnixSysCall_mmap_org_vmmagic_unboxed_Address_org_vmmagic_unboxed_Extent_int32_t_int32_t_int32_t_org_vmmagic_unboxed_Offset(start, length, prot, flags, fd, offset) \
(org_vmmagic_unboxed_Address) mmap((void*)start, length, prot, flags, fd, offset)

#endif