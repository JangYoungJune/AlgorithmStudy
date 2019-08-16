package fromBOJ;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SW2468 {
	static int N;
	static int[][] map;
	static int[][] copyMap;
	static boolean[] heightMap = new boolean[101];
	static int answer = 0;
	static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine().trim());
		map = new int[N][N];
		copyMap = new int[N][N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine().trim(), " ");
			for(int j=0;j<N;j++) {
				int h = Integer.parseInt(st.nextToken());
				map[i][j] = h;
				heightMap[h] = true;
			}
		}
		//bfs로 지형 갯수 세기
		for(int w=1;w<=100;w++) {
			if(!heightMap[w]) { // 해당 높이의 건물이 없으면 넘어가자
				continue;
			}
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(map[i][j]==w) {
						map[i][j] = 0;
					}
					copyMap[i][j] = map[i][j];
				}
			}
			cntSafeZone();
		}
		System.out.println(answer==0? 1: answer);
		br.close();	
	}
	public static void cntSafeZone() {
		int count = 0;
		Queue<Integer> safeX = new LinkedList<>();
		Queue<Integer> safeY = new LinkedList<>();
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(copyMap[i][j]==0) {
					continue;
				}
				safeX.offer(i);
				safeY.offer(j);
				copyMap[i][j] = 0;
				while(!safeX.isEmpty()) {
					int x = safeX.poll();
					int y = safeY.poll();
					for(int k=0;k<4;k++) {
						if(x+dir[k][0]>=0 && x+dir[k][0]<N && y+dir[k][1]>=0 && y+dir[k][1]<N && copyMap[x+dir[k][0]][y+dir[k][1]]!=0) {
							safeX.offer(x+dir[k][0]);
							safeY.offer(y+dir[k][1]);
							copyMap[x+dir[k][0]][y+dir[k][1]] = 0;
						}
					}
				}
				count++;
			}
		}
		if(answer<count) {
			answer = count;
		}
		
	}
}
