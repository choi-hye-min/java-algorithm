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
        String solution = versionCheck.Solution2("1.0", "1.0.1");
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
}
