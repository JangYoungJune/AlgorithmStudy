package AlgorithmStudy.fromProgrammers;
/*
 * Problem URL: https://programmers.co.kr/learn/courses/30/lessons/42885
 */

import java.util.Arrays;

public class Greedy4 {
    public static int solution(int[] people, int limit) {
        int answer = 0;
        int startIndex = 0;
        int lastIndex = people.length - 1;
        Arrays.sort(people);
        while (startIndex <= lastIndex) {
            int biggerOne = people[lastIndex];
            int smallerOne = people[startIndex];
            if (startIndex == lastIndex) {
                startIndex++;
            } else {
                if (biggerOne + smallerOne <= limit) {
                    startIndex++;
                }
            }
            lastIndex--;
            answer += 1;
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] a = {70, 50, 80};
        int b = 100;
        int answer = solution(a, b);
        System.out.println(answer);
    }
}
