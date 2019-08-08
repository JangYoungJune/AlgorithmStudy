package fromSWExpertAcademy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SW7730 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tcNum = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= tcNum; tc++) {
			String[] str = br.readLine().trim().split(" ");
			int N = Integer.parseInt(str[0]);
			int M = Integer.parseInt(str[1]);
			int[] arr = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(i -> Integer.parseInt(i)).sorted().toArray();
			long sumAll = 0l;
			for (int val : arr) {
				sumAll += val;
			}

			int idx = -1;
			int pre = 0;
			while (sumAll > M) {
				idx++;
				sumAll -= ((long)(arr[idx] - pre) * (long)(N - idx));
				pre = arr[idx];
				while (idx+1<N && pre == arr[idx + 1]) {
					idx++;
				}
			}
			while(idx-1>=0 && pre == arr[idx-1]){
				idx--;
			}
			while(sumAll<M){
				sumAll += (long)(N - idx);
				pre--;
			}
			System.out.println("#" + tc + " " + pre);
		}
	}
}