package fromSWExpertAcademy;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SW3349 {
	static class Pos{
		int x;
		int y;
		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int tcNum = Integer.parseInt(br.readLine().trim());
		for(int tc=1;tc<=tcNum;tc++) {
			st = new StringTokenizer(br.readLine().trim(), " ");
			int W = Integer.parseInt(st.nextToken());
			int H = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			Pos[] pos = new Pos[N];
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine().trim()," ");
				pos[i] = new Pos(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1);
			}
			
			int startX = pos[0].x;
			int startY = pos[0].y;
			int answer = 0;
			for(int i=1;i<N;i++) {
				int destX = pos[i].x;
				int destY = pos[i].y;
				if(startX != destX || startY != destY)  {
					while(startX < destX && startY < destY) {
						startX++;
						startY++;
						answer++;
					}
					while(startX > destX && startY > destY) {
						startX--;
						startY--;
						answer++;
					}
					answer += Math.abs(destX-startX) + Math.abs(destY-startY);
				}
				startX = destX;
				startY = destY;
			}
			System.out.println("#"+tc+" "+answer);
		}
	}
}