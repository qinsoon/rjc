#ifndef ORG_RJAVA_TEST_POLY_DOG_H
#define ORG_RJAVA_TEST_POLY_DOG_H
#include "rjava_lib.h"
typedef struct org_rjava_test_poly_Dog {
/* super class field */
org_rjava_test_poly_Animal* super;
/* instance fields */
} org_rjava_test_poly_Dog;
void org_rjava_test_poly_Dog_speak (org_rjava_test_poly_Dog* this_parameter);
void org_rjava_test_poly_Dog_rjinit (org_rjava_test_poly_Dog* this_parameter);
#endif