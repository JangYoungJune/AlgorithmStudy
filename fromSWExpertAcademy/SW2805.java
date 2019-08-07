package fromSWExpertAcademy;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SW2805 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tcNum = Integer.parseInt(br.readLine().trim());
		for(int tc=1;tc<=tcNum;tc++) {
			int N = Integer.parseInt(br.readLine().trim());
			int[][] arr = new int[N][N];
			for(int i=0;i<N;i++) {
				String[] tempArr = br.readLine().trim().split("");
				for(int j=0;j<N;j++){
					arr[i][j] = Integer.parseInt(tempArr[j]);
				}
			}
			int answer = 0;
			for(int i=0;i<N;i++) {
				if(i<=N/2) {
					for(int j=N/2-i;j<(N/2+1)+i;j++) {
						answer += arr[i][j];
					}
				} else {
					for(int j=(i-N/2);j<N-(i-N/2);j++) {
						answer += arr[i][j];
					}
				}
			}
			System.out.println("#"+tc+" "+answer);
		}
	}
}
