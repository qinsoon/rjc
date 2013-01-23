#ifndef ORG_RJAVA_TEST_POLY_CAT_H
#define ORG_RJAVA_TEST_POLY_CAT_H
#include "rjava_lib.h"
#include "org_rjava_test_poly_Animal.h"

typedef struct org_rjava_test_poly_Cat {
    void* class_struct;
} org_rjava_test_poly_Cat;

typedef struct org_rjava_test_poly_Cat_class {
    org_rjava_test_poly_Animal_class super;
} org_rjava_test_poly_Cat_class;

org_rjava_test_poly_Animal_class org_rjava_test_poly_Cat_class_instance;

void org_rjava_test_poly_Cat_speak (org_rjava_test_poly_Cat* this_parameter);
void org_rjava_test_poly_Cat_rjinit (org_rjava_test_poly_Cat* this_parameter);
#endif