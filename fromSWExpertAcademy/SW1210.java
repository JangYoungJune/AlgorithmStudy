package fromSWExpertAcademy;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW1210 {
	static int[][] map;
	static int answer;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		map = new int[100][100]; // create map
		for (int tc = 1; tc <= 10; tc++) {
			int testNum = Integer.parseInt(br.readLine());
			int startX = 0;
			int startY = 0;
			for (int i = 0; i < map.length; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < map[i].length; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j]==2) {
						startX = j;
						startY = i;
					}
				}
			}
			findStart(startX,startY,0);
			System.out.printf("#%d %d\n", testNum, answer);
		}
	}
	
	// dir:0 > 상태없음or위 / 1 > 좌 / 2 > 우
	public static void findStart(int x, int y, int dir) {
		if(y==0) {
			answer = x;
		}else {
			// 좌/우/위 순서로 확인한다 
			if(x-1>=0 && (dir==0 || dir==1) && map[y][x-1]==1) {
				findStart(x-1, y, 1);
			} else if(x+1<100 && (dir==0 || dir==2) && map[y][x+1]==1) {
				findStart(x+1, y, 2);
			} else {
				findStart(x, y-1, 0);
			}
		}
	}
}
