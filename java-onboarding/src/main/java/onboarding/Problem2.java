package onboarding;

import java.util.ArrayList;

public class Problem2 {

    static private String BLANK = "";
    static private final String FIND_REGEX = "{2,}";
    static private String result = "";

    public static String solution(String cryptogram) {

        boolean flag = true;
        String beforeCryptogram = cryptogram;
        String afterCryptogram = "";

        while (flag) {
            afterCryptogram = decrypt(beforeCryptogram);

            if (isDifferent(beforeCryptogram, afterCryptogram)) {
                beforeCryptogram = afterCryptogram;
                continue;
            }
            result = afterCryptogram;
            flag = false;
        }
        return result;
    }

    public static Boolean isDifferent(String beforeCryptogram, String cryptogram) {
        return beforeCryptogram != cryptogram;
    }

    public static String decrypt(String cryptogram) {
        for (int alphabet = 'a'; alphabet <= 'z'; alphabet++) {
            String regex = (char)alphabet + FIND_REGEX;
            cryptogram = cryptogram.replaceAll(regex, BLANK);
        }
        return cryptogram;
    }


}
