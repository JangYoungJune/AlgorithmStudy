package fromBOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SW9095 {
	static int N;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		for(int i=0;i<N;i++) {
			int temp = Integer.parseInt(br.readLine());
			System.out.println(sumCase(temp));
		}
	}
	public static int sumCase(int n) {
		if(n==3) {
			return 4;
		} else if(n==2) {
			return 2;
		} else if(n==1) {
			return 1;
		}
		int result = sumCase(n-1) + sumCase(n-2) + sumCase(n-3);
		
		return result;
	}

}
