package fromBOJ;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SW1987 {
	static char[][] map;
	static int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
	static boolean[] alphaCheck = new boolean[26];
	static int R, C;
	static int answer;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] sizeStr = br.readLine().trim().split(" ");
		R = Integer.parseInt(sizeStr[0]);
		C = Integer.parseInt(sizeStr[1]);
		map = new char[R][C];
		answer = 1;
		for(int i=0;i<R;i++) {
			String arr = br.readLine().trim();
			for(int j=0;j<C;j++) {
				map[i][j] = arr.charAt(j);
			}
		}
		alphaCheck[map[0][0]-'A'] = true;
		dfs(0,0,1);
		
		System.out.println(answer);
	}
	public static void dfs(int r, int c, int depth) {
		boolean isMove = false;
		for(int i=0;i<4;i++) {
			int newR = r+dir[i][0];
			int newC = c+dir[i][1];
			if(newR>=0 && newR<R && newC>=0 && newC<C && !alphaCheck[map[newR][newC]-'A']) {
				isMove = true;
				alphaCheck[map[newR][newC]-'A'] = true;
				dfs(newR, newC, depth+1);
				alphaCheck[map[newR][newC]-'A'] = false;
			}
		}
		
		if(!isMove) {
			if(answer<depth) {
				answer = depth;
			}
		}
	}
}
