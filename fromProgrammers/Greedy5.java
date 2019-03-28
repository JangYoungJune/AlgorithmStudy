package AlgorithmStudy.fromProgrammers;
/*
 * Problem URL: https://programmers.co.kr/learn/courses/30/lessons/42860?language=java
 */

import java.util.Arrays;

public class Greedy5 {
    public static int solution(int[][] routes) {
        int answer = 0;
        int min = Integer.MIN_VALUE;
        Arrays.sort(routes, (a, b) -> Integer.compare(a[1], b[1]));
        for (int[] route : routes) {
            if (min < route[0]) {
                answer++;
                min = route[1];
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[][] a = {{-20, 15}, {-14, -5}, {-18, -13}, {-5, -3}};
        int answer = solution(a);
        System.out.println(answer);
    }
}
