package fromBOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SW10026 {
	static char[][] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		arr = new char[N][N];
		for (int i = 0; i < N; i++) {
			char[] str = br.readLine().trim().toCharArray();
			for (int j = 0; j < N; j++) {
				arr[j] = str[j];
			}
		}
		br.close();
	}
}
