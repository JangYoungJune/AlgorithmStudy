package fromSWExpertAcademy;

import java.util.Arrays;
import java.util.Scanner;

public class SW2063 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int[] arr = new int[num];
		for(int i=0;i<num;i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		System.out.printf("%d", arr[num/2]);
		sc.close();
	}
}
