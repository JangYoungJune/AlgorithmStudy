package fromSWExpertAcademy;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class SW1249 {
	static int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tcNum = Integer.parseInt(br.readLine().trim());
		for(int tc=1;tc<=tcNum;tc++) {
			int N = Integer.parseInt(br.readLine().trim());
			int[][] arr = new int[N][N];
			int[][] weight = new int[N][N];
			for(int i=0;i<N;i++) {
				String str = br.readLine().trim();
				for(int j=0;j<N;j++) {
					arr[i][j] = str.charAt(j)-'0';
					weight[i][j] = -1;
				}
			}
			Queue<Integer> queueX = new LinkedList<>();
			Queue<Integer> queueY = new LinkedList<>();
			weight[0][0] = 0;
			queueX.offer(0);
			queueY.offer(0);
			while(!queueX.isEmpty()) {
				int x = queueX.poll();
				int y = queueY.poll();
				for(int i=0;i<4;i++) {
					int rx = x + dir[i][0];
					int ry = y + dir[i][1];
					if(rx>=0 && rx<N && ry>=0 && ry<N && (weight[rx][ry]==-1 || weight[rx][ry]>weight[x][y]+arr[rx][ry])) {
						weight[rx][ry] = weight[x][y]+arr[rx][ry];
						queueX.offer(rx);
						queueY.offer(ry);
					}
					
				}
			}
			System.out.println("#"+tc+" "+weight[N-1][N-1]);
		}
	}
}
