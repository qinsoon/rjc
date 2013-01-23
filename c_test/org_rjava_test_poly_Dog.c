#include "org_rjava_test_poly_Dog.h"
#include <stdio.h>

void org_rjava_test_poly_Dog_speak (org_rjava_test_poly_Dog* this_parameter) {
/* locals */
org_rjava_test_poly_Dog* this;
java_io_PrintStream* temp$0;
/* stmts */
this = this_parameter;
temp$0 = java_lang_System_out;
java_io_PrintStream_println_RJAVA_STR(temp$0, "Woof!!");
return;
}
void org_rjava_test_poly_Dog_rjinit (org_rjava_test_poly_Dog* this_parameter) {
/* locals */
org_rjava_test_poly_Dog* this;
/* stmts */
this = this_parameter;
org_rjava_test_poly_Animal_rjinit(this);
return;
}
