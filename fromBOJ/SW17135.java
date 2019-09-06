package fromBOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW17135 {
	static int N, M, R;
	static int answer;
	static int[][] map;
	static boolean[] arrows;
	static final int MAXVAL = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine().trim(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		arrows = new boolean[M];
		answer = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine().trim(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		comb(0, 3);
		System.out.println(answer);
	}

	public static void comb(int idx, int remain) {
		if (remain == 0) {
			int[][] copyMap = new int[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					copyMap[i][j] = map[i][j];
				}
			}
			huntMonster(copyMap);
		} else if (arrows.length - idx < remain) {
			return;
		} else {
			arrows[idx] = true;
			comb(idx + 1, remain - 1);
			arrows[idx] = false;
			comb(idx + 1, remain);
		}
	}

	public static void huntMonster(int[][] copyMap) {
		int[] arrowC = setArrowColumns();
		int move = N;
		int huntCnt = 0;
		int[][] minDist = new int[3][3];
		while (move != 0) {
			// 사냥함 - 가장 가까운 적 + 왼쪽
			for (int i = 0; i < 3; i++) {
				minDist[i][0] = MAXVAL;
			}
			for (int i = move - 1; i >= ((move - R >= 0) ? move - R : 0); i--) {
				for (int j = 0; j < M; j++) {
					if(copyMap[i][j]==1) {
						for (int idx = 0; idx < 3; idx++) {
							int dist = (move - i) + Math.abs(arrowC[idx] - j);
							if(dist>R) {
								continue;
							}
							if (dist < minDist[idx][0]) {
								minDist[idx][0] = dist;
								minDist[idx][1] = i;
								minDist[idx][2] = j;
							} else if(dist==minDist[idx][0] && j<minDist[idx][2]) {
								minDist[idx][1] = i;
								minDist[idx][2] = j;
							}
						}
					}
				}
			}
			for(int i=0;i<3;i++) {
				if(minDist[i][0]!=MAXVAL && copyMap[minDist[i][1]][minDist[i][2]]==1) {
					copyMap[minDist[i][1]][minDist[i][2]] = 0;
					huntCnt++;
				}
			}
			move--; // 올라가는 효과
		}
		if (answer < huntCnt) {
			answer = huntCnt;
		}
	}

	public static int[] setArrowColumns() {
		int[] arrowColumns = new int[3];
		int idx = 0;
		for (int i = 0; i < M; i++) {
			if (idx == 3) {
				break;
			}
			if (arrows[i]) {
				arrowColumns[idx] = i;
				idx++;
			}
		}
		return arrowColumns;
	}
}
