package fromBOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SW2193 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[] arr = new long[100];
		arr[1] = 1;
		arr[2] = 1;
		for (int i = 3; i <= N; i++) {
			arr[i] = arr[i - 1] + arr[i - 2];
		}
		System.out.println(arr[N]);
	}
}