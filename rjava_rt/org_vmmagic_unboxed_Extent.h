#ifndef ORG_VMMAGIC_UNBOXED_EXTENT_H
#define ORG_VMMAGIC_UNBOXED_EXTENT_H
#include "boehm-gc/libatomic_ops/src/atomic_ops.h"
#include "rjava_crt.h"
#include "org_vmmagic_unboxed_Word.h"

#define org_vmmagic_unboxed_Extent uintptr_t

/* function definitions */
#define org_vmmagic_unboxed_Extent_fromIntSignExtend_int32_t(parameter0) \
((uintptr_t) ((intptr_t)parameter0))

#define org_vmmagic_unboxed_Extent_fromIntZeroExtend_int32_t(parameter0) \
((uintptr_t) ((uintptr_t)parameter0))

#define org_vmmagic_unboxed_Extent_zero() \
0

#define org_vmmagic_unboxed_Extent_one() \
org_vmmagic_unboxed_Extent_fromIntSignExtend_int32_t(1)

#define org_vmmagic_unboxed_Extent_max() \
UINTPTR_MAX

#define org_vmmagic_unboxed_Extent_toInt(this_parameter) \
(int32_t) this_parameter

#define org_vmmagic_unboxed_Extent_toLong(this_parameter) \
(int64_t) this_parameter

#define org_vmmagic_unboxed_Extent_toWord(this_parameter) \
(org_vmmagic_unboxed_Word) this_parameter

#define org_vmmagic_unboxed_Extent_plus_int32_t(this_parameter,parameter0) \
this_parameter + parameter0

#define org_vmmagic_unboxed_Extent_plus_org_vmmagic_unboxed_Extent(this_parameter,parameter0) \
this_parameter + parameter0

#define org_vmmagic_unboxed_Extent_minus_int32_t(this_parameter,parameter0) \
this_parameter - parameter0

#define org_vmmagic_unboxed_Extent_minus_org_vmmagic_unboxed_Extent(this_parameter,parameter0) \
this_parameter - parameter0

#define org_vmmagic_unboxed_Extent_LT_org_vmmagic_unboxed_Extent(this_parameter,parameter0) \
this_parameter < parameter0

#define org_vmmagic_unboxed_Extent_LE_org_vmmagic_unboxed_Extent(this_parameter,parameter0) \
this_parameter <= parameter0

#define org_vmmagic_unboxed_Extent_GT_org_vmmagic_unboxed_Extent(this_parameter,parameter0) \
this_parameter > parameter0

#define org_vmmagic_unboxed_Extent_GE_org_vmmagic_unboxed_Extent(this_parameter,parameter0) \
this_parameter >= parameter0

#define org_vmmagic_unboxed_Extent_EQ_org_vmmagic_unboxed_Extent(this_parameter,parameter0) \
this_parameter == parameter0

#define org_vmmagic_unboxed_Extent_NE_org_vmmagic_unboxed_Extent(this_parameter,parameter0) \
this_parameter != parameter0

#endif