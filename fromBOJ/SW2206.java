package fromBOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SW2206 {
	static int[][] map;
	static int[][] weightMap;
	static boolean[][] visited;
	static int N,M;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().trim().split(" ");
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		map = new int[N][M];
		weightMap = new int[N][M];
		visited = new boolean[N][M];
		for(int i=0;i<N;i++) {
			char[] charSet = br.readLine().trim().toCharArray();
			for(int j=0;j<M;j++) {
				map[i][j] = charSet[j]-'0';
			}
		}
		dfs(0,0,1, false);
		System.out.println(weightMap[N-1][M-1]);
	}
	
	public static void dfs(int x, int y, int weight, boolean useBreak) {
		// 현재 위치 값 넣기
		visited[x][y] = true;
		if(weightMap[x][y]<=weight && useBreak) {
			return;
		}
		weightMap[x][y]
	}
}
