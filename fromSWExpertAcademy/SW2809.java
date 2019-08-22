package fromSWExpertAcademy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SW2809 {
	static int N;
	static int answer = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tcNum = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= tcNum; tc++) {
			answer = 0;
			N = Integer.parseInt(br.readLine().trim());
			nQueen(new boolean[N][N], 0, 0);
			System.out.println("#" + tc + " " + answer);
		}
	}

	public static void nQueen(boolean[][] imposArr, int trial, int imposCount) {
		if (trial >= N) {
			answer++;
		} else if(imposCount==N*N){
			return;
		}else {
			for (int i = trial; i < trial+1; i++) {
				for (int j = 0; j < N; j++) {
					if (!imposArr[i][j]) {
						boolean[][] newImposArr = new boolean[N][N];
						int cnt = processMap(imposArr, newImposArr, i, j);
						nQueen(newImposArr, trial + 1, cnt);
					}
				}
			}
		}
	}

	public static int processMap(boolean[][] from, boolean[][] to, int x, int y) {
		// copy
		// process : to use x,y position, eliminate exception case from bool table
		int count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				to[i][j] = from[i][j];
				if (i == x || j == y || i + j == x + y || x - y == i - j) {
					to[i][j] = true;
				}
				if(to[i][j]) {
					count++;
				}
			}
		}
		return count;
	}
}
