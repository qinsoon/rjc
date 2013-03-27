#ifndef ORG_VMMAGIC_UNBOXED_WORD_H
#define ORG_VMMAGIC_UNBOXED_WORD_H
#include "boehm-gc/libatomic_ops/src/atomic_ops.h"
#include "rjava_crt.h"
#include "org_vmmagic_unboxed_Offset.h"
#include "org_vmmagic_unboxed_Extent.h"

#define org_vmmagic_unboxed_Word uintptr_t

/* function definitions */
#define org_vmmagic_unboxed_Word_fromIntSignExtend_int32_t(parameter0) \
((uintptr_t) ((intptr_t)parameter0))

#define org_vmmagic_unboxed_Word_fromIntZeroExtend_int32_t(parameter0) \
((uintptr_t) ((uintptr_t)parameter0))

#define org_vmmagic_unboxed_Word_fromLong_int64_t(parameter0) \
(uintptr_t)parameter0

#define org_vmmagic_unboxed_Word_zero() \
0

#define org_vmmagic_unboxed_Word_one() \
org_vmmagic_unboxed_Word_fromIntSignExtend_int32_t(1)

#define org_vmmagic_unboxed_Word_max() \
UINTPTR_MAX

#define org_vmmagic_unboxed_Word_toInt(this_parameter) \
(uint32_t) this_parameter

#define org_vmmagic_unboxed_Word_toLong(this_parameter) \
(uint64_t) this_parameter

#define org_vmmagic_unboxed_Word_toAddress(this_parameter) \
this_parameter

#define org_vmmagic_unboxed_Word_toOffset(this_parameter) \
(intptr_t)this_parameter

#define org_vmmagic_unboxed_Word_toExtent(this_parameter) \
this_parameter

#define org_vmmagic_unboxed_Word_plus_org_vmmagic_unboxed_Word(this_parameter,parameter0) \
this_parameter + parameter0

#define org_vmmagic_unboxed_Word_plus_org_vmmagic_unboxed_Offset(this_parameter,parameter0) \
this_parameter + parameter0

#define org_vmmagic_unboxed_Word_plus_org_vmmagic_unboxed_Extent(this_parameter,parameter0) \
this_parameter + parameter0

#define org_vmmagic_unboxed_Word_minus_org_vmmagic_unboxed_Word(this_parameter,parameter0) \
this_parameter - parameter0

#define org_vmmagic_unboxed_Word_minus_org_vmmagic_unboxed_Offset(this_parameter,parameter0) \
this_parameter - parameter0

#define org_vmmagic_unboxed_Word_minus_org_vmmagic_unboxed_Extent(this_parameter,parameter0) \
this_parameter - parameter0

#define org_vmmagic_unboxed_Word_isZero(this_parameter) \
this_parameter == 0

#define org_vmmagic_unboxed_Word_isMax(this_parameter) \
this_parameter == UINTPTR_MAX

#define org_vmmagic_unboxed_Word_LT_org_vmmagic_unboxed_Word(this_parameter,parameter0) \
this_parameter < parameter0

#define org_vmmagic_unboxed_Word_LE_org_vmmagic_unboxed_Word(this_parameter,parameter0) \
this_parameter <= parameter0

#define org_vmmagic_unboxed_Word_GT_org_vmmagic_unboxed_Word(this_parameter,parameter0) \
this_parameter > parameter0

#define org_vmmagic_unboxed_Word_GE_org_vmmagic_unboxed_Word(this_parameter,parameter0) \
this_parameter >= parameter0

#define org_vmmagic_unboxed_Word_EQ_org_vmmagic_unboxed_Word(this_parameter,parameter0) \
this_parameter == parameter0

#define org_vmmagic_unboxed_Word_NE_org_vmmagic_unboxed_Word(this_parameter,parameter0) \
this_parameter != parameter0

#define org_vmmagic_unboxed_Word_and_org_vmmagic_unboxed_Word(this_parameter,parameter0) \
this_parameter & parameter0

#define org_vmmagic_unboxed_Word_or_org_vmmagic_unboxed_Word(this_parameter,parameter0) \
this_parameter | parameter0

#define org_vmmagic_unboxed_Word_not(this_parameter) \
~this_parameter

#define org_vmmagic_unboxed_Word_xor_org_vmmagic_unboxed_Word(this_parameter,parameter0) \
this_parameter ^ parameter0

#define org_vmmagic_unboxed_Word_lsh_int32_t(this_parameter,parameter0) \
this_parameter << parameter0

#define org_vmmagic_unboxed_Word_rshl_int32_t(this_parameter,parameter0) \
this_parameter >> parameter0

#define org_vmmagic_unboxed_Word_rsha_int32_t(this_parameter,parameter0) \
((intptr_t)this_parameter) >> parameter0

#endif