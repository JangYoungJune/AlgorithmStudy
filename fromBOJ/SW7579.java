package fromBOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 문제: 앱 (https://www.acmicpc.net/problem/7579)
 * 유형: dp
 * 해결방법: 
 * 점화식을 새우는게 중요했던 문제
 * 메모리 사용량을 기반으로 map을 만들 수 없다(oversize)
 * 그렇기 때문에 N과 disable cost를 기반으로 map을 만들고 cost에 따른 가장 큰 메모리 제거를 찾아야 한다. 
 */
public class SW7579 {
	static final int MAX_DISABLE = 10001;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] memories = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
		int[] disables = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();

		int[] dp = new int[MAX_DISABLE];
		Arrays.fill(dp, -1);

		for (int i = 0; i < N; i++) {
			int mem = memories[i];
			int disable = disables[i];
			for (int j = MAX_DISABLE - 1; j >= 0; j--) {
				if(dp[j]!=-1 && dp[j+disable]<mem+dp[j]) {
					dp[j+disable] = mem+dp[j];
				}
			}
			if (dp[disable] < mem) {
				dp[disable] = mem;
			}
		}
		
		int result = 0;
		for(int i=0;i<MAX_DISABLE;i++) {
			if(dp[i]>=M) {
				result = i;
				break;
			}
		}
		System.out.println(result);
	}
}
