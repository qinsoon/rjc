package org.rjava.test;
import org.rjava.restriction.rulesets.RJavaCore;

@RJavaCore
public class RJavaHelloWorld {
  public static void main(String[] args) {
      String message;
      if (args.length > 0)
          message = "Hello " + args[0];
      else message = "Hello World";
      System.out.println(message);
  }
}
