package fromSWExpertAcademy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class SW2819 {
	static String[][] arr = new String[4][4];
	static HashSet<String> answerSet = new HashSet<>();
	static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int tcNum = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= tcNum; tc++) {
			for (int i = 0; i < 4; i++) {
				st = new StringTokenizer(br.readLine().trim(), " ");
				for (int j = 0; j < 4; j++) {
					arr[i][j] = st.nextToken();
				}
			}
			for(int i=0;i<16;i++) {
				dfs(i/4,i%4, new String(arr[i/4][i%4]));
			}
			System.out.println("#"+tc+" "+answerSet.size());
			answerSet.clear();
		}
		br.close();
	}
	public static void dfs(int x, int y, String answer) {
		if(answer.length()==7) {
			answerSet.add(answer);
			return;
		} else {
			for(int i=0;i<4;i++) {
				int newX = x+dir[i][0];
				int newY = y+dir[i][1];
				if(canVisit(newX, newY)) {
					dfs(newX, newY, new String(answer+arr[newX][newY]));
				}
			}
		}
	}
	public static boolean canVisit(int x, int y) {
		if(x>=0 && x<4 && y>=0 && y<4) {
			return true;
		}
		return false;
	}
}
