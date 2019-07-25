package fromSWExpertAcademy;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class SW1954 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int testNum = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= testNum; tc++) {
			int N = Integer.parseInt(br.readLine().trim());
			int[][] a = new int[N][N];
			int idx = 1;
			int r = 0;
			int c = 0;
			int dir = 1; // 1>2v3<4^
			while (idx <= (N * N)) {
				if (dir == 1 && (c + 1 >= N || a[r][c + 1] != 0)) {
					dir = 2;
				} else if (dir == 2 && (r + 1 >= N || a[r + 1][c] != 0)) {
					dir = 3;
				} else if (dir == 3 && (c - 1 < 0 || a[r][c - 1] != 0)) {
					dir = 4;
				} else if (dir == 4 && (r - 1 < 0 || a[r - 1][c] != 0)) {
					dir = 1;
				}
				a[r][c] = idx;
				idx++;

				switch (dir) {
				case 1:
					c++;
					break;
				case 2:
					r++;
					break;
				case 3:
					c--;
					break;
				case 4:
					r--;
					break;
				}
			}
			bw.write("#" + tc + "\n");
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					bw.write(a[i][j] + " ");
				}
				bw.write("\n");
			}
		}
		bw.flush();
		bw.close();
	}
}
