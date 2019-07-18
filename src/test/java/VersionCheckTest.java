package test.java;

import etc.VersionCheck;
import org.junit.Test;

public class VersionCheckTest {
    private VersionCheck versionCheck;

    public VersionCheckTest() {
        this.versionCheck = new VersionCheck();
    }

    @Test
    public void diffCheck(){
        String solution1 = versionCheck.Solution2("0.0.2", "0.0.1");
        String solution2 = versionCheck.Solution2("1.0.10", "1.0.3");
        String solution3 = versionCheck.Solution2("1.2.0", "1.1.99");
        String solution4 = versionCheck.Solution2("1.1", "1.0.1");

        // 1.0 - 1.0.1

        System.out.println(solution1);
        System.out.println(solution2);
        System.out.println(solution3);
        System.out.println(solution4);
    }
}
