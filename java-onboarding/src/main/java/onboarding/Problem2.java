package onboarding;

import java.util.ArrayList;

public class Problem2 {

    static private String result = "\"\"";
    public static String solution(String cryptogram) {

        String str = cryptogram;

        ArrayList<Character> list = new ArrayList<Character>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            list.add(c);
        }

        if (list.size() == 0) {
            return result;
        }

        ArrayList<Character> findStr = strRemove(list);
        return getResult(findStr);

    }

    public static ArrayList<Character> strRemove(ArrayList<Character> list) {
        ArrayList<Character> strList = list;
        int index = 0;

        while (strList.size() != 0) {
            if (index == -1 || (index == strList.size() - 1)) {
                break;
            }
            if (strList.get(index) == strList.get(index+1)) {
                strList.remove(index+1);
                strList.remove(index);
                if (index != 0) {
                    index -= 1;
                }
            }
            else if (strList.get(index) != strList.get(index+1)) {
                index += 1;
            }
        }

        return strList;
    }

    public static String getResult(ArrayList<Character> list) {

        String str = "";
        for (Character c : list) {
            str += c;
        }
        return str;
    }
}
