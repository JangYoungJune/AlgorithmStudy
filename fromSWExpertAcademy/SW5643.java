package fromSWExpertAcademy;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW5643 {
	static int[][] arr = new int[6][6];
	static int[] connect = new int[6];
	static int MAXVAL = 1000000;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int tcNum = Integer.parseInt(br.readLine().trim());
		for(int tc=1;tc<=tcNum;tc++) {
			int N = Integer.parseInt(br.readLine().trim());
			int M = Integer.parseInt(br.readLine().trim());
			int answer = 0;
			for(int i=0;i<N;i++) {
				connect[i] = 0;
				for(int j=0;j<N;j++) {
					arr[i][j] = MAXVAL;
					
				}
			}
			for(int i=0;i<M;i++) {
				st = new StringTokenizer(br.readLine().trim()," ");
				arr[Integer.parseInt(st.nextToken())-1][Integer.parseInt(st.nextToken())-1] = 1;
			}
			
			for(int k=0;k<N;k++) {
				for(int i=0;i<N;i++) {
					for(int j=0;j<N;j++) {
						if(arr[i][j]>arr[i][k] + arr[k][j]) {
							arr[i][j] = arr[i][k] + arr[k][j];
						}
					}
				}
			}
			
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(arr[i][j]!=MAXVAL) {
						connect[i]++;
						connect[j]++;
						if(connect[i]==N-1) {
							answer++;
						}
						if(connect[j]==N-1) {
							answer++;
						}
					}
				}
			}
			System.out.println("#"+tc+" "+answer);
		}
	}
}