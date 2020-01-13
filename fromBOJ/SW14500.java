package fromBOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW14500 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine().trim()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine().trim()," ");
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int max = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				
				if(j+3<M) { // 우 4칸
					int tempVal = 0;
					for(int k=0;k<4;k++) {
						tempVal += arr[i][j+k]; 
					}
					max = Math.max(max, tempVal);
				}
				
				if(i+3<N) { // 하 4칸
					int tempVal = 0;
					for(int k=0;k<4;k++) {
						tempVal += arr[i+k][j]; 
					}
					max = Math.max(max, tempVal);
				}
				
				if(i+2<N && j+1<M) { // 하 3칸  우 1칸
					int tempVal = 0;
					for(int k=0;k<3;k++) {
						tempVal += arr[i+k][j]; 
					}
					max = Math.max(max, (tempVal+Math.max(arr[i+1][j+1], arr[i+2][j+1])));
					max = Math.max(max, (tempVal-arr[i+2][j]+arr[i+1][j+1]+arr[i+2][j+1]));
				}
				
				if(i+2<N && j-1>=0) { // 하 3칸  좌 1칸
					int tempVal = 0;
					for(int k=0;k<3;k++) {
						tempVal += arr[i+k][j]; 
					}
					max = Math.max(max, (tempVal+Math.max(arr[i][j-1], arr[i+1][j-1])));
				}
				
				if(i+1<N && j+2<M) { // 우 3칸 하1칸
					int tempVal = 0;
					for(int k=0;k<3;k++) {
						tempVal += arr[i][j+k]; 
					}
					max = Math.max(max, (tempVal+Math.max(arr[i+1][j], arr[i+1][j+1])));
				}
				
				if(i-1>=0 && j+2<M) { // 우 3칸 상1칸
					int tempVal = 0;
					for(int k=0;k<3;k++) {
						tempVal += arr[i][j+k]; 
					}
					max = Math.max(max, (tempVal+Math.max(arr[i-1][j+1], arr[i-1][j+2])));
					max = Math.max(max, (tempVal-arr[i][j+2]+arr[i-1][j+1]+arr[i-1][j+2]));
				}
				
				if(i+1<N && j+1<M) { // 우 1칸 하1칸
					max = Math.max(max, (arr[i][j]+arr[i+1][j]+arr[i][j+1]+arr[i+1][j+1]));
				}
			}
		}
		
		System.out.println(max);
	}
}
