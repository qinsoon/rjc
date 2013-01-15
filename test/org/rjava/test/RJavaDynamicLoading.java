package org.rjava.test;
import org.rjava.restriction.rulesets.RJavaCore;

@RJavaCore
public class RJavaDynamicLoading {
  int i;
  float f;
  
  static {
    String a = "test";
  }

  public static void main(String[] args) {
    double d = 0;
    for (int i = 0; i < 5; i++) {
	d += i;
    }
    RJavaDynamicLoading symTab = new RJavaDynamicLoading();
    symTab.foo(args);
  }
  
  public void foo(Object... objects) {
      try{
	  Class a = Class.forName("java.lang.Object");
      	  Class b = ClassLoader.getSystemClassLoader().loadClass("java.lang.Object");
      } catch (ClassNotFoundException e) {
	  e.printStackTrace();
      }
  }
}
