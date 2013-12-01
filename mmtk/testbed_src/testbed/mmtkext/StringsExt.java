package testbed.mmtkext;

import org.mmtk.vm.Strings;
import org.rjava.restriction.rulesets.RJavaCore;

@RJavaCore
public class StringsExt extends Strings {

    @Override
    public void write(char[] c, int len) {
        for (int i = 0; i < len; i++)
            System.out.print(c[i]);
    }

    @Override
    public void writeThreadId(char[] c, int len) {
        write(c, len);
    }

    @Override
    public int copyStringToChars(String src, char[] dst, int dstBegin,
            int dstEnd) {
        int count = 0;
        for (int i=0; i <src.length(); i++) {
          if (dstBegin > dstEnd) break;
          dst[dstBegin] = src.charAt(i);
          dstBegin++;
          count++;
        }
        return count;
    }

}
