package fromBOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW17136 {
	static int N = 10;
	static boolean[][] arr = new boolean[N][N];
	static int answer = Integer.MAX_VALUE;
	static int oneCnt = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine().trim(), " ");
			for (int j = 0; j < N; j++) {
				if(Integer.parseInt(st.nextToken())==1) {
					arr[i][j] = true;
					oneCnt++;
				}
			}
		}
		dfs(0,0,5, 0, 0);
		System.out.println((answer==Integer.MAX_VALUE)? -1 : answer);
	}
	public static void dfs(int x, int y, int size, int cnt, int total) {
		if(oneCnt<=3) {
			if(answer>total+cnt+oneCnt) {
				answer = total+cnt+oneCnt;
			}
			return;
		}
		
		if(size==3 && oneCnt>70) {
			return;
		} else if(size==2 && oneCnt>25) {
			return;
		} else if(size==1 && oneCnt>5) {
			return;
		}
		
		if(size==1 && oneCnt<=5) {
			if(answer>total+oneCnt) {
				answer = total+oneCnt;
			}
			return;
		}
		if(total+cnt>=answer) {
			return;
		}
		if(cnt<5) {
			for(int j=y;j<N;j++) {
				if(!arr[x][j]) {
					continue;
				}
				if (x + size > N || j + size > N) {
					continue;
				}
				boolean canPaste = true;
				paper: for (int r = x; r < x + size; r++) {
					for (int c = j; c < j + size; c++) {
						if (!arr[r][c]) {
							canPaste = false;
							break paper;
						}
					}
				}
				if (canPaste && total+cnt+1<answer) {
					for (int r = x; r < x + size; r++) {
						for (int c = j; c < j + size; c++) {
							arr[r][c] = false;
							oneCnt--;
						}
					}
					
					dfs(x+((j+size)/N), (j+size)%N, size, cnt+1, total);
					
					for (int r = x; r < x + size; r++) {
						for (int c = j; c < j + size; c++) {
							arr[r][c] = true;
							oneCnt++;
						}
					}
				}
			}
			for(int i=x+1;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(!arr[i][j]) {
						continue;
					}
					if (i + size > N || j + size > N) {
						continue;
					}
					boolean canPaste = true;
					paper: for (int r = i; r < i + size; r++) {
						for (int c = j; c < j + size; c++) {
							if (!arr[r][c]) {
								canPaste = false;
								break paper;
							}
						}
					}
					if (canPaste && total+cnt+1<answer) {
						for (int r = i; r < i + size; r++) {
							for (int c = j; c < j + size; c++) {
								arr[r][c] = false;
								oneCnt--;
							}
						}
						dfs(i+((j+size)/N), (j+size)%N, size, cnt+1, total);
						
						for (int r = i; r < i + size; r++) {
							for (int c = j; c < j + size; c++) {
								arr[r][c] = true;
								oneCnt++;
							}
						}
					}
				}
			}
		}
		dfs(0, 0, size-1, 0, total+cnt);
	}
}
