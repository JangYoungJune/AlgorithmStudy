package fromSWExpertAcademy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class SW1907 {
	static int[][] dir = {{0,1},{1,0},{0,-1},{-1,0},{1,1},{-1,1},{1,-1},{-1,-1}};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tcNum = Integer.parseInt(br.readLine().trim());
		for(int tc=1;tc<=tcNum;tc++) {
			int totalCount = 0;
			
			String[] matrixStr = br.readLine().trim().split(" ");
			int R = Integer.parseInt(matrixStr[0]);
			int C = Integer.parseInt(matrixStr[1]);
			int[][] arr = new int[R][C];
			
			for(int i=0;i<R;i++) {
				char[] arrStr = br.readLine().trim().toCharArray();
				for(int j=0;j<C;j++) {
					arr[i][j] = (arrStr[j]=='.')? 0 : arrStr[j] - '0';
				}
			}
			
			Queue<Integer> removeR = new LinkedList<Integer>();
			Queue<Integer> removeC = new LinkedList<Integer>();
			
			for(int i=0;i<R;i++) {
				for(int j=0;j<C;j++) {
					if(arr[i][j]==0) {
						continue;
					}
					arr[i][j] = arr[i][j] - getEmptyCount(arr, i,j);
					if(arr[i][j]<=0) {
						arr[i][j] = -1;
						removeR.offer(i);
						removeC.offer(j);
					}
				}
			}
			
			while(!removeR.isEmpty()) {
				int tempSize = removeR.size();
				for(int q=0;q<tempSize;q++) {
					int rr = removeR.poll();
					int rc = removeC.poll();
					arr[rr][rc] = 0;
					for(int i=0;i<dir.length;i++) {
						int cr = rr-dir[i][0];
						int cc = rc-dir[i][1];
						if(cr>=0 && cr<R && cc>=0 && cc<C && arr[cr][cc]>0) {
							arr[cr][cc]--;
							if(arr[cr][cc]==0) {
								removeR.offer(cr);
								removeC.offer(cc);
							}
						}
					}
				}
				totalCount++;
			}
			System.out.println("#"+tc+" "+totalCount);
		}
	}
	
	public static int getEmptyCount(int[][] charArr, int r, int c) {
		int count = 0;
		for(int i=0;i<dir.length;i++) {
			int checkR = r-dir[i][0];
			int checkC = c-dir[i][1];
			if(charArr[checkR][checkC]==0) {
				count++;
			} 
		}
		return count;
	}
}


