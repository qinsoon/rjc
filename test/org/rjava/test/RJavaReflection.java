package org.rjava.test;
import java.lang.reflect.Field;

import org.rjava.restriction.rulesets.RJavaCore;

@RJavaCore
public class RJavaReflection {
  public static void main(String[] args) {
      // 1. any method that returns a class is forbidden
      
      // trying to get class
      Class a = "a string".getClass();      
      try {
        Class c = Class.forName("java.lang.Object");
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    }
      
      // getting primitive type
      Class d = Double.TYPE;
      
      // 2. .class is forbidden
      Class b = Object.class;
      
      // 3. any use of java.lang.reflect.* is forbidden
      Field[] f = a.getFields();
  }
}
