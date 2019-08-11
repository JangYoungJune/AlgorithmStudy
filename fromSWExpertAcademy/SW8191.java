package fromSWExpertAcademy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW8191 {
	static int[] arr;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int tcNum = Integer.parseInt(br.readLine().trim());
		for(int tc=1;tc<=tcNum;tc++) {
			int N = Integer.parseInt(br.readLine().trim());
			arr = new int[N+1];
			st = new StringTokenizer(br.readLine().trim());
			int answer = 0;
			while(st.hasMoreTokens()) {
				int nowVal = Integer.parseInt(st.nextToken());
				if(arr[nowVal-1]==0) {
					arr[nowVal] = 1;
					answer++;
				} else {
					arr[nowVal] = 2;
				}
			}
			System.out.println(String.format("#%d %d", tc, answer));
		}
	}
}
