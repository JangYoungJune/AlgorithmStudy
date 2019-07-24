package fromSWExpertAcademy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW6731 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int testNum = Integer.parseInt(br.readLine().trim());
		for(int tc = 1; tc<=testNum; tc++) {
			int N = Integer.parseInt(br.readLine().trim());
			int[][] arr = new int[N][N];
			int[][] brr = new int[N][N];
			
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				char[] temp = st.nextToken().toCharArray();
				for(int j=0;j<N;j++) {
					arr[i][j] = (temp[j]=='W')? 0 : 1;
				}
			}
			int answer = 0;
			for(int i=0;i<N;i++) {
				int rCnt = 0, cCnt = 0;
				for(int j=0;j<N;j++) {
					if(arr[i][j]==1) {
						rCnt++;
					}
					if(arr[j][i]==1) {
						cCnt++;
					}
				}
				
				for(int j=0;j<N;j++) {
					brr[i][j] += rCnt;
					brr[j][i] += cCnt;
				}
			}
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if((brr[i][j] - ((arr[i][j]==1)? 1:0))%2!=0) {
						answer++;
					}
				}
			}
			System.out.printf("#%d %d\n",tc,answer);
		}
	}
}
