package onboarding;

public class Problem3 {

    static private int count = 0;
    public static int solution(int number) {

        for (int i = 1; i <= number; i++) {
            char[] arrNum = divisionNum(i);
            boolean clap = isClap(arrNum);
            if (clap == true) {
                addCount();
            }
        }

        return count;
    }

    public static char[] divisionNum(int number) {
        char[] arrNum = String.valueOf(number).toCharArray();
        return arrNum;
    }

//    public static boolean isClap(char[] numArr) {
//        boolean status = false;
//        for (char c : numArr) {
//            if ((c - '0' == 3) || (c - '0' == 6) || (c - '0' == 9)) {
//                status = true;
//            }
//        }
//        return status;
//    }

    public static void addCount() {
        count += 1;
    }
}
