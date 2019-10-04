package fromBOJ;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SW2636 {
	static class Pos{
		int r;
		int c;
		public Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	static int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
	static Queue<Pos> air;
	static Queue<Pos> cheese;
	static int[][] map;
	static boolean[][] visited;
	static int R,C;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim()," ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		visited = new boolean[R][C];
		air = new LinkedList<>();
		cheese = new LinkedList<>();
		
		for(int i=0;i<R;i++) {
			st = new StringTokenizer(br.readLine().trim()," ");
			for(int j=0;j<C;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(i==0 || i==R-1 || j==0 || j==C-1) {
					air.add(new Pos(i,j));
					visited[i][j] = true;
				}
			}
		}
		
		getCheeseFromAir();
		
		int cycle = 0;
		int cheeseSize = 0;
		while(!cheese.isEmpty()) {
			cycle++;
			cheeseSize = cheese.size();
			for(int i=0;i<cheeseSize;i++) {
				Pos pop = cheese.poll();
				map[pop.r][pop.c] = 0;
				for(int j=0;j<4;j++) {
					int newR = pop.r + dir[j][0];
					int newC = pop.c + dir[j][1];
					if(newR>=0 && newR<R && newC>=0 && newC<C && !visited[newR][newC]) {
						visited[newR][newC] = true;
						if(map[newR][newC]==1) {
							cheese.offer(new Pos(newR, newC));
						} else {
							air.offer(new Pos(newR, newC));
							getCheeseFromAir();
						}
					}
				}
			}
		}
		
		System.out.println(cycle);
		System.out.println(cheeseSize);
	}
	
	public static void getCheeseFromAir() {
		while(!air.isEmpty()) {
			Pos pop = air.poll();
			for(int i=0;i<4;i++) {
				int newR = pop.r + dir[i][0];
				int newC = pop.c + dir[i][1];
				if(newR>=0 && newR<R && newC>=0 && newC<C && !visited[newR][newC]) {
					visited[newR][newC] = true;
					if(map[newR][newC]==1) {
						cheese.offer(new Pos(newR, newC));
					} else {
						air.offer(new Pos(newR, newC));
					}
				}
			}
		}
	}
}
