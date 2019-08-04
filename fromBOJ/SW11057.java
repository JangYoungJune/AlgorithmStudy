package fromBOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SW11057 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[10];
		for (int i = 0; i < 10; i++) {
			arr[i]++;
		}
		while (N >= 2) {
			for (int i = 9; i >= 0; i--) {
				for (int j = i - 1; j >= 0; j--) {
					arr[i] = (arr[i] + arr[j]) % 10007;
				}
			}
			N--;
		}
		int answer = 0;
		for (int i = 0; i < 10; i++) {
			answer += arr[i];
		}

		System.out.println(answer % 10007);
	}
}