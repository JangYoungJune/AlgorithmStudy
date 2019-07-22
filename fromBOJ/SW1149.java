package fromBOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SW1149 {
	static int N;
	static int[][] house; // 0 : R, 1 : G , 2 : B
	static int[][] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		house = new int[N][3];
		dp = new int[N][3];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			house[i][0] = Integer.parseInt(st.nextToken());
			house[i][1] = Integer.parseInt(st.nextToken());
			house[i][2] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0;i<N;i++) {
			if(i==0) {
				dp[i][0] = house[i][0];
				dp[i][1] = house[i][1];
				dp[i][2] = house[i][2];
			} else {
				dp[i][0] = house[i][0] + Math.min(dp[i-1][1], dp[i-1][2]);
				dp[i][1] = house[i][1] + Math.min(dp[i-1][0], dp[i-1][2]);
				dp[i][2] = house[i][2] + Math.min(dp[i-1][0], dp[i-1][1]);
			}
		}
		bw.write(Math.min(dp[N-1][0], Math.min(dp[N-1][1], dp[N-1][2]))+"");
		bw.flush();
		bw.close();
	}

}
