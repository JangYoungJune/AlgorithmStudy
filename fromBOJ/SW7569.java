package fromBOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class SW7569 {
	static class Location {
		int x;
		int y;
		int z;

		public Location(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}

	static int M, N, O;
	static int[][][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine().trim());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		O = Integer.parseInt(st.nextToken());
		map = new int[O][N][M];
		
		LinkedList<Location> cand = new LinkedList<>();
		for (int h = 0; h < O; h++) {
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine().trim());
				for (int j = 0; j < M; j++) {
					map[h][i][j] = Integer.parseInt(st.nextToken());
					if (map[h][i][j] == 1) {
						cand.add(new Location(i, j, h));
					}
				}
			}
		}
		int answer = 0;
		while (!cand.isEmpty()) {
			int size = cand.size();
			for (int i = 0; i < size; i++) {
				Location now = cand.pop();
				if (now.x - 1 >= 0 && map[now.z][now.x - 1][now.y] == 0) {
					map[now.z][now.x - 1][now.y] = 1;
					cand.add(new Location(now.x - 1, now.y, now.z));
				}
				if (now.x + 1 < N && map[now.z][now.x + 1][now.y] == 0) {
					map[now.z][now.x + 1][now.y] = 1;
					cand.add(new Location(now.x + 1, now.y, now.z));
				}
				if (now.y - 1 >= 0 && map[now.z][now.x][now.y - 1] == 0) {
					map[now.z][now.x][now.y - 1] = 1;
					cand.add(new Location(now.x, now.y - 1, now.z));
				}
				if (now.y + 1 < M && map[now.z][now.x][now.y + 1] == 0) {
					map[now.z][now.x][now.y + 1] = 1;
					cand.add(new Location(now.x, now.y + 1, now.z));
				}
				if (now.z + 1 < O && map[now.z + 1][now.x][now.y] == 0) {
					map[now.z + 1][now.x][now.y] = 1;
					cand.add(new Location(now.x, now.y, now.z + 1));
				}
				if (now.z - 1 >= 0 && map[now.z - 1][now.x][now.y] == 0) {
					map[now.z - 1][now.x][now.y] = 1;
					cand.add(new Location(now.x, now.y, now.z - 1));
				}
			}
			if (!cand.isEmpty()) {
				answer++;
			}
		}

		outer: for (int h = 0; h < O; h++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[h][i][j] == 0) {
						answer = -1;
						break outer;
					}
				}
			}
		}

		System.out.println(answer);
	}
}
