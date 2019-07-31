package fromBOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SW10844 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[][] arr = new long[N][10];
		for(int i=1;i<10;i++) {
			arr[0][i] = 1;
		}
		for(int i=1;i<N;i++) {
			for(int j=0;j<10;j++) {
				if(j!=9) {
					arr[i][j] = (arr[i][j] + arr[i-1][j+1])%1000000000;
				}
				if(j!=0) {
					arr[i][j] = (arr[i][j] + arr[i-1][j-1])%1000000000;
				}
			}
		}
		long answer = 0;
		for(int i=0;i<10;i++) {
			answer = (answer + arr[N-1][i])%1000000000;
		}
		System.out.println(answer);
	}
}
