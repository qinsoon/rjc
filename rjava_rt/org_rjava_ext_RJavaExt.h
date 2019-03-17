#ifndef ORG_RJAVA_EXT_RJAVAEXT_H
#define ORG_RJAVA_EXT_RJAVAEXT_H

#include "rjava_crt.h"

#define org_rjava_ext_RJavaExt_getArrayEleAddress_java_lang_Objectarray_int32_t(arr, index) \
	rjava_access_array(arr, index)
	
#define org_rjava_ext_RJavaExt_getArrayEleAddress_org_vmmagic_unboxed_AddressArray_int32_t(arr, index) \
	rjava_access_array(arr, index)

#define org_rjava_ext_RJavaExt_getArrayEleAddress_org_vmmagic_unboxed_ObjectReferenceArray_int32_t(arr, index) \
	rjava_access_array(arr, index)

#define org_rjava_ext_RJavaExt_getArrayEleAddress_org_vmmagic_unboxed_ExtentArray_int32_t(arr, index) \
	rjava_access_array(arr, index)
	
#define org_rjava_ext_RJavaExt_getArrayEleAddress_org_vmmagic_unboxed_WordArray_int32_t(arr, index) \
	rjava_access_array(arr, index)

#define org_rjava_ext_RJavaExt_getArrayEleAddress_org_vmmagic_unboxed_OffsetArray_int32_t(arr, index) \
	rjava_access_array(arr, index)

#define org_rjava_ext_RJavaExt_getArrayEleAddress_org_vmmagic_unboxed_int32_tarray_int32_t(arr, index) \
	rjava_access_array(arr, index)

#define org_rjava_ext_RJavaExt_getArrayEleAddress_org_vmmagic_unboxed_int16_tarray_int32_t(arr, index) \
	rjava_access_array(arr, index)

#define org_rjava_ext_RJavaExt_getArrayEleAddress_org_vmmagic_unboxed_int16_tarray_int32_t(arr, index) \
	rjava_access_array(arr, index)

#define org_rjava_ext_RJavaExt_getArrayEleAddress_org_vmmagic_unboxed_int64_tarray_int32_t(arr, index) \
	rjava_access_array(arr, index)

#define org_rjava_ext_RJavaExt_getArrayEleAddress_org_vmmagic_unboxed_bytearray_int32_t(arr, index) \
	rjava_access_array(arr, index)

#define org_rjava_ext_RJavaExt_getArrayEleAddress_org_vmmagic_unboxed_floatarray_int32_t(arr, index) \
	rjava_access_array(arr, index)

#define org_rjava_ext_RJavaExt_getArrayEleAddress_org_vmmagic_unboxed_doublearray_int32_t(arr, index) \
	rjava_access_array(arr, index)

#define org_rjava_ext_RJavaExt_getArrayEleAddress_org_vmmagic_unboxed_chararray_int32_t(arr, index) \
	rjava_access_array(arr, index)

#endif