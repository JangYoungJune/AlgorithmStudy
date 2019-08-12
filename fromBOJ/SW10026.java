package fromBOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class SW10026 {
	static char[][] arr;
	static boolean[][] boolArr;
	static Queue<Pos> queue;
	static class Pos{
		int x;
		int y;
		public Pos(int x,  int y){
			this.x = x;
			this.y = y;
		}
	}
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

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		arr = new char[N][N];
		boolArr = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			char[] str = br.readLine().trim().toCharArray();
			for (int j = 0; j < N; j++) {
				arr[i][j] = str[j];
			}
		}

		queue = new LinkedList<>();
		int answer = 0;
		int abAnswer = 0;
		char findColor;
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				if(boolArr[i][j]){
					continue;
				} else{
					findColor = arr[i][j];
					queue.add(new Pos(i, j));
					boolArr[i][j] = true;
					while(!queue.isEmpty()){
						Pos now = queue.poll();
						if(now.x+1<N && !boolArr[now.x+1][now.y] && isSameColor(true, now.x+1, now.y, findColor)){
							queue.add(new Pos(now.x+1,now.y));
							boolArr[now.x+1][now.y] = true;
						}
						if(now.y+1<N && !boolArr[now.x][now.y+1] && isSameColor(true, now.x, now.y+1, findColor)){
							queue.add(new Pos(now.x,now.y+1));
							boolArr[now.x][now.y+1] = true;
						}
						if(now.y-1>=0 && !boolArr[now.x][now.y-1] && isSameColor(true, now.x, now.y-1, findColor)){
							queue.add(new Pos(now.x,now.y-1));
							boolArr[now.x][now.y-1] = true;
						}
					}
					answer++;
				}
			}
		}

		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				boolArr[i][j] = false;
			}
		}

		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				if(boolArr[i][j]){
					continue;
				} else{
					findColor = arr[i][j];
					queue.add(new Pos(i, j));
					boolArr[i][j]=true;
					while(!queue.isEmpty()){
						Pos now = queue.poll();
						if(now.x+1<N && !boolArr[now.x+1][now.y] && isSameColor(false, now.x+1, now.y, findColor)){
							queue.add(new Pos(now.x+1,now.y));
							boolArr[now.x+1][now.y] = true;
						}
						if(now.y+1<N && !boolArr[now.x][now.y+1] && isSameColor(false, now.x, now.y+1, findColor)){
							queue.add(new Pos(now.x,now.y+1));
							boolArr[now.x][now.y+1] = true;
						}
						if(now.y-1>=0 && !boolArr[now.x][now.y-1] && isSameColor(false, now.x, now.y-1, findColor)){
							queue.add(new Pos(now.x,now.y-1));
							boolArr[now.x][now.y-1] = true;
						}
					}
					abAnswer++;
				}
			}
		}

		System.out.println(answer+" "+abAnswer);
		br.close();
	}
}
