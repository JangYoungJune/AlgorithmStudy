package fromSWExpertAcademy;

import java.util.Scanner;

public class SW1204 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc_num = sc.nextInt();
        for (int tc = 1; tc <= tc_num; tc++) {
            int test_num = sc.nextInt();

            int[] arr = new int[101];
            for (int i = 0; i < 1000; i++) {
                arr[sc.nextInt()]++;
            }

            int max = 0;
            for (int i = 0; i <= 100; i++) {
                if(arr[i]>=arr[max]) {
                	max = i;
                }
            }
            System.out.printf("#%d %d\n",tc, max);
        }
        sc.close();
    }
}
