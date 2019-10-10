package fromBOJ;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SW4963 {
	static int[][] dir = {{1,0},{0,1},{-1,0},{0,-1},{1,1},{-1,-1},{-1,1},{1,-1}};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String startInput;
		while(!(startInput = br.readLine().trim()).equals("0 0")) {
			StringTokenizer st = new StringTokenizer(startInput," ");
			int C = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			boolean[][] arr = new boolean[R][C];
			for(int i=0;i<R;i++) {
				st = new StringTokenizer(br.readLine().trim()," ");
				for(int j=0;j<C;j++) {
					arr[i][j] = Integer.parseInt(st.nextToken())==1? true : false;
				}
			}
			Queue<Integer> qX = new LinkedList<>();
			Queue<Integer> qY = new LinkedList<>();
			int answer = 0;
			for(int i=0;i<R;i++) {
				for(int j=0;j<C;j++) {
					if(arr[i][j]) {
						qX.offer(i);
						qY.offer(j);
						while(!qX.isEmpty()) {
							int x = qX.poll();
							int y = qY.poll();
							for(int d=0;d<dir.length;d++) {
								int rx = x+dir[d][0];
								int ry = y+dir[d][1];
								if(rx>=0 && rx<R && ry>=0 && ry<C && arr[rx][ry]) {
									arr[rx][ry] = false;
									qX.offer(rx);
									qY.offer(ry);
								}
							}
						}
						answer++;
					}
				}
			}
			System.out.println(answer);
		}
		
	}
}
