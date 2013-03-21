#ifndef ORG_VMMAGIC_UNBOXED_ADDRESS_H
#define ORG_VMMAGIC_UNBOXED_ADDRESS_H
#include "boehm-gc/libatomic_ops/src/atomic_ops.h"
#include "rjava_crt.h"
#include "org_vmmagic_unboxed_Word.h"
#include "org_vmmagic_unboxed_Offset.h"
#include "org_vmmagic_unboxed_Extent.h"
#include "org_vmmagic_unboxed_ObjectReference.h"

#define org_vmmagic_unboxed_Address uintptr_t

/* function definitions */
#define org_vmmagic_unboxed_Address_zero() \
0

#define org_vmmagic_unboxed_Address_isZero(this_parameter) \
this_parameter == 0

#define org_vmmagic_unboxed_Address_max() \
UINTPTR_MAX

#define org_vmmagic_unboxed_Address_isMax(this_parameter) \
this_parameter == UINTPTR_MAX

#define org_vmmagic_unboxed_Address_fromIntSignExtend_int32_t(parameter0) \
((uintptr_t) ((intptr_t)parameter0))

#define org_vmmagic_unboxed_Address_fromIntZeroExtend_int32_t(parameter0) \
((uintptr_t) ((uintptr_t)parameter0))

#define org_vmmagic_unboxed_Address_fromLong_int64_t(parameter0) \
(uintptr_t)parameter0

#define org_vmmagic_unboxed_Address_toObjectReference(this_parameter) \
this_parameter

#define org_vmmagic_unboxed_Address_toInt(this_parameter) \
(uint32_t) this_parameter

#define org_vmmagic_unboxed_Address_toLong(this_parameter) \
(uint64_t) this_parameter

#define org_vmmagic_unboxed_Address_toWord(this_parameter) \
(org_vmmagic_unboxed_Word) this_parameter

#define org_vmmagic_unboxed_Address_plus_int32_t(this_parameter,parameter0) \
this_parameter + parameter0

#define org_vmmagic_unboxed_Address_plus_org_vmmagic_unboxed_Offset(this_parameter,parameter0) \
this_parameter + parameter0

#define org_vmmagic_unboxed_Address_plus_org_vmmagic_unboxed_Extent(this_parameter,parameter0) \
this_parameter + parameter0

#define org_vmmagic_unboxed_Address_minus_int32_t(this_parameter,parameter0) \
this_parameter - parameter0

#define org_vmmagic_unboxed_Address_minus_org_vmmagic_unboxed_Offset(this_parameter,parameter0) \
this_parameter - parameter0

#define org_vmmagic_unboxed_Address_minus_org_vmmagic_unboxed_Extent(this_parameter,parameter0) \
this_parameter - parameter0

#define org_vmmagic_unboxed_Address_diff_org_vmmagic_unboxed_Address(this_parameter,parameter0) \
this_parameter - parameter0

#define org_vmmagic_unboxed_Address_LT_org_vmmagic_unboxed_Address(this_parameter,parameter0) \
this_parameter < parameter0

#define org_vmmagic_unboxed_Address_LE_org_vmmagic_unboxed_Address(this_parameter,parameter0) \
this_parameter <= parameter0

#define org_vmmagic_unboxed_Address_GT_org_vmmagic_unboxed_Address(this_parameter,parameter0) \
this_parameter > parameter0

#define org_vmmagic_unboxed_Address_GE_org_vmmagic_unboxed_Address(this_parameter,parameter0) \
this_parameter >= parameter0

#define org_vmmagic_unboxed_Address_EQ_org_vmmagic_unboxed_Address(this_parameter,parameter0) \
this_parameter == parameter0

#define org_vmmagic_unboxed_Address_NE_org_vmmagic_unboxed_Address(this_parameter,parameter0) \
this_parameter != parameter0

#define org_vmmagic_unboxed_Address_prefetch(this_parameter) \
__builtin_prefetch((void*)this_parameter)

#define org_vmmagic_unboxed_Address_loadObjectReference(this_parameter) \
*((org_vmmagic_unboxed_ObjectReference*)this_parameter)

#define org_vmmagic_unboxed_Address_loadObjectReference_org_vmmagic_unboxed_Offset(this_parameter,parameter0) \
*((org_vmmagic_unboxed_ObjectReference*)this_parameter + parameter0)

#define org_vmmagic_unboxed_Address_loadByte(this_parameter) \
*((byte*)this_parameter)

#define org_vmmagic_unboxed_Address_loadByte_org_vmmagic_unboxed_Offset(this_parameter,parameter0) \
*((byte*)this_parameter + parameter0)

#define org_vmmagic_unboxed_Address_loadChar(this_parameter) \
*((char*)this_parameter)

#define org_vmmagic_unboxed_Address_loadChar_org_vmmagic_unboxed_Offset(this_parameter,parameter0) \
*((char*)this_parameter + parameter0)

#define org_vmmagic_unboxed_Address_loadShort(this_parameter) \
*((int16_t*)this_parameter)

#define org_vmmagic_unboxed_Address_loadShort_org_vmmagic_unboxed_Offset(this_parameter,parameter0) \
*((int16_t*)this_parameter + parameter0)

#define org_vmmagic_unboxed_Address_loadFloat(this_parameter) \
*((float*)this_parameter)

#define org_vmmagic_unboxed_Address_loadFloat_org_vmmagic_unboxed_Offset(this_parameter,parameter0) \
*((float*)this_parameter + parameter0)

#define org_vmmagic_unboxed_Address_loadInt(this_parameter) \
*((int32_t*)this_parameter)

#define org_vmmagic_unboxed_Address_loadInt_org_vmmagic_unboxed_Offset(this_parameter,parameter0) \
*((int32_t*)this_parameter + parameter0)

#define org_vmmagic_unboxed_Address_loadLong(this_parameter) \
*((int64_t*)this_parameter)

#define org_vmmagic_unboxed_Address_loadLong_org_vmmagic_unboxed_Offset(this_parameter,parameter0) \
*((int64_t*)this_parameter + parameter0)

#define org_vmmagic_unboxed_Address_loadDouble(this_parameter) \
*((double*)this_parameter)

#define org_vmmagic_unboxed_Address_loadDouble_org_vmmagic_unboxed_Offset(this_parameter,parameter0) \
*((double*)this_parameter + parameter0)

#define org_vmmagic_unboxed_Address_loadAddress(this_parameter) \
*((org_vmmagic_unboxed_Address*)this_parameter)

#define org_vmmagic_unboxed_Address_loadAddress_org_vmmagic_unboxed_Offset(this_parameter,parameter0) \
*((org_vmmagic_unboxed_Address*)this_parameter + parameter0)

#define org_vmmagic_unboxed_Address_loadWord(this_parameter) \
*((org_vmmagic_unboxed_Word*)this_parameter)

#define org_vmmagic_unboxed_Address_loadWord_org_vmmagic_unboxed_Offset(this_parameter,parameter0) \
*((org_vmmagic_unboxed_Word*)this_parameter + parameter0)

#define org_vmmagic_unboxed_Address_store_org_vmmagic_unboxed_ObjectReference(this_parameter,parameter0) \
*((org_vmmagic_unboxed_ObjectReference*)this_parameter) = parameter0

#define org_vmmagic_unboxed_Address_store_org_vmmagic_unboxed_ObjectReference_org_vmmagic_unboxed_Offset(this_parameter,parameter0,parameter1) \
*((org_vmmagic_unboxed_ObjectReference*)this_parameter + parameter1) = parameter0

#define org_vmmagic_unboxed_Address_store_org_vmmagic_unboxed_Address(this_parameter,parameter0) \
*((org_vmmagic_unboxed_Address*)this_parameter) = parameter0

#define org_vmmagic_unboxed_Address_store_org_vmmagic_unboxed_Address_org_vmmagic_unboxed_Offset(this_parameter,parameter0,parameter1) \
*((org_vmmagic_unboxed_Address*)this_parameter + parameter1) = parameter0

#define org_vmmagic_unboxed_Address_store_float(this_parameter,parameter0) \
*((float*)this_parameter) = parameter0

#define org_vmmagic_unboxed_Address_store_float_org_vmmagic_unboxed_Offset(this_parameter,parameter0,parameter1) \
*((float*)this_parameter + parameter1) = parameter0

#define org_vmmagic_unboxed_Address_store_org_vmmagic_unboxed_Word(this_parameter,parameter0) \
*((org_vmmagic_unboxed_Word*)this_parameter) = parameter0

#define org_vmmagic_unboxed_Address_store_org_vmmagic_unboxed_Word_org_vmmagic_unboxed_Offset(this_parameter,parameter0,parameter1) \
*((org_vmmagic_unboxed_Word*)this_parameter + parameter1) = parameter0

#define org_vmmagic_unboxed_Address_store_bool(this_parameter,parameter0) \
*((bool*)this_parameter) = parameter0

#define org_vmmagic_unboxed_Address_store_bool_org_vmmagic_unboxed_Offset(this_parameter,parameter0,parameter1) \
*((bool*)this_parameter + parameter1) = parameter0

#define org_vmmagic_unboxed_Address_store_byte(this_parameter,parameter0) \
*((byte*)this_parameter) = parameter0

#define org_vmmagic_unboxed_Address_store_byte_org_vmmagic_unboxed_Offset(this_parameter,parameter0,parameter1) \
*((byte*)this_parameter + parameter1) = parameter0

#define org_vmmagic_unboxed_Address_store_int32_t(this_parameter,parameter0) \
*((int32_t*)this_parameter) = parameter0

#define org_vmmagic_unboxed_Address_store_int32_t_org_vmmagic_unboxed_Offset(this_parameter,parameter0,parameter1) \
*((int32_t*)this_parameter + parameter1) = parameter0

#define org_vmmagic_unboxed_Address_store_double(this_parameter,parameter0) \
*((double*)this_parameter) = parameter0

#define org_vmmagic_unboxed_Address_store_double_org_vmmagic_unboxed_Offset(this_parameter,parameter0,parameter1) \
*((double*)this_parameter + parameter1) = parameter0

#define org_vmmagic_unboxed_Address_store_int64_t(this_parameter,parameter0) \
*((int64_t*)this_parameter) = parameter0

#define org_vmmagic_unboxed_Address_store_int64_t_org_vmmagic_unboxed_Offset(this_parameter,parameter0,parameter1) \
*((int64_t*)this_parameter + parameter1) = parameter0

#define org_vmmagic_unboxed_Address_store_char(this_parameter,parameter0) \
*((char*)this_parameter) = parameter0

#define org_vmmagic_unboxed_Address_store_char_org_vmmagic_unboxed_Offset(this_parameter,parameter0,parameter1) \
*((char*)this_parameter + parameter1) = parameter0

#define org_vmmagic_unboxed_Address_store_int16_t(this_parameter,parameter0) \
*((int16_t*)this_parameter) = parameter0

#define org_vmmagic_unboxed_Address_store_int16_t_org_vmmagic_unboxed_Offset(this_parameter,parameter0,parameter1) \
*((int16_t*)this_parameter + parameter1) = parameter0

#define org_vmmagic_unboxed_Address_prepareWord(this_parameter) \
*((org_vmmagic_unboxed_Word*)this_parameter)

#define org_vmmagic_unboxed_Address_prepareWord_org_vmmagic_unboxed_Offset(this_parameter,parameter0) \
*((org_vmmagic_unboxed_Word*)this_parameter + parameter0)

#define org_vmmagic_unboxed_Address_prepareObjectReference(this_parameter) \
*((org_vmmagic_unboxed_ObjectReference*)this_parameter)

#define org_vmmagic_unboxed_Address_prepareObjectReference_org_vmmagic_unboxed_Offset(this_parameter,parameter0) \
*((org_vmmagic_unboxed_ObjectReference*)this_parameter + parameter0)

#define org_vmmagic_unboxed_Address_prepareAddress(this_parameter) \
*((org_vmmagic_unboxed_Address*)this_parameter)

#define org_vmmagic_unboxed_Address_prepareAddress_org_vmmagic_unboxed_Offset(this_parameter,parameter0) \
*((org_vmmagic_unboxed_Address*)this_parameter + parameter0)

#define org_vmmagic_unboxed_Address_prepareInt(this_parameter) \
*((int32_t*)this_parameter)

#define org_vmmagic_unboxed_Address_prepareInt_org_vmmagic_unboxed_Offset(this_parameter,parameter0) \
*((int32_t*)this_parameter + parameter0)

#define org_vmmagic_unboxed_Address_attempt_int32_t_int32_t(this_parameter,parameter0,parameter1) \
__sync_bool_compare_and_swap( (int32_t*)this_parameter,parameter0,parameter1)

#define org_vmmagic_unboxed_Address_attempt_int32_t_int32_t_org_vmmagic_unboxed_Offset(this_parameter,parameter0,parameter1,parameter2) \
__sync_bool_compare_and_swap( (int32_t*)this_parameter + parameter2,parameter0,parameter1)

#define org_vmmagic_unboxed_Address_attempt_org_vmmagic_unboxed_Word_org_vmmagic_unboxed_Word(this_parameter,parameter0,parameter1) \
__sync_bool_compare_and_swap( (org_vmmagic_unboxed_Word*)this_parameter,parameter0,parameter1)

#define org_vmmagic_unboxed_Address_attempt_org_vmmagic_unboxed_Word_org_vmmagic_unboxed_Word_org_vmmagic_unboxed_Offset(this_parameter,parameter0,parameter1,parameter2) \
__sync_bool_compare_and_swap( (org_vmmagic_unboxed_Word*)this_parameter + parameter2,parameter0,parameter1)

#define org_vmmagic_unboxed_Address_attempt_org_vmmagic_unboxed_ObjectReference_org_vmmagic_unboxed_ObjectReference(this_parameter,parameter0,parameter1) \
__sync_bool_compare_and_swap( (org_vmmagic_unboxed_ObjectReference*)this_parameter,parameter0,parameter1)

#define org_vmmagic_unboxed_Address_attempt_org_vmmagic_unboxed_ObjectReference_org_vmmagic_unboxed_ObjectReference_org_vmmagic_unboxed_Offset(this_parameter,parameter0,parameter1,parameter2) \
__sync_bool_compare_and_swap( (org_vmmagic_unboxed_ObjectReference*)this_parameter + parameter2,parameter0,parameter1)

#define org_vmmagic_unboxed_Address_attempt_org_vmmagic_unboxed_Address_org_vmmagic_unboxed_Address(this_parameter,parameter0,parameter1) \
__sync_bool_compare_and_swap( (org_vmmagic_unboxed_Address*)this_parameter,parameter0,parameter1)

#define org_vmmagic_unboxed_Address_attempt_org_vmmagic_unboxed_Address_org_vmmagic_unboxed_Address_org_vmmagic_unboxed_Offset(this_parameter,parameter0,parameter1,parameter2) \
__sync_bool_compare_and_swap( (org_vmmagic_unboxed_Address*)this_parameter + parameter2,parameter0,parameter1)

#endif