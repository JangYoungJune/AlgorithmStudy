package fromBOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;


public class SW2098 {
	static int N;
	static int[][] map;
	static int size;
	static int[][] dp;
	static final int INF = 50000000;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());
		map = new int[N][N];
		size = 1 << N;
		dp = new int[N][size];

		for (int i = 0; i < N; i++) {
			Arrays.fill(dp[i], -1);
			String[] arr = br.readLine().trim().split(" ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(arr[j]);
			}
		}

		System.out.println(dfs(1, 0));
	}

	public static int dfs(int visitBit, int idx) {
		if (visitBit == size - 1) {
			if(map[idx][0]==0) return INF;
			return map[idx][0];
		} 
		if(dp[idx][visitBit]!=-1) {
			return dp[idx][visitBit];
		}
		int minValue = INF;
		for(int next = 0; next<N;next++) {
			if((visitBit & (1<<next))==0 && map[idx][next]>0) {
				minValue = Math.min(minValue, dfs(visitBit|(1<<next), next)+map[idx][next]);
			}
		}
		dp[idx][visitBit] = minValue;
		return dp[idx][visitBit];
	}
}
