#ifndef ORG_VMMAGIC_UNBOXED_ADDRESS_H
#define ORG_VMMAGIC_UNBOXED_ADDRESS_H

#include <limits.h>
#include <stdint.h>
#include "rjava_clib.h"

#define org_vmmagic_unboxed_Address unsigned long

#define ADDRESS_ZERO    0
#define ADDRESS_MAX     ULONG_MAX

// special values

#define org_vmmagic_unboxed_Address_zero() \
ADDRESS_ZERO

#define org_vmmagic_unboxed_Address_isZero(addr) \
(addr == ADDRESS_ZERO)

#define org_vmmagic_unboxed_Address_max() \
ADDRESS_MAX

#define org_vmmagic_unboxed_Address_isMax(addr) \
(addr == ADDRESS_MAX)

// conversions

#define org_vmmagic_unboxed_Address_fromIntSignExtend(int_val) \
(int_val >> 15 == 0) : (int_val & 0x0000ffffl) : (int_val | 0xffff0000l)

#define org_vmmagic_unboxed_Address_fromIntZeroExtend(int_val) \
int_val & 0x0000ffffl

#define org_vmmagic_unboxed_Address_fromLong(long_val) \
(unsigned long) long_val

#define org_vmmagic_unboxed_Address_toObjectReference(addr) \
addr

#define org_vmmagic_unboxed_Address_toInt(addr) \
(int) addr

#define org_vmmagic_unboxed_Address_toLong(addr) \
(long) addr

#define org_vmmagic_unboxed_Address_toWord(addr) \
(org_vmmagic_unboxed_Word) addr

// arithmetic operators

#define org_vmmagic_unboxed_Address_plus_int(addr, int_val) \
addr + int_val

#define org_vmmagic_unboxed_Address_plus_org_vmmagic_unboxed_Offset(addr, offset) \
addr + offset

#define org_vmmagic_unboxed_Address_plus_org_vmmagic_unboxed_Extent(addr, extent) \
addr + extent

#define org_vmmagic_unboxed_Address_minus_int(addr, int_val) \
addr - int_val

#define org_vmmagic_unboxed_Address_minus_org_vmmagic_unboxed_Offset(addr, offset) \
addr - offset

#define org_vmmagic_unboxed_Address_minus_org_vmmagic_unboxed_Extent(addr, extent) \
addr - extent

#define org_vmmagic_unboxed_Address_diff_org_vmmagic_unboxed_Address(addr, addr2) \
addr - addr2

// boolean operators

#define org_vmmagic_unboxed_Address_LT_org_vmmagic_unboxed_Address(addr, addr2) \
addr < addr2

#define org_vmmagic_unboxed_Address_LE_org_vmmagic_unboxed_Address(addr, addr2) \
addr <= addr2

#define org_vmmagic_unboxed_Address_GT_org_vmmagic_unboxed_Address(addr, addr2) \
addr > addr2

#define org_vmmagic_unboxed_Address_GE_org_vmmagic_unboxed_Address(addr, addr2) \
addr >= addr2

#define org_vmmagic_unboxed_Address_EQ_org_vmmagic_unboxed_Address(addr, addr2) \
addr == addr2

#define org_vmmagic_unboxed_Address_NE_org_vmmagic_unboxed_Address(addr, addr2) \
addr != addr2

// software prefetch

#define org_vmmagic_unboxed_Address_prefetch(addr) \
__builtin_prefetch(addr)

// memory access operators
#define org_vmmagic_unboxed_Address_loadObjectReference(addr) \
addr

#define org_vmmagic_unboxed_Address_loadObjectReference_org_vmmagic_unboxed_Offset(addr, offset) \
addr + offset

#define org_vmmagic_unboxed_Address_loadByte(addr) \
*((byte*) addr)

#define org_vmmagic_unboxed_Address_loadByte_org_vmmagic_unboxed_Offset(addr, offset) \
*((byte*) addr + offset)

#define org_vmmagic_unboxed_Address_loadChar(addr) \
*((char*) addr)

#define org_vmmagic_unboxed_Address_loadChar_org_vmmagic_unboxed_Offset(addr, offset) \
*((char*) addr + offset)

#define org_vmmagic_unboxed_Address_loadShort(addr) \
*((short*) addr)

#define org_vmmagic_unboxed_Address_loadShort_org_vmmagic_unboxed_Offset(addr, offset) \
*((short*) addr + offset)

#define org_vmmagic_unboxed_Address_loadFloat(addr) \
*((float*) addr)

#define org_vmmagic_unboxed_Address_loadFloat_org_vmmagic_unboxed_Offset(addr, offset) \
*((float*) addr, offset)

#define org_vmmagic_unboxed_Address_loadInt(addr) \
*((int*) addr)

#define org_vmmagic_unboxed_Address_loadInt_org_vmmagic_unboxed_Offset(addr, offset) \
*((int*) addr + offset)

#define org_vmmagic_unboxed_Address_loadLong(addr) \
*((long*) addr)

#define org_vmmagic_unboxed_Address_loadLong_org_vmmagic_unboxed_Offset(addr, offset) \
*(

#define org_vmmagic_unboxed_Address_store_int(addr, int_val) \
*((int*)addr) = int_val

#endif