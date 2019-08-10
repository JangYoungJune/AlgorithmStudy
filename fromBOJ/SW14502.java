package fromBOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class SW14502 {
	static int r, c;
	static int[][] map;
	static int[][] copyMap;
	static int[][] virusPos = new int[10][2];
	static int virusCnt = 0;
	static int answer = 0;
	
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine().trim());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		map = new int[r][c];
		copyMap = new int[r][c];
		
		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < c; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					virusPos[virusCnt][0] = i;
					virusPos[virusCnt][1] = j;
					virusCnt++;
				}
			}
		}

		for (int i = 0; i < r * c - 2; i++) {
			if (map[i / c][i % c] != 0) {
				continue;
			}
			map[i / c][i % c] = 1;
			for (int j = i + 1; j < r * c - 1; j++) {
				if (map[j / c][j % c] != 0) {
					continue;
				}
				map[j / c][j % c] = 1;
				for (int k = j + 1; k < r * c; k++) {
					if (map[k / c][k % c] != 0) {
						continue;
					} 
					map[k / c][k % c] = 1;
					
					for (int a1 = 0; a1 < r; a1++) {
						for (int a2 = 0; a2 < c; a2++) {
							copyMap[a1][a2] = map[a1][a2];
						}
					}
					bfsVirus();
					
					map[k / c][k % c] = 0;
				}
				map[j / c][j % c] = 0;
			}
			map[i / c][i % c] = 0;
		}
		System.out.println(answer);
	}
	
	public static void bfsVirus() {
		LinkedList<int[]> queue = new LinkedList<>(); 
		for(int i=0;i<virusCnt;i++) {
			queue.add(virusPos[i]);
		}
		while(!queue.isEmpty()) {
			int[] temp = queue.pop();
			for(int i=0;i<4;i++) {
				int tempX = temp[0]+dx[i];
				int tempY = temp[1]+dy[i];
				if(tempX>=0 && tempX<r && tempY>=0 && tempY<c && copyMap[tempX][tempY]==0) {
					copyMap[tempX][tempY] = 2;
					queue.add(new int[]{tempX,tempY});
				}
			}
		}
		int cnt = 0;
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				if(copyMap[i][j]==0) {
					cnt++;
				}
			}
		}
		
		if(cnt>answer) {
			answer = cnt;
		}
	}

}
