#include "org_rjava_osext_OSNative.h"

#include <time.h>

double org_rjava_osext_OSNative_random() {
    srand(time(NULL));
    int r = random() % 100;
    return ((double)r) / 100;
}