package onboarding;

import java.util.List;
import java.util.stream.Stream;

class Problem1 {

    private static final int FIRST_PAGE = 1;
    private static final int LAST_PAGE = 400;
    private static final int POBI_WIN = 1;
    private static final int CRONG_WIN = 2;
    private static final int DRAW = 0;
    private static final int EXCEPTION_RESULT = -1;

    public static int solution(List<Integer> pobi, List<Integer> crong) {

        int pobiLeft = pobi.get(0);
        int pobiRight = pobi.get(1);
        int crongLeft = crong.get(0);
        int crongRight = crong.get(1);

        if (!(isNotException(pobiLeft, pobiRight) && isNotException(crongLeft, crongRight))) {
            return EXCEPTION_RESULT;
        }

        int pobiScore = getScore(pobiLeft, pobiRight);
        int crongScore = getScore(crongLeft, crongRight);
        int result = getResult(pobiScore, crongScore);
        return result;

    }
    private static boolean isNotException(int leftPage, int rightPage) {
        return pageContinuous(leftPage, rightPage)
                && checkLeftOddRightEven(leftPage, rightPage)
                && pageNotOver(leftPage, rightPage)
                && leftPageSmaller(leftPage, rightPage);
    }

    private static boolean pageContinuous(int leftPage, int rightPage) {
        return (rightPage - leftPage) == 1;
    }

    private static boolean checkLeftOddRightEven(int leftPage, int rightPage) {
        return (leftPage % 2 == 1) && (rightPage % 2 == 0);
    }

    private static boolean pageNotOver(int leftPage, int rightPage) {
        return (leftPage > FIRST_PAGE) || (rightPage < LAST_PAGE);
    }

    private static boolean leftPageSmaller(int leftPage, int rightPage) {
        return leftPage < rightPage;
    }

    private static int getScore(int leftPage, int rightPage) {
        int leftScore = getBiggerNum(leftPage);
        int rightScore = getBiggerNum(rightPage);
        return Math.max(leftScore, rightScore);
    }

    private static int getBiggerNum(int num) {
        int sum = 0;
        int mul = 1;

        char[] numArr = String.valueOf(num).toCharArray();
        for (char c : numArr) {
            sum += c - '0';
            mul *= c - '0';
        }
        return Math.max(sum, mul);
    }

    private static int getResult(int pobiScore, int crongScore){
        if (pobiScore > crongScore) {
            return POBI_WIN;
        }
        if (pobiScore < crongScore) {
            return CRONG_WIN;
        }
        return DRAW;
    }
}