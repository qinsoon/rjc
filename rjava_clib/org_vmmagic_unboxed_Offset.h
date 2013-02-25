#ifndef ORG_VMMAGIC_UNBOXED_OFFSET_H
#define ORG_VMMAGIC_UNBOXED_OFFSET_H
#include "boehm-gc/libatomic_ops/src/atomic_ops.h"
#include "rjava_crt.h"

#define org_vmmagic_unboxed_Offset intptr_t

/* function definitions */
#define org_vmmagic_unboxed_Offset_fromIntSignExtend_int32_t(parameter0) \
parameter0 >> 31 == 0 ? parameter0 & 0x0000ffffl : parameter0 | 0xffff0000l

#define org_vmmagic_unboxed_Offset_fromIntZeroExtend_int32_t(parameter0) \
parameter0 & 0x0000ffffl

#define org_vmmagic_unboxed_Offset_zero() \
0

#define org_vmmagic_unboxed_Offset_max() \
INTPTR_MAX

#define org_vmmagic_unboxed_Offset_toInt(this_parameter) \
(uint32_t) this_parameter

#define org_vmmagic_unboxed_Offset_toLong(this_parameter) \
(uint64_t) this_parameter

#define org_vmmagic_unboxed_Offset_toWord(this_parameter) \
(org_vmmagic_unboxed_Word) this_parameter

#define org_vmmagic_unboxed_Offset_plus_int32_t(this_parameter,parameter0) \
this_parameter + parameter0

#define org_vmmagic_unboxed_Offset_minus_int32_t(this_parameter,parameter0) \
this_parameter - parameter0

#define org_vmmagic_unboxed_Offset_minus_org_vmmagic_unboxed_Offset(this_parameter,parameter0) \
this_parameter - parameter0

#define org_vmmagic_unboxed_Offset_EQ_org_vmmagic_unboxed_Offset(this_parameter,parameter0) \
this_parameter == parameter0

#define org_vmmagic_unboxed_Offset_NE_org_vmmagic_unboxed_Offset(this_parameter,parameter0) \
this_parameter != parameter0

#define org_vmmagic_unboxed_Offset_sLT_org_vmmagic_unboxed_Offset(this_parameter,parameter0) \
this_parameter < parameter0

#define org_vmmagic_unboxed_Offset_sLE_org_vmmagic_unboxed_Offset(this_parameter,parameter0) \
this_parameter <= parameter0

#define org_vmmagic_unboxed_Offset_sGT_org_vmmagic_unboxed_Offset(this_parameter,parameter0) \
this_parameter > parameter0

#define org_vmmagic_unboxed_Offset_sGE_org_vmmagic_unboxed_Offset(this_parameter,parameter0) \
this_parameter >= parameter0

#define org_vmmagic_unboxed_Offset_isZero(this_parameter) \
this_parameter == 0

#define org_vmmagic_unboxed_Offset_isMax(this_parameter) \
this_parameter == INTPTR_MAX

#endif