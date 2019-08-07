package fromSWExpertAcademy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SW8104 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tcNum = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= tcNum; tc++) {
			String[] inputWords = br.readLine().trim().split(" ");
			int N = Integer.parseInt(inputWords[0]);
			int K = Integer.parseInt(inputWords[1]);
			
			int[] arr = new int[K];
			for(int i=0;i<N;i++) {
				if(i%2==0) {
					for(int j=0;j<K;j++) {
						arr[j] += (i*K)+j+1;
					}
				} else {
					for(int j=K-1;j>=0;j--) {
						arr[j] += (i*K)+K-j;
					}
				}
			}
			System.out.printf("#%d ",tc);
			for(int val : arr) {
				System.out.printf("%d ",val);
			}
			System.out.println();
		}

	}
}
