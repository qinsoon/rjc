#ifndef ORG_VMMAGIC_UNBOXED_OBJECTREFERENCE_H
#define ORG_VMMAGIC_UNBOXED_OBJECTREFERENCE_H
#include "boehm-gc/libatomic_ops/src/atomic_ops.h"
#include "rjava_crt.h"
#include "java_lang_Object.h"

#define org_vmmagic_unboxed_ObjectReference uintptr_t

/* function definitions */
#define org_vmmagic_unboxed_ObjectReference_fromObject_java_lang_Object(parameter0) \
(uintptr_t) parameter0

#define org_vmmagic_unboxed_ObjectReference_nullReference() \
(uintptr_t) NULL

#define org_vmmagic_unboxed_ObjectReference_toObject(this_parameter) \
((void*)this_parameter)

#define org_vmmagic_unboxed_ObjectReference_toAddress(this_parameter) \
this_parameter

#define org_vmmagic_unboxed_ObjectReference_isNull(this_parameter) \
this_parameter == (uintptr_t) NULL

#endif