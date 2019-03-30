package AlgorithmStudy.fromProgrammers;
/*
 * Problem URL: https://programmers.co.kr/learn/courses/30/lessons/42886?language=java
 */

import java.util.Arrays;

public class Greedy6 {
    public static int solution(int[] weight) {
        int answer = 1;
        Arrays.sort(weight);
        for (int w : weight) {
            if (answer >= w) {
                answer += w;
            } else {
                break;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] a = {3, 1, 6, 2, 7, 30, 1};
        int answer = solution(a);
        System.out.println(answer);
    }
}
