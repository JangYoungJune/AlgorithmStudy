package fromBOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW17779 {
	public static void main(String[] args) throws Exception{
		BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(bufr.readLine().trim());
		int answer = Integer.MAX_VALUE;
		int[][] arr = new int[N][N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(bufr.readLine().trim()," ");
			for(int j=0;j<N;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int br = 0, bc = 0;
		int tr = 0, tc = 0;
		int lr = 0, lc = 0;
		int rr = 0, rc = 0;
		for(int r=0;r<N;r++) {
			for(int c=0;c<N;c++) {
				for(int left=c-1;left>=0;left--) {
					for(int right=c+1;right<N;right++) {
						int lDiff = left - c;
						int rDiff = right - c;
						if(r-(lDiff+rDiff)<0 || c-lDiff<0) {
							continue;
						}
						
						int area1 = 0, area2 = 0, area3 = 0, area4 = 0, area5 = 0;
						br = r;
						bc = c;
						lr = c + lDiff;
						lc = c - lDiff;
						rr = c + rDiff;
						rc = c + rDiff;
						tr = r - (lDiff+rDiff);
						tc = c + (rDiff - lDiff);
						
						int moveC = 0;
						// 1번 채우기 + 5일부
						moveC = tc;
						for(int i=0;i<lr;i++) {
							boolean changeMoveC = false;
							for(int j=0;j<=tc;j++) {
								if(i>=tr && moveC>=j) {
									area5 += arr[i][j];
									changeMoveC = true;
								} else {
									area1 += arr[i][j];
								}
							}
							if(changeMoveC) {
								moveC--;
							}
						}
						// 2번 채우기 + 5일부
						moveC = tc+1;
						for(int i=0;i<=rr;i++) {
							boolean changeMoveC = false;
							for(int j=tc+1;j<N;j++) {
								if(i>=tr && moveC>=j) {
									area5 += arr[i][j];
									changeMoveC = true;
								} else {
									area1 += arr[i][j];
								}
							}
							if(changeMoveC) {
								moveC++;
							}
						}
						// 3번 채우기 + 5일부
						moveC = lc;
						for(int i=lr;i<N;i++) {
							boolean changeMoveC = false;
							for(int j=0;j<bc;j++) {
								if(i<=br && moveC>=j) {
									area5 += arr[i][j];
									changeMoveC = true;
								} else {
									area1 += arr[i][j];
								}
							}
							if(changeMoveC) {
								moveC++;
							}
						}
						// 4번 채우기 + 5일부
						moveC = rc;
						for(int i=rr+1;i<N;i++) {
							boolean changeMoveC = false;
							for(int j=bc;j<N;j++) {
								if(i<=br && moveC>=j) {
									area5 += arr[i][j];
									changeMoveC = true;
								} else {
									area1 += arr[i][j];
								}
							}
							if(changeMoveC) {
								moveC--;
							}
						}
						int diffValue = Math.max(Math.max(Math.max(area1, area2), Math.max(area3, area4)), area5) - Math.min(Math.min(Math.min(area1, area2), Math.min(area3, area4)), area5);
						if(answer>diffValue) {
							answer = diffValue;
						}
					}
				}
			}
		}
		
		System.out.println(answer);
	}
}