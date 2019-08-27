package fromSWExpertAcademy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW3234 {
	static int N;
	static int[] arr;
	static int answer;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int tcNum = Integer.parseInt(br.readLine().trim());
		for(int tc=1;tc<=tcNum;tc++) {
			N = Integer.parseInt(br.readLine().trim());
			arr = new int[N];
			answer = 0;
			st = new StringTokenizer(br.readLine().trim()," ");
			for(int i=0;i<N;i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			perm(0);
			System.out.println("#"+tc+" "+answer);
		}
	}
	public static void perm(int idx) {
		if(idx==N) {
			dfs(0,0,0);
		} else {
			for(int i=idx; i<N;i++) {
				int temp = arr[i];
				arr[i] = arr[idx];
				arr[idx] = temp;
				perm(idx+1);
				arr[idx] = arr[i];
				arr[i] = temp;
			}
		}
	}
	public static void dfs(int idx, int left, int right) {
		if(idx>=N) {
			answer++;
		} else {
			dfs(idx+1, left+arr[idx], right);
			if(left>=right+arr[idx]) {
				dfs(idx+1, left, right+arr[idx]);				
			}
		}
	}
}
