#ifndef ORG_VMMAGIC_UNBOXED_OBJECTREFERENCEARRAY_H
#define ORG_VMMAGIC_UNBOXED_OBJECTREFERENCEARRAY_H
#include "boehm-gc/libatomic_ops/src/atomic_ops.h"
#include "rjava_crt.h"

#define org_vmmagic_unboxed_ObjectReferenceArray uintptr_t*

/* function definitions */
#define org_vmmagic_unboxed_ObjectReferenceArray_create_int32_t(parameter0) \
(org.vmmagic.unboxed.ObjectReference*) rjava_new_array(parameter0, sizeof(org.vmmagic.unboxed.ObjectReference))

#define org_vmmagic_unboxed_ObjectReferenceArray_get_int32_t(this_parameter,parameter0) \
rjava_access_array(this_parameter,parameter0)

#define org_vmmagic_unboxed_ObjectReferenceArray_set_int32_t_org_vmmagic_unboxed_ObjectReference(this_parameter,parameter0,parameter1) \
rjava_access_array(this_parameter,parameter0) = parameter1

#define org_vmmagic_unboxed_ObjectReferenceArray_length(this_parameter) \
rjava_length_of_array(this_parameter)

#endif