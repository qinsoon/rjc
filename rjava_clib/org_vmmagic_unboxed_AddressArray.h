#ifndef ORG_VMMAGIC_UNBOXED_ADDRESSARRAY_H
#define ORG_VMMAGIC_UNBOXED_ADDRESSARRAY_H
#include "boehm-gc/libatomic_ops/src/atomic_ops.h"
#include "rjava_crt.h"

#define org_vmmagic_unboxed_AddressArray uintptr_t*

/* function definitions */
#define org_vmmagic_unboxed_AddressArray_create_int32_t(parameter0) \
(org_vmmagic_unboxed_Address*)rjava_new_array(parameter0, sizeof(org_vmmagic_unboxed_Address))

#define org_vmmagic_unboxed_AddressArray_get_int32_t(this_parameter,parameter0) \
*((org_vmmagic_unboxed_Address*)rjava_access_array(this_parameter, parameter0))

#define org_vmmagic_unboxed_AddressArray_set_int32_t_org_vmmagic_unboxed_Address(this_parameter,parameter0,parameter1) \
*((org_vmmagic_unboxed_Address*)rjava_access_array(this_parameter, parameter0)) = parameter1

#define org_vmmagic_unboxed_AddressArray_length(this_parameter) \
rjava_length_of_array(this_parameter)

#endif