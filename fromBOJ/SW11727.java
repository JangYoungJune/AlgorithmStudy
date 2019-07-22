package fromBOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class SW11727 {
	static int[] arr = new int[1001];
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		arr[0] = 1;
		arr[1] = 1;
		arr[2] = 3;
		bw.write(dp(N) + "");
		bw.flush();
		bw.close();
	}
	public static int dp(int n) {
		if(arr[n]>0) {
			return arr[n];
		}
		arr[n] = (dp(n-1) + 2*dp(n-2))%10007;
		return arr[n];
	}
}
