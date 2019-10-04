package fromBOJ;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class SW3055 {
	static class Pos{
		int r;
		int c;
		public Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	static boolean[][] visited;
	static int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
	static Queue<Pos> q = new LinkedList<>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] numStr = br.readLine().trim().split(" ");
		int R = Integer.parseInt(numStr[0]), C = Integer.parseInt(numStr[1]);
		int destR = 0, destC = 0;
		int startR = 0, startC = 0;
		int waterSize = 0;
		int hedgeSize = 1;
		int answer = 0;
		visited = new boolean[R][C];
		for(int i=0;i<R;i++) {
			char[] rows = br.readLine().toCharArray();
			for(int j=0;j<C;j++) {
				if(rows[j]=='D') {
					visited[i][j] = true;
					destR = i;
					destC = j;
				} else if(rows[j]=='S') {
					visited[i][j] = true;
					startR = i;
					startC = j;
				} else if(rows[j]=='*') {
					visited[i][j] = true;
					q.offer(new Pos(i,j));
					waterSize++;
				} else if(rows[j]=='X') {
					visited[i][j] = true;
				}
			}
		}
		q.offer(new Pos(startR, startC));
		
		int cycle = 0;
		while(hedgeSize!=0 && answer==0) {
			cycle++;
			// 물채움
			int tempWaterSize = waterSize;
			for(int i=0;i<tempWaterSize;i++) {
				Pos waterPos = q.poll();
				waterSize--;
				for(int j=0;j<4;j++) {
					int waterR = waterPos.r + dir[j][0];
					int waterC = waterPos.c + dir[j][1];
					if(waterR>=0 && waterR<R && waterC>=0 && waterC<C && !visited[waterR][waterC]) {
						visited[waterR][waterC] = true;
						q.offer(new Pos(waterR, waterC));
						waterSize++;
					}
				}
			}
			// 고슴채움
			int tempHedgeSize = hedgeSize;
			for(int i=0;i<tempHedgeSize;i++) {
				Pos hedgePos = q.poll();
				hedgeSize--;
				for(int j=0;j<4;j++) {
					int hedgeR = hedgePos.r + dir[j][0];
					int hedgeC = hedgePos.c + dir[j][1];
					if(hedgeR>=0 && hedgeR<R && hedgeC>=0 && hedgeC<C && ((hedgeR==destR && hedgeC==destC) || !visited[hedgeR][hedgeC])) {
						if(hedgeR==destR && hedgeC==destC) {
							answer = cycle;
							break;
						}
						visited[hedgeR][hedgeC] = true;
						q.offer(new Pos(hedgeR, hedgeC));
						hedgeSize++;
					}
				}
			}
		}
		
		System.out.println((answer==0)? "KAKTUS" : answer);
	}
	
}
