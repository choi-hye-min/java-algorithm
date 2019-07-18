package etc;

/**
 * 최신 버전 비교하기
 * 0.0.2 > 0.0.1
 * 1.0.10 > 1.0.3
 * 1.2.0 > 1.1.99
 * 1.1 > 1.0.1
 */
public class VersionCheck {
    public static void main(String[] args){
        VersionCheck versionCheck = new VersionCheck();
        int solution = versionCheck.SolutionRecusiv("1.0".split("\\."), 0, "1.0.1".split("\\."), 0);
        System.out.println(solution);
    }

    // fail solution
    public String Solution(String version1, String version2){
        String symbol = "<";
        String replaceVersion1 = version1.replace(".", "");
        String replaceVersion2 = version2.replace(".", "");

        int minLength = replaceVersion1.length() > replaceVersion2.length() ? replaceVersion2.length() : replaceVersion1.length();

        if(Integer.parseInt(replaceVersion1.substring(0, minLength)) >= Integer.parseInt(replaceVersion2.substring(0, minLength))){
            symbol = ">";
        }

        return version1+" "+symbol+" "+version2;
    }

    // success
    public String Solution2(String version1, String version2){
        String[] split1 = version1.split("\\.");
        String[] split2 = version2.split("\\.");

        int minVersionSize = split1.length > split2.length ? split2.length : split1.length;
        int versionFlagCount = 0;

        for (int i = 0; i < minVersionSize; i++) {
            if (Integer.parseInt(split1[i]) >= Integer.parseInt(split2[i])) {
                versionFlagCount++;
            }else{
                versionFlagCount--;
            }
        }

        String symbol = versionFlagCount >= 0 ? ">" : "<";

        return version1+" "+symbol+" "+version2;
    }

    // by.mik
    private int SolutionRecusiv(String[] version1, int index1, String[] version2, int index2) {
        // validation
        if (version1.length == index1 && version2.length == index2)
            return 0;
        if (version1.length > index1 && version2.length == index2)
            return 1;
        if (version1.length == index1 && version2.length > index2)
            return -1;

        // 1 base condition
        int v1 = Integer.valueOf(version1[index1]);
        int v2 = Integer.valueOf(version1[index2]);
        if (v1 > v2)
            return 1;
        else if (v2 > v1)
            return -1;

        // action
        index1++;
        index2++;

        return SolutionRecusiv(version1, index1, version2, index2);
    }
}
