#ifndef RJAVA_C_LIB_H
#define RJAVA_C_LIB_H

#include "java_io_PrintStream.h"
#include "java_lang_Object.h"
#include "java_lang_System.h"
#include "java_lang_StringBuffer.h"
#include "java_lang_String.h"
#include "java_lang_Integer.h"

#include "org_vmmagic_unboxed_Address.h"
#include "org_vmmagic_unboxed_AddressArray.h"
#include "org_vmmagic_unboxed_Extent.h"
#include "org_vmmagic_unboxed_ExtentArray.h"
#include "org_vmmagic_unboxed_ObjectReference.h"
#include "org_vmmagic_unboxed_ObjectReferenceArray.h"
#include "org_vmmagic_unboxed_Offset.h"
#include "org_vmmagic_unboxed_OffsetArray.h"
#include "org_vmmagic_unboxed_Word.h"
#include "org_vmmagic_unboxed_WordArray.h"

void rjava_lib_init();

#endif