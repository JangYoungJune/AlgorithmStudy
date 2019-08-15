package fromBOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW12100 {
	static int N;
	static int[][] board;
	static int ans = 0;
	static boolean[][] sumed;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine().trim());
		board = new int[N][N];
		sumed = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine().trim(), " ");
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		boardSearch(0);
		System.out.println(ans);
		br.close();
	}

	public static void boardSearch(int count) {
		if (count == 5) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (ans < board[i][j]) {
						ans = board[i][j];
					}
				}
			}
			return;
		}

		int[][] archive = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				archive[i][j] = board[i][j];
			}
		}
		
		// 상
		initSumed();
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(board[i][j]==0) {
					continue;
				}
				int dist = 1;
				while (i - dist > 0) {
					if (board[i - dist][j] == 0) {
						dist++;
						continue;
					}
					break;
				}
				if (!sumed[i - dist][j] && board[i - dist][j] == board[i][j]) {
					board[i][j] = 0;
					board[i - dist][j] *= 2;
					sumed[i - dist][j] = true;
				} else if (board[i - dist][j] == 0) {
					board[i - dist][j] = board[i][j];
					board[i][j] = 0;
				} else {
					int temp = board[i][j];
					board[i][j] = 0;
					board[i - dist + 1][j] = temp;
				}
			}
		}
		boardSearch(count + 1);
		resetBoard(archive);
		// 하
 		initSumed();
		for (int i = N - 2; i >= 0; i--) {
			for (int j = 0; j < N; j++) {
				if(board[i][j]==0) {
					continue;
				}
				int dist = 1;
				while (i + dist < N - 1) {
					if (board[i + dist][j] == 0) {
						dist++;
						continue;
					}
					break;
				}
				if (!sumed[i + dist][j] && board[i + dist][j] == board[i][j]) {
					board[i][j] = 0;
					board[i + dist][j] *= 2;
					sumed[i + dist][j] = true;
				} else if (board[i + dist][j] == 0) {
					board[i + dist][j] = board[i][j];
					board[i][j] = 0;
				} else {
					int temp = board[i][j];
					board[i][j] = 0;
					board[i + dist - 1][j] = temp;
				}
			}
		}

		boardSearch(count + 1);
		resetBoard(archive);
		// 좌
		initSumed();
		for (int i = 0; i < N; i++) {
			for (int j = 1; j < N; j++) {
				if(board[i][j]==0) {
					continue;
				}
				int dist = 1;
				while (j - dist > 0) {
					if (board[i][j - dist] == 0) {
						dist++;
						continue;
					}
					break;
				}
				if (!sumed[i][j - dist] && board[i][j - dist] == board[i][j]) {
					board[i][j] = 0;
					board[i][j - dist] *= 2;
					sumed[i][j - dist] = true;
				} else if (board[i][j - dist] == 0) {
					board[i][j - dist] = board[i][j];
					board[i][j] = 0;
				} else {
					int temp = board[i][j];
					board[i][j] = 0;
					board[i][j - dist + 1] = temp;
				}
			}
		}
		boardSearch(count + 1);
		resetBoard(archive);

		// 우
		initSumed();
		for (int i = 0; i < N; i++) {
			for (int j = N - 2; j >= 0; j--) {
				if(board[i][j]==0) {
					continue;
				}
				int dist = 1;
				while (j + dist < N - 1) {
					if (board[i][j + dist] == 0) {
						dist++;
						continue;
					}
					break;
				}
				if (!sumed[i][j + dist] && board[i][j + dist] == board[i][j]) {
					board[i][j] = 0;
					board[i][j + dist] *= 2;
					sumed[i][j + dist] = true;
				} else if (board[i][j + dist] == 0) {
					board[i][j + dist] = board[i][j];
					board[i][j] = 0;
				} else {
					int temp = board[i][j];
					board[i][j] = 0;
					board[i][j + dist - 1] = temp;
				}
			}
		}
		boardSearch(count + 1);
		resetBoard(archive);
	}

	public static void initSumed() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sumed[i][j] = false;
			}
		}
	}

	public static void resetBoard(int[][] archive) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				board[i][j] = archive[i][j];
			}
		}
	}
}
