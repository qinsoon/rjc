#include "org_rjava_test_poly_Cat.h"
#include <stdio.h>

void org_rjava_test_poly_Cat_speak (org_rjava_test_poly_Cat* this_parameter) {
/* locals */
org_rjava_test_poly_Cat* this;
java_io_PrintStream* temp$0;
/* stmts */
this = this_parameter;
temp$0 = java_lang_System_out;
java_io_PrintStream_println_RJAVA_STR(temp$0, ((org_rjava_test_poly_Animal*)this_parameter) -> sound);
return;
}

void org_rjava_test_poly_Cat_rjinit (org_rjava_test_poly_Cat* this_parameter) {
/* locals */

/* stmts */
    org_rjava_test_poly_Animal_rjinit ((org_rjava_test_poly_Animal*)this_parameter);
    
    ((org_rjava_test_poly_Animal*)this_parameter) -> class_struct = &org_rjava_test_poly_Cat_class_instance;
    ((org_rjava_test_poly_Animal*)this_parameter) -> sound = "Meow!!";
return;
}
