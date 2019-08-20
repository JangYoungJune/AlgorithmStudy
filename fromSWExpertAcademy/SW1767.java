package fromSWExpertAcademy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW1767 {
	static int N;
	static int[][] map;
	static boolean[][] isUse;
	static Pos[] core;
	static boolean[] useCore;
	static int coreCount;
	
	static int maxCore;
	static int minLine;
	static class Pos{
		int x;
		int y;
		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int tcNum = Integer.parseInt(br.readLine().trim());
		for(int tc=1;tc<=tcNum;tc++) {
			N = Integer.parseInt(br.readLine().trim());
			map = new int[N][N];
			isUse = new boolean[N][N];
			useCore = new boolean[12];
			core = new Pos[12];
			coreCount = 0;
			maxCore = -1;
			minLine = Integer.MAX_VALUE;
			
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine().trim(), " ");
				for(int j=0;j<N;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j]==1 && (i==0||i==N-1||j==0||j==N-1)) {
						isUse[i][j] = true;
					} else if(map[i][j]==1) {
						isUse[i][j] = true;
						core[coreCount++] = new Pos(i, j);
					}
				}
			}
			dfs(0, 0, 0);
			System.out.println("#"+tc+" " + minLine);
		}
		br.close();
	}
	
	public static void dfs(int idx, int useCore, int lineCount) {
		if(idx==coreCount) {
			if(useCore>maxCore) {
				maxCore = useCore;
				minLine = lineCount;
			} else if(useCore==maxCore && minLine>lineCount) {
				minLine = lineCount;
			}
			return;
		} else if(coreCount-idx+useCore<maxCore){
			return;
		}else {
			Pos now = core[idx];
			// 상
			boolean isPossible = true;
			for(int i=0;i<now.x;i++) {
				if(isUse[i][now.y]) {
					isPossible = false;
					break;
				}
			}
			if(isPossible) {
				for(int i=0;i<now.x;i++) {
					isUse[i][now.y] = true;
				}
				dfs(idx+1, useCore+1, lineCount + now.x);
				for(int i=0;i<now.x;i++) {
					isUse[i][now.y] = false;
				}
			}	
			// 하
			isPossible = true;
			for(int i=now.x+1;i<N;i++) {
				if(isUse[i][now.y]) {
					isPossible = false;
					break;
				}
			}
			if(isPossible) {
				for(int i=now.x+1;i<N;i++) {
					isUse[i][now.y] = true;
				}
				dfs(idx+1, useCore+1, lineCount + (N-1-now.x));
				for(int i=now.x+1;i<N;i++) {
					isUse[i][now.y] = false;
				}
			}
			// 좌
			isPossible = true;
			for(int i=0;i<now.y;i++) {
				if(isUse[now.x][i]) {
					isPossible = false;
					break;
				}
			}
			if(isPossible) {
				for(int i=0;i<now.y;i++) {
					isUse[now.x][i] = true;
				}
				dfs(idx+1, useCore+1, lineCount + now.y);
				for(int i=0;i<now.y;i++) {
					isUse[now.x][i] = false;
				}
			}
			// 우
			isPossible = true;
			for(int i=now.y+1;i<N;i++) {
				if(isUse[now.x][i]) {
					isPossible = false;
					break;
				}
			}
			if(isPossible) {
				for(int i=now.y+1;i<N;i++) {
					isUse[now.x][i] = true;
				}
				dfs(idx+1, useCore+1, lineCount + (N-1-now.y));
				for(int i=now.y+1;i<N;i++) {
					isUse[now.x][i] = false;
				}
			}
			dfs(idx+1, useCore, lineCount);
		}
	}
}
