#ifndef ORG_RJAVA_TEST_POLY_ANIMAL_H
#define ORG_RJAVA_TEST_POLY_ANIMAL_H
#include "rjava_lib.h"
typedef struct org_rjava_test_poly_Animal {
    void* class_struct;
    char* sound;
} org_rjava_test_poly_Animal;

typedef struct org_rjava_test_poly_Animal_class {
    void* super_class;
    void (*speak) (org_rjava_test_poly_Animal* this_parameter);
} org_rjava_test_poly_Animal_class;

org_rjava_test_poly_Animal_class org_rjava_test_poly_Animal_class_instance;

void org_rjava_test_poly_Animal_speak (org_rjava_test_poly_Animal* this_parameter);
void org_rjava_test_poly_Animal_rjinit (org_rjava_test_poly_Animal* this_parameter);
#endif