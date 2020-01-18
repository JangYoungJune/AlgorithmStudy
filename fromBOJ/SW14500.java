package fromBOJ;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SW14500 {
	static int n, m;
	static int[][] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputStr = br.readLine().trim().split(" ");
		n = Integer.parseInt(inputStr[0]);
		m = Integer.parseInt(inputStr[1]);
		arr = new int[n][m];

		for (int i = 0; i < n; i++) {
			String[] arrInt = br.readLine().trim().split(" ");
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(arrInt[j]);
			}
		}

		int max = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				int sum;
				if (canSize(i, j, 3, 0)) { // 아래 3개
					sum = 0;
					for(int k=0;k<4;k++) {
						sum += arr[i+k][j];
					}
					if(max<sum) {
						max = sum;
					}
				}
				
				if (canSize(i, j, 2, 1)) {
					sum = 0;
					for(int k=0;k<3;k++) {
						sum += arr[i+k][j];
					}
					sum += Math.max(arr[i][j+1], Math.max(arr[i+1][j+1], arr[i+2][j+1]));
					int otherSum = arr[i][j]+arr[i+1][j]+arr[i+1][j+1]+arr[i+2][j+1];
					sum = Math.max(sum, otherSum);
					if(max< sum) {
						max = sum;
					}
				}
				if (canSize(i, j, 2, -1)) {
					sum = 0;
					for(int k=0;k<3;k++) {
						sum += arr[i+k][j];
					}
					sum += Math.max(arr[i][j-1], Math.max(arr[i+1][j-1], arr[i+2][j-1]));
					int otherSum = arr[i][j]+arr[i+1][j]+arr[i+1][j-1]+arr[i+2][j-1];
					sum = Math.max(sum, otherSum);
					if(max<sum) {
						max = sum;
					}
				}

				if (canSize(i, j, 0, 3)) {
					sum = 0;
					for(int k=0;k<4;k++) {
						sum += arr[i][j+k];
					}
					if(max<sum) {
						max = sum;
					}
				}
				
				if (canSize(i, j, 1, 2)) {
					sum = 0;
					for(int k=0;k<3;k++) {
						sum += arr[i][j+k];
					}
					sum += Math.max(arr[i+1][j], Math.max(arr[i+1][j+1], arr[i+1][j+2]));
					int otherSum = arr[i][j]+arr[i][j+1]+arr[i+1][j+1]+arr[i+1][j+2];
					sum = Math.max(sum, otherSum);
					if(max<sum) {
						max = sum;
					}
				}
				if (canSize(i, j, -1, 2)) {
					sum = 0;
					for(int k=0;k<3;k++) {
						sum += arr[i][j+k];
					}
					sum += Math.max(arr[i-1][j], Math.max(arr[i-1][j+1], arr[i-1][j+2]));
					int otherSum = arr[i][j]+arr[i][j+1]+arr[i-1][j+1]+arr[i-1][j+2];
					sum = Math.max(sum, otherSum);
					if(max<sum) {
						max = sum;
					}
				}
				
				if (canSize(i, j, 1, 1)) {
					sum = 0;
					sum = arr[i][j]+arr[i+1][j] + arr[i][j+1]+arr[i+1][j+1];
					if(max<sum) {
						max = sum;
					}
				}

			}
		}
		System.out.println(max);
	}

	public static boolean canSize(int x, int y, int ex, int ey) {
		x = x + ex;
		y = y + ey;
		return (x >= 0 && x < n && y >= 0 && y < m);
	}

}
