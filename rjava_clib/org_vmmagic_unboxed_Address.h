#ifndef ORG_VMMAGIC_UNBOXED_ADDRESS_H
#define ORG_VMMAGIC_UNBOXED_ADDRESS_H

#define org_vmmagic_unboxed_Address long

#define org_vmmagic_unboxed_Address_store_int(addr, int_val) \
*((int*)addr) = int_val

#define org_vmmagic_unboxed_Address_loadInt(addr) \
*((int*)addr)

#endif