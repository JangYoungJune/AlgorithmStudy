package fromSWExpertAcademy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SW4012 {
	static int[] ingLeft, ingRight;
	static int[][] ings;
	static int N, halfN;
	static int minDiff;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tcNum = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= tcNum; tc++) {
			minDiff = Integer.MAX_VALUE;

			N = Integer.parseInt(br.readLine().trim());
			halfN = N / 2;

			ings = new int[N][N];
			ingLeft = new int[halfN];
			ingRight = new int[halfN];
			for (int i = 0; i < N; i++) {
				String[] foodstr = br.readLine().trim().split(" ");
				for (int j = 0; j < N; j++) {
					ings[i][j] = Integer.parseInt(foodstr[j]);
				}
			}

			divideFoods(1, 0, 1);

			System.out.println("#" + tc + " " + minDiff);
		}
	}

	public static void divideFoods(int left, int right, int idx) {
		if (idx == N) {
			findMinDiff();
			return;
		}
		if (left != halfN) {
			ingLeft[left] = idx;
			divideFoods(left + 1, right, idx + 1);
		}
		if (right != halfN) {
			ingRight[right] = idx;
			divideFoods(left, right + 1, idx + 1);
		}
	}

	public static void findMinDiff() {
		int leftSum = 0;
		int rightSum = 0;
		for(int i=0;i<halfN;i++) {
			for(int j=0;j<halfN;j++) {
				if(i==j) {
					continue;
				}
				leftSum+=ings[ingLeft[i]][ingLeft[j]];
				rightSum+=ings[ingRight[i]][ingRight[j]];
			}
		}
		
		int diff = Math.abs(leftSum-rightSum);
		if(minDiff>diff) {
			minDiff = diff;
		}
	}
}
