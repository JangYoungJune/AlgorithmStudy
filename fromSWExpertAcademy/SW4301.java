package fromSWExpertAcademy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SW4301 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tcNum = Integer.parseInt(br.readLine().trim());
		for(int tc=1;tc<=tcNum;tc++) {
			String[] strArr = br.readLine().trim().split(" ");
			int N = Integer.parseInt(strArr[0]);
			int M = Integer.parseInt(strArr[1]);
			boolean[][] map = new boolean[N][M];
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					if(!map[i][j]) {
						if(i+2<N) {
							map[i+2][j] = true;
						}
						if(j+2<M) {
							map[i][j+2] = true;
						}
					}
				}
			}
			int answer = 0;
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					if(!map[i][j]) {
						answer++;
					}
				}
			}
			System.out.println("#"+tc+" "+answer);
		}
	}
}
