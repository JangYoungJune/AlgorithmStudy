package fromBOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SW1937 {
	static class Pos{
		int value;
		int x;
		int y;
		public Pos(int value, int x, int y) {
			super();
			this.value = value;
			this.x = x;
			this.y = y;
		}
		
	}
	static int[][] arr;
	static int[][] wayArr;
	static int N;
	static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine().trim());
		Pos[] posArr = new Pos[N*N];
		arr = new int[N][N];
		wayArr = new int[N][N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine().trim(), " ");
			for(int j=0;j<N;j++) {
				int nowValue = Integer.parseInt(st.nextToken());;
				arr[i][j] = nowValue;
				posArr[i*N+j] = new Pos(nowValue,i,j);
				wayArr[i][j] = 1;
			}
		}
		Arrays.sort(posArr, (pos1, pos2)->pos2.value-pos1.value);
		for(Pos pos : posArr) {
			int value = pos.value;
			int posX = pos.x;
			int posY = pos.y;
			for(int i=0;i<4;i++) {
				int x = posX+dir[i][0];
				int y = posY+dir[i][1];
				if(canMove(x,y) && arr[posX][posY]>arr[x][y]) {
					wayArr[x][y] = wayArr[posX][posY]>=wayArr[x][y]? wayArr[posX][posY]+1:wayArr[x][y];
				}
			}
		}
		int max = 0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(wayArr[i][j]>max) {
					max = wayArr[i][j];
				}
			}
		}
		System.out.println(max);
	}
	
	public static boolean canMove(int x, int y) {
		return (x>=0 && x<N && y>=0 && y<N);
	}
}
