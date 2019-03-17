#ifndef JAVA_LANG_RUNNABLE_H
#define JAVA_LANG_RUNNABLE_H

typedef struct java_lang_Runnable {
  void (*run) (void*);
} java_lang_Runnable;

#endif