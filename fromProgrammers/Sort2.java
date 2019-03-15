package AlgorithmStudy.fromProgrammers;

import java.util.Arrays;

/*
 * problem URL: https://programmers.co.kr/learn/courses/30/lessons/42746?language=java
 * */
public class Sort2 {
    public static String solution(int[] numbers) {
        String answer = "";
        String[] strNumber = new String[numbers.length];
        for (int i = 0; i < strNumber.length; i++) {
            strNumber[i] = Integer.toString(numbers[i]);
        }
        Arrays.sort(strNumber, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));

        for (int i = 0; i < strNumber.length; i++) {
            if (i == 0 && strNumber[i].equals("0")) {
                answer = "0";
                break;
            }
            answer += strNumber[i];
        }

        return answer;
    }

    public static void main(String args[]) {
        int[] a = {301, 321, 303, 304, 334, 322, 330};

        String answer = solution(a);
        System.out.println(answer);
    }
}
