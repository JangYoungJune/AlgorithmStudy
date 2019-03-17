package AlgorithmStudy.fromProgrammers;
/*
 * Problem URL: https://programmers.co.kr/learn/courses/30/lessons/42840
 */

import java.util.ArrayList;
import java.util.List;

public class BruteForce1 {
    public static int[] solution(int[] answers) {
        int[] person1 = {1, 2, 3, 4, 5};
        int[] person2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] person3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] answerArr = new int[3];
        List<Integer> returnArr = new ArrayList<>();

        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == person1[i % 5]) {
                answerArr[0]++;
            }
            if (answers[i] == person2[i % 8]) {
                answerArr[1]++;
            }
            if (answers[i] == person3[i % 10]) {
                answerArr[2]++;
            }
        }
        int maxValue = Math.max(answerArr[0], Math.max(answerArr[1], answerArr[2]));
        for (int i = 0; i < answerArr.length; i++) {
            if (answerArr[i] == maxValue) {
                returnArr.add(i + 1);
            }
        }
        return returnArr.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};

        int[] answer = solution(a);
        for (int i : answer) {
            System.out.printf(i + " ");
        }
        System.out.println(answer);
    }
}
