package fromSWExpertAcademy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class SW1859 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tcNum = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= tcNum; tc++) {
			int N = Integer.parseInt(br.readLine().trim());
			int[] arr = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(i->Integer.parseInt(i)).toArray();
			
			long answer = 0l;
			int start = 0;
			while(start<N) {
				int max = -1;
				int maxIdx = -1;
				for(int i=start; i<N; i++) {
					if(max<=arr[i]) {
						max = arr[i];
						maxIdx = i;
					}
				}
				for(int i=start; i<maxIdx;i++) {
					answer += (max - arr[i]);
				}
				start = maxIdx+1;
			}
			System.out.printf("#%d %d\n", tc, answer);
		}
	}
}
