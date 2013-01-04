import org.rjava.restriction.rulesets.RJavaCore;

@RJavaCore
public class RJavaSymTab {
  int i;
  float f;
  
  static {
    String a;
  }

  public static void main(String[] args) {
    double d = 0;
    for (int i = 0; i < 5; i++) {
	d += i;
    }
  }
  
  public void foo(Object... objects) {
      try{
	  Class a = Class.forName("java.lang.Object");
      } catch (ClassNotFoundException e) {
	  e.printStackTrace();
      }
  }
}
