package fromSWExpertAcademy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW1861 {
	static int N;
	static int[][] map;
	static int minStart, maxLength;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int tcNum = Integer.parseInt(br.readLine().trim());
		for(int tc=1;tc<=tcNum;tc++) {
			N = Integer.parseInt(br.readLine().trim());			
			map = new int[N][N];
			minStart = Integer.MAX_VALUE;
			maxLength = 0;
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine().trim()," ");
				for(int j=0;j<N;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					dfs(i,j,map[i][j], 1);
				}
			}
			System.out.println("#"+tc+" "+minStart+" "+maxLength);
		}
	}
	static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
	public static void dfs(int x, int y, int start, int length) {
		int moveDir = -1;
		int dx, dy;
		for(int i=0;i<4;i++) {
			dx = dir[i][0];
			dy = dir[i][1];
			if(x+dx>=0 && x+dx<N && y+dy>=0 && y+dy<N && (map[x][y]+1)==map[x+dx][y+dy]) {
				moveDir = i;
			}
		}
		if(moveDir>=0) {
			dfs(x+dir[moveDir][0], y+dir[moveDir][1], start, length+1);
		} else {
			if(length>maxLength) {
				maxLength = length;
				minStart = start;
			} else if(length==maxLength && start<minStart) {
				minStart = start;
			}
		}
	}
}
