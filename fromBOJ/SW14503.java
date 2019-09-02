package fromBOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW14503 {
	static int[][] map;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine().trim()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine().trim()," ");
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int dir = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine().trim()," ");
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 0인 경우에는 북쪽을, 1인 경우에는 동쪽을, 2인 경우에는 남쪽을, 3인 경우에는 서쪽
		int answer =  0;
		boolean isMove = true;
		int dirCheck = 0;
		while(isMove) {
			if(dirCheck!=4) {
				// 현재 장소 치우기
				if(map[r][c] == 0) {
					answer++;
					map[r][c] = 2;
				}
				// 방향 전환
				dir = (dir+3)%4;
				
				if(dir==0 && r-1>=0 && map[r-1][c]==0) {
					dirCheck=0;
					r--;
				} else if(dir==1 && c+1<M && map[r][c+1]==0) {
					dirCheck=0;
					c++;
				} else if(dir==2 && r+1<N && map[r+1][c]==0) {
					dirCheck=0;
					r++;
				} else if(dir==3 && c-1>=0 && map[r][c-1]==0) {
					dirCheck=0;
					c--;
				} else {
					dirCheck++;
				}
			} else {
				dirCheck = 0;
				boolean canBack = false;
				if(dir==0) {
					if(r+1<N && map[r+1][c]!=1) {
						canBack = true;
						r = r+1;
					}
				} else if(dir==1) {
					
					if(c-1>=0 && map[r][c-1]!=1) {
						canBack = true;
						c = c-1;
					}
				} else if(dir==2) {
					if(r-1>=0 && map[r-1][c]!=1) {
						canBack = true;
						r = r-1;
					}
				} else {
					if(c+1<M && map[r][c+1]!=1) {
						canBack = true;
						c = c+1;
					}
				}
				
				if(!canBack) {
					isMove = false;
				}
			}
		}
		System.out.println(answer);
	}
}
