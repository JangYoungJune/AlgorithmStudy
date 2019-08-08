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
			int[] arr = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(i -> Integer.parseInt(i)).sorted()
					.toArray();
			long sumAll = 0l;
			for (int val : arr) {
				sumAll += val;
			}

			int idx = 0;
			int min = 0;
			while (sumAll > M) {
				idx++;
				sumAll -= ((arr[idx] - min) * (N - idx));
				min = arr[idx];
				while (min == arr[idx + 1]) {
					idx++;
				}
			}

//                   while(sumAll<M) {
//                         arr[]
//                   }

			for (int i = arr[idx]; i >= 0; i--) {
				sumAll += (N - idx);
				if (sumAll > M) {
					min = i - 1;
					break;
				}
			}
			System.out.println("#" + tc + " " + min);
		}
	}
}
//   min arr[idx]
// 13 13 15 15 15 3 > 13 1 1 2
// 6  12*5