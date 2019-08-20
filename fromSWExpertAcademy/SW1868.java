package fromSWExpertAcademy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class SW1868 {
	static int[][] map;
	static boolean[][] visit;
	static int N;
	static int[][] dir8 = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 }, { 1, 1 }, { 1, -1 }, { -1, 1 }, { -1, -1 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tcNum = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= tcNum; tc++) {
			N = Integer.parseInt(br.readLine().trim());
			map = new int[N][N];
			visit = new boolean[N][N];
			int count = 0;
			for (int i = 0; i < N; i++) {
				char[] line = br.readLine().trim().toCharArray();
				for (int j = 0; j < N; j++) {
					if (line[j] == '*') {
						visit[i][j] = true;
					}
				}
			}
			// 값을 미리 채운다.
			calcMap();
			// 0값인걸 찾아서 지우면서 카운트를 센다.
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == 0 && !visit[i][j]) {
						visit[i][j] = true;
						count++;
						visitMap(i, j);
					}
				}
			}
			// 나머지는 그냥 갯수를 센다.
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!visit[i][j]) {
						count++;
					}
				}
			}
			System.out.println("#" + tc + " " + count);
		}
	}

	public static void visitMap(int x, int y) {
		Queue<Integer> stackX = new LinkedList<>();
		Queue<Integer> stackY = new LinkedList<>();
		stackX.offer(x);
		stackY.offer(y);
		while (!stackX.isEmpty()) {
			int nowX = stackX.poll();
			int nowY = stackY.poll();
			for (int k = 0; k < 8; k++) {
				int newX = nowX + dir8[k][0];
				int newY = nowY + dir8[k][1];
				if (newX >= 0 && newX < N && newY >= 0 && newY < N && !visit[newX][newY]) {
					visit[newX][newY] = true;
					if (map[newX][newY] == 0) {
						stackX.offer(newX);
						stackY.offer(newY);
					}
				}
			}
		}
	}

	public static void calcMap() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (visit[i][j]) {
					map[i][j] = -1;
				} else {
					int cnt = 0;
					for (int k = 0; k < 8; k++) {
						int newX = i + dir8[k][0];
						int newY = j + dir8[k][1];
						if (newX >= 0 && newX < N && newY >= 0 && newY < N && visit[newX][newY]) {
							cnt++;
						}
					}
					map[i][j] = cnt;
				}
			}
		}
	}
}
