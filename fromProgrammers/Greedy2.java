package AlgorithmStudy.fromProgrammers;
/*
 * Problem URL: https://programmers.co.kr/learn/courses/30/lessons/42883?language=java
 */

public class Greedy2 {
    public static String solution(String number, int k) {
        StringBuilder numberList = new StringBuilder(number);
        int startIdx = 0;
        for (int i = 0; i < k; i++) {
            boolean isDeleted = false;
            for (int j = startIdx; j < numberList.length() - 1; j++) {
                if (numberList.charAt(j) < numberList.charAt(j + 1)) {
                    isDeleted = true;
                    startIdx = (j == 0) ? 0 : j - 1;
                    numberList.deleteCharAt(j);
                    break;
                }
            }
            if (!isDeleted) {
                for (int j = 0; j < k - i; j++) {
                    numberList.deleteCharAt(numberList.length() - 1);
                }
                break;
            }
        }
        return numberList.toString();
    }

    public static void main(String[] args) {
        String a = "10000";
        int b = 2;
        String answer = solution(a, b);
        System.out.println(answer);
    }
}
