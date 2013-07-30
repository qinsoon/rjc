#include "org_rjava_nativeext_Native.h"

#include <time.h>

double org_rjava_nativeext_Native_random() {
    srand(time(NULL));
    int r = random() % 100;
    return ((double)r) / 100;
}