package fromProgrammers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Boj_Main_7576 {
	static class Location{
		int x; 
		int y;
		public Location(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static int M, N;
	static int[][] map;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine().trim());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		LinkedList<Location> cand = new LinkedList<>();
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine().trim());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) {
					cand.add(new Location(i,j));
				}
			}
		}
		int answer = 0;
		while(!cand.isEmpty()) {
			int size = cand.size();
			for(int i=0;i<size;i++) {
				Location now = cand.pop();
				if(now.x-1>=0 && map[now.x-1][now.y]==0) {
					map[now.x-1][now.y] = 1;
					cand.add(new Location(now.x-1,now.y));
				}
				if(now.x+1<N && map[now.x+1][now.y]==0) {
					map[now.x+1][now.y] = 1;
					cand.add(new Location(now.x+1,now.y));
				}
				if(now.y-1>=0 && map[now.x][now.y-1]==0) {
					map[now.x][now.y-1] = 1;
					cand.add(new Location(now.x,now.y-1));
				}
				if(now.y+1<M && map[now.x][now.y+1]==0) {
					map[now.x][now.y+1] = 1;
					cand.add(new Location(now.x,now.y+1));
				}
			}
			if(!cand.isEmpty()) {
				answer++;
			}
		}
		
		outer: for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j]==0) {
					answer = -1;
					break outer;
				}
			}
		}
		
		System.out.println(answer);
	}
}
