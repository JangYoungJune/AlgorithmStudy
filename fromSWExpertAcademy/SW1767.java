package fromSWExpertAcademy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW1767 {
	static int N;
	static int[][] map;
	static boolean[][] isUse;
	static Pos[] core = new Pos[12];
	static boolean[] useCore = new boolean[12];
	static int coreCount = 0;
	
	static int maxCore = -1;
	static int minLine = Integer.MAX_VALUE;
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
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine().trim(), " ");
				for(int j=0;j<N;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j]==1 && (i==0||i==N-1||j==0||j==N-1)) {
						isUse[i][j] = true;
					} else if(map[i][j]==1) {
						core[coreCount++] = new Pos(i, j);
					}
				}
			}
			// 순열을 돌린다
			// > 그 순열속에서 상하좌우 dfs를 처리한다.
			perm(coreCount, 0);
			System.out.println("#"+tc+" " + minLine);
		}
		br.close();
	}
	
	public static void perm(int cnt, int idx) {
		if(cnt==idx) {
			// 순열 완성 >> 각 순서대로 4방향 DFS처리한다.
			dfs(0, 0, 0);
		} else {
			// 현재 0 단계칸에 모든 숫자를 채우고, 다음 1번째 단계로 사용하지 않는 숫자에 대해 반복
			for(int i=0;i<cnt;i++) {
				Pos temp = core[idx];
				core[idx] = core[i];
				core[i] = temp;
				perm(cnt,idx+1);
				temp = core[idx];
				core[idx] = core[i];
				core[i] = temp;
			}
		}
	}
	
	public static void dfs(int idx, int useCore, int lineCount) {
		if(idx==coreCount) {
			if(useCore>maxCore) {
				maxCore = useCore;
				minLine = lineCount;
			} else if(useCore==maxCore && minLine>lineCount) {
				minLine = lineCount;
			}
		} else {
			boolean useDfs = false;
			Pos now = core[idx];
			// 상
			boolean isPossible = true;
			for(int i=0;i<now.x;i++) {
				if(isUse[i][now.y]) {
					isPossible = false;
					break;
				}
			}
			// 하
			
			// 좌
			
			// 우
			
			if(!useDfs) {
				dfs(idx+1, useCore, lineCount);
			}
			// 4방향 다 아닌경우 > 그냥 다음값 확인
			// 4방향 가능함 > dfs태움
		}
		// 상, 하, 좌, 우 탐색한다.
	}
}
