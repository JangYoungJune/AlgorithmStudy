package fromSWExpertAcademy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SW3074 {
	static int[] arr;
	static int answer;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tcNum = Integer.parseInt(br.readLine().trim());
		for(int tc=1;tc<=tcNum;tc++) {
			String[] inputStr = br.readLine().trim().split(" ");
			int N = Integer.parseInt(inputStr[0]);
			int M = Integer.parseInt(inputStr[1]);
			arr = new int[N];
			answer = 0;
			int max = 0;
			for(int i=0;i<N;i++) {
				arr[i] = Integer.parseInt(br.readLine().trim());
				if(max<arr[i]) {
					max = arr[i];
				}
			}
			long end = (long)max * (long)M;
			long start = 1;
			while(start<=end) {
				long mid = (end+start)/2;
				long cnt = 0;
				for(int i=0;i<arr.length;i++) {
					cnt += mid/arr[i];
				}
				if(cnt>=M) {
					end = mid-1;
				} else {
					start = mid+1;
				}
			}
			System.out.println("#"+tc+" "+start);
		}
	}
}