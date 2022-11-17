package onboarding;

public class Problem4 {

    public static String solution(String word) {
        String result = "";

        char[] arrWord = word.toCharArray();
        for (char alphabet : arrWord) {
            result += changeWord(alphabet);
        }

        return result;
    }

    public static char changeWord(char alphabet) {
        if('a' <= alphabet && alphabet <= 'z') {
            return (char) ('a' + 'z' - alphabet);
        }
        if ('A' <= alphabet && alphabet <= 'Z') {
            return (char) ('A' + 'Z' - alphabet);
        }
        return alphabet;
    }
}
