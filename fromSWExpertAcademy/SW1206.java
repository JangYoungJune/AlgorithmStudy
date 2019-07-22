package fromSWExpertAcademy;

import java.util.Scanner;

public class SW1206 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int cycle = 0; cycle < 10; cycle++) {
            int answer = 0;
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            for (int i = 0; i < n; i++) {
                if (arr[i] == 0) continue;
                int maxValue = Math.max(Math.max(arr[i - 1], arr[i - 2]), Math.max(arr[i + 1], arr[i + 2]));
                int mid = arr[i];
                answer = answer + ((mid > maxValue) ? mid - maxValue : 0);
            }

            System.out.println("#" + (cycle + 1) + " " + answer);
        }
        sc.close();
    }
}
