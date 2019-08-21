package fromSWExpertAcademy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SW7699 {
	static char[][] map;
	static boolean[] visitAlpha;
	static int maxSee;
	static int N,M;
	static int[][] dir4 = {{-1,0},{1,0},{0,-1},{0,1}};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tcNum = Integer.parseInt(br.readLine().trim());
		for(int tc=1;tc<=tcNum;tc++) {
			String[] str = br.readLine().trim().split(" ");
			N = Integer.parseInt(str[0]);
			M = Integer.parseInt(str[1]);
			map = new char[N][M];
			visitAlpha = new boolean[26];
			maxSee = -1;
			for(int i=0;i<N;i++) {
				char[] line = br.readLine().trim().toCharArray();
				for(int j=0;j<M;j++) {
					map[i][j] = line[j];
				}
			}
			visitAlpha[map[0][0]-'A'] = true;
			dfs(1, true, 0, 0);
			System.out.println("#"+tc+" "+maxSee);
		}
	}
	public static void dfs(int seeCount, boolean canSee, int x, int y) {
		if(!canSee) {
			if(maxSee<seeCount) {
				maxSee = seeCount;
			}
		} else {
			boolean canMove = false;
			for(int i=0;i<dir4.length;i++) {
				int newX = x+dir4[i][0];
				int newY = y+dir4[i][1];
				if(newX>=0 && newX<N && newY>=0 && newY<M && !visitAlpha[map[newX][newY]-'A']) {
					canMove = true;
					visitAlpha[map[newX][newY]-'A'] = true;
					dfs(seeCount+1, canSee, newX, newY);
					visitAlpha[map[newX][newY]-'A'] = false;
				}
			}
			if(!canMove) {
				dfs(seeCount, !canSee, x, y);
			}
		}
	}
}
