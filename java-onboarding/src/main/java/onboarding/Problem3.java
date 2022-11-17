package onboarding;

public class Problem3 {

    public static int solution(int number) {

        int result = 0;
        for (int i = 1; i <= number; i++) {
            char[] arrNum = divisionNum(i);
            result += is369(arrNum);
        }

        return result;
    }

    public static char[] divisionNum(int number) {
        char[] arrNum = String.valueOf(number).toCharArray();
        return arrNum;
    }

    public static int is369(char[] numArr) {
        int number = 0;
        for (char c : numArr) {
            if ((c - '0' == 3) || (c - '0' == 6) || (c - '0' == 9)) {
                number += 1;
            }
        }
        return number;
    }
}
