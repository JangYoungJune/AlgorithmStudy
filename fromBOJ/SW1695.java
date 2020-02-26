package fromBOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SW1695 {
	static int n;
	static int[] arr;
	static int[][] dpArr;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine().trim());
		arr = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(i->Integer.valueOf(i)).toArray();
		dpArr = new int [n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				dpArr[i][j] = -1;
			}
		}
		System.out.println(dpFunc(0, n-1));
	}
	public static int dpFunc(int lp, int rp) {
		if(lp>rp) {
			return 0;
		}
		if(dpArr[lp][rp]!=-1) {
			return dpArr[lp][rp];
		}
		if(arr[lp]==arr[rp]) {
			return dpArr[lp][rp]= dpFunc(lp+1, rp-1);
		} else {
			return dpArr[lp][rp] = Math.min(dpFunc(lp+1, rp), dpFunc(lp,rp-1))+1; 
			
		}
	}
}
