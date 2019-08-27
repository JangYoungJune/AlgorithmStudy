package fromSWExpertAcademy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW2001 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int tcNum = Integer.parseInt(br.readLine().trim());
		for(int tc=1;tc<=tcNum;tc++) {
			st = new StringTokenizer(br.readLine().trim()," ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[][] arr = new int[N][N];
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine().trim()," ");
				for(int j=0;j<N;j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int max = 0;
			for(int i=0;i<=N-M;i++) {
				for(int j=0;j<=N-M;j++) {
					int sum = 0;
					for(int a=0;a<M;a++) {
						for(int b=0;b<M;b++) {
							sum+=arr[i+a][j+b];
						}
					}
					if(sum>max) {
						max = sum;
					}
				}
			}
			System.out.println("#"+tc+" "+max);
		}
	}
}
