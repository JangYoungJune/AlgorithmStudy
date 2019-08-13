package fromBOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class SW10026 {
	static class Pos{
		int x;
		int y;
		public Pos(int x,  int y){
			this.x = x;
			this.y = y;
		}
	}
	
	static char[][] arr;
	static boolean[][] checkArr;
	static Queue<Pos> queue;
	static int N;
	
	public static boolean isSameColor(boolean isNormal, int x, int y, char color){
		if(isNormal){
			return arr[x][y]==color;
		} else{
			if(color=='R' || color=='G'){
				return (arr[x][y]=='R' || arr[x][y]=='G');
			} else{
				return arr[x][y]==color;
			}
		}
	}
	
	public static void bfs(char color, boolean isNormal) {
		while(!queue.isEmpty()) {
			Pos pos = queue.poll();
			int x = pos.x;
			int y = pos.y;
			if(y-1>=0 && !checkArr[x][y-1] && isSameColor(isNormal, x, y-1, color)) {
				checkArr[x][y-1] = true;
				queue.offer(new Pos(x, y-1));
			}
			if(y+1<N && !checkArr[x][y+1] && isSameColor(isNormal, x, y+1, color)) {
				checkArr[x][y+1] = true;
				queue.offer(new Pos(x, y+1));
			}
			if(x+1<N && !checkArr[x+1][y] && isSameColor(isNormal, x+1, y, color)) {
				checkArr[x+1][y] = true;
				queue.offer(new Pos(x+1, y));
			}
			if(x-1>=0 && !checkArr[x-1][y] && isSameColor(isNormal, x-1, y, color)) {
				checkArr[x-1][y] = true;
				queue.offer(new Pos(x-1, y));
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());
		arr = new char[N][N];
		checkArr = new boolean[N][N];
		queue = new LinkedList<>();
		
		int answer = 0;
		int abAnswer = 0;
		// read data from input
		for (int i = 0; i < N; i++) {
			char[] str = br.readLine().trim().toCharArray();
			for (int j = 0; j < N; j++) {
				arr[i][j] = str[j];
			}
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(checkArr[i][j]) {
					continue;
				}
				checkArr[i][j] = true;
				queue.add(new Pos(i, j));
				bfs(arr[i][j], true);
				answer++;
			}
		}
		
		checkArr = new boolean[N][N];
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(checkArr[i][j]) {
					continue;
				}
				checkArr[i][j] = true;
				queue.add(new Pos(i, j));
				bfs(arr[i][j], false);
				abAnswer++;
			}
		}

		System.out.println(answer+" "+abAnswer);
		br.close();
	}
}
