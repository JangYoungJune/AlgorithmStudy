package fromBOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SW2309 {
	static int[] arr;
	static int sum = 0;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr = new int[9];
		for(int i=0;i<9;i++) {
			arr[i] = Integer.parseInt(br.readLine().trim());
			sum += arr[i];
		}
		int i = 0;
		int j = 0;
		outer : for(i=0;i<arr.length-1;i++) {
			for(j=i+1; j<arr.length;j++) {
				if((sum - arr[i] - arr[j]) == 100) {
					break outer;
				}
			}
		}
		int[] answerArr = new int[7];
		int idx = 0;
		for(int k=0;k<9;k++) {
			if(k!=i && k!=j) {
				answerArr[idx++] = arr[k];
			}
		}
		Arrays.sort(answerArr);
		for(int answer : answerArr) {
			System.out.println(answer);
		}
	}
}
