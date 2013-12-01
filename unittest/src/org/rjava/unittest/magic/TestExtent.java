package org.rjava.unittest.magic;

import org.rjava.restriction.rulesets.RJavaCore;
import org.rjava.unittest.UnitTest;
import org.vmmagic.unboxed.Extent;

@RJavaCore
public class TestExtent extends UnitTest {

    /**
     * @param args
     */
    public static void main(String[] args) {
        start("Test Extent.fromIntSignExtend");
        check(testFromIntSignExtend());
    }

    public static boolean testFromIntSignExtend() {
        Extent ext = Extent.fromIntSignExtend(1);
        return ext == Extent.one();
    }
}
