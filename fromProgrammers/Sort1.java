package AlgorithmStudy.fromProgrammers;

import java.util.Arrays;

/*
 * problem URL: https://programmers.co.kr/learn/courses/30/lessons/42748?language=java
 * */
public class Sort1 {
    // command info 2,5,3
    // first-second : cut first index position to second position (5,2,6,3) and sort (2,3,5,6)
    // third: put third position value : 5
    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int position = 0;
        for (int[] command : commands) {
            int[] temp = Arrays.copyOfRange(array, command[0] - 1, command[1]);
            Arrays.sort(temp);
            answer[position] = temp[command[2] - 1];
            position++;
        }
        return answer;
    }

    public static void main(String args[]) {
        int[] a = {1, 5, 2, 6, 3, 7, 4};
        int[][] b = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

        int[] answer = solution(a, b);
        for (int i : answer) {
            System.out.print(i + " ");
        }
    }

}
