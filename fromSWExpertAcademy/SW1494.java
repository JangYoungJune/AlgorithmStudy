package fromSWExpertAcademy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW1494 {
	static class Location{
		int x;
		int y;
		public Location(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static int[][] locations;
	static int[] locIdxs;
	static int N;
	static int totalX, totalY;
	static long answer; 
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int tcNum  = Integer.parseInt(br.readLine().trim());
		for(int tc=1;tc<=tcNum;tc++) {
			N = Integer.parseInt(br.readLine().trim());
			locations = new int[N][2];
			answer = Long.MAX_VALUE;
			totalX = 0;
			totalY = 0;
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine().trim(), " ");
				locations[i][0] = Integer.parseInt(st.nextToken());
				totalX += locations[i][0]; 
				locations[i][1] = Integer.parseInt(st.nextToken());
				totalY += locations[i][1];
			}
			dfs(0, N/2, 0, 0);
			System.out.println("#"+tc+" "+answer);
		}
	}
	
	public static void dfs(int idx, int size, int sumX, int sumY) {
		if(size==0) {
			int subX = totalX - sumX;
			int subY = totalY - sumY;
			long dist = (long)(sumX-subX)*(long)(sumX-subX) + (long)(sumY-subY)*(long)(sumY-subY);
			if(answer>dist) {
				answer = dist;
			}
		} else if(N - idx < size) {
			return;
		} else {
			dfs(idx+1, size-1, sumX+locations[idx][0], sumY+locations[idx][1]);
			dfs(idx+1, size, sumX, sumY);
		}
	}
}
