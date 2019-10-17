package fromBOJ;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW14889 {
	static int N;
	static int[][] arr;
	static int[] team1, team2;
	static int answer = Integer.MAX_VALUE;
	static int[] cand = new int[4];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine().trim());
		arr = new int[N][N];
		team1 = new int[N/2];
		team2 = new int[N/2];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine().trim()," ");
			for(int j=0;j<N;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		team1[0] = 0;
		divideTeam(1, 0, 1);
		
		System.out.println(answer);
	}
	
	public static void divideTeam(int top1, int top2, int idx) {
		if(answer==0) {
			return;
		}
		if(top1==N/2 || top2==N/2) {
			if(top1==N/2) {
				for(int i=top2;i<N/2;i++) {
					team2[i] = idx++;
				}
			} else {
				for(int i=top1;i<N/2;i++) {
					team1[i] = idx++;
				}
			}
			int val1 = 0, val2 = 0;
			for(int i=0;i<N/2;i++) {
				for(int j=0;j<N/2;j++) {
					val1 += arr[team1[i]][team1[j]];
					val2 += arr[team2[i]][team2[j]];
				}
			}
			int total = Math.abs(val1-val2);
			if(answer>total) {
				answer = total;
			}
		} else {
			team1[top1] = idx;
			divideTeam(top1+1, top2, idx+1);
			team2[top2] = idx;
			divideTeam(top1, top2+1, idx+1);
		}
	}
}
