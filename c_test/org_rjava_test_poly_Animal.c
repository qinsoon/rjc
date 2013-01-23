#include "org_rjava_test_poly_Animal.h"
#include "org_rjava_test_poly_Cat.h"
#include <stdio.h>

void org_rjava_test_poly_Animal_speak (org_rjava_test_poly_Animal* this_parameter) {
/* locals */
/* stmts */
}

void class_init() {
    (&org_rjava_test_poly_Animal_class_instance) -> speak = org_rjava_test_poly_Animal_speak;

    ((org_rjava_test_poly_Animal_class*)(&org_rjava_test_poly_Cat_class_instance)) -> super_class = &org_rjava_test_poly_Animal_class_instance;
    ((org_rjava_test_poly_Animal_class*)(&org_rjava_test_poly_Cat_class_instance)) -> speak = org_rjava_test_poly_Cat_speak;
}

int main (int argc, const char** parameter0) {
    class_init();
    
/* locals */
RJAVA_STR* args;
org_rjava_test_poly_Animal* cat;
org_rjava_test_poly_Cat* temp$0;
/* stmts */
args = parameter0;
temp$0 = (org_rjava_test_poly_Cat*) malloc(sizeof(org_rjava_test_poly_Cat));
org_rjava_test_poly_Cat_rjinit(temp$0);
cat = temp$0;
    
    ((org_rjava_test_poly_Animal_class*)(cat -> class_struct)) -> speak (cat);
    
//org_rjava_test_poly_Animal_speak(cat);
return;
}

void org_rjava_test_poly_Animal_rjinit (org_rjava_test_poly_Animal* this_parameter) {

}
