package fromSWExpertAcademy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SW3752 {
	static boolean[] canExpress = new boolean[10001];
	static int N;
	static int[] arr;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int tcNum = Integer.parseInt(br.readLine().trim());
		for(int tc=1;tc<=tcNum;tc++) {
			N = Integer.parseInt(br.readLine().trim());
			arr = new int[N];
			st = new StringTokenizer(br.readLine().trim()," ");
			for(int i=0;i<N;i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr);
			int maxValue = 0;
			canExpress[0] = true;
			for(int i=0;i<N;i++) {
				for(int j=maxValue;j>=0;j--) {
					if(canExpress[j]) {
						canExpress[j+arr[i]]=true;
					}
				}
				maxValue += arr[i];
			}
			int count = 0;
			for(int i=0;i<=maxValue;i++) {
				if(canExpress[i]) {
					count++;
				}
			}
			System.out.println("#"+tc+" "+count);
			
			for(int i=0;i<=maxValue;i++) {
				canExpress[i] = false;
			}
		}
	}
	
	/**
	 * dfs 풀이 내용
	 * >> 타임오버 나온다.
	 * >> 테이블을 만들고 dp 처럼 접근해본다.(위코드)
	 */
//	static int N;
//	static int[] arr;
//	static HashSet<Integer> set = new HashSet<>();
//	public static void main(String[] args) throws Exception{
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int tcNum = Integer.parseInt(br.readLine().trim());
//		for(int tc=1;tc<=tcNum;tc++) {
//			N = Integer.parseInt(br.readLine().trim());
//			arr = new int[N];
//			String[] st = br.readLine().trim().split(" ");
//			for(int i=0;i<N;i++) {
//				arr[i] = Integer.parseInt(st[i]);
//			}
//			dfs(0, 0);
//			System.out.println("#"+tc+" "+set.size());
//			set.clear();
//		}
//	}
//	public static void dfs(int sum, int idx) {
//		if(idx == arr.length) {
//			set.add(sum);
//		} else {
//			dfs(sum, idx+1);
//			dfs(sum+arr[idx], idx+1);
//		}
//	}
}
