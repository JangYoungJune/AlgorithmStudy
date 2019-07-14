package AlgorithmStudy.SWExpertAcademy;

import java.util.Arrays;
import java.util.Scanner;

public class SW1204 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cycle_num = sc.nextInt();
        for (int cycle = 0; cycle < cycle_num; cycle++) {
            int test_num = sc.nextInt();

            int[] arr = new int[101];
            for (int i = 0; i < 1000; i++) {
                arr[sc.nextInt()]++;
            }

            int max = Arrays.stream(arr).max().getAsInt();
            for (int i = 100; i >= 0; i--) {
                if (arr[i] == max) {
                    System.out.println("#" + test_num + " " + i);
                    break;
                }
            }
        }
    }
}
