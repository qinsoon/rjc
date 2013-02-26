#ifndef ORG_VMMAGIC_UNBOXED_EXTENTARRAY_H
#define ORG_VMMAGIC_UNBOXED_EXTENTARRAY_H
#include "boehm-gc/libatomic_ops/src/atomic_ops.h"
#include "rjava_crt.h"

#define org_vmmagic_unboxed_ExtentArray uintptr_t*

/* function definitions */
#define org_vmmagic_unboxed_ExtentArray_create_int32_t(parameter0) \
(org.vmmagic.unboxed.Extent*) rjava_new_array(parameter0, sizeof(org.vmmagic.unboxed.Extent))

#define org_vmmagic_unboxed_ExtentArray_get_int32_t(this_parameter,parameter0) \
rjava_access_array(this_parameter,parameter0)

#define org_vmmagic_unboxed_ExtentArray_set_int32_t_org_vmmagic_unboxed_Extent(this_parameter,parameter0,parameter1) \
rjava_access_array(this_parameter,parameter0) = parameter1

#define org_vmmagic_unboxed_ExtentArray_length(this_parameter) \
rjava_length_of_array(this_parameter)

#endif