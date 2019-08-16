package fromBOJ;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW17406 {
	static int N, M;
	static int cycle;
	static int[][] arr, copyArr;
	static int[] cycleR, cycleC, cycleS;
	static int minX, maxX, minY, maxY;
	static int minValue = Integer.MAX_VALUE;
	static int[] cycleOrder = new int[6];
	static boolean[] useOrder = new boolean[6];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine().trim(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		cycle = Integer.parseInt(st.nextToken());
		
		arr = new int[N+1][M+1];
		copyArr = new int[N+1][M+1];
		
		cycleR = new int[cycle];
		cycleC = new int[cycle];
		cycleS = new int[cycle];
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine().trim(), " ");
			for(int j=1;j<=M;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0;i<cycle;i++) {
			st = new StringTokenizer(br.readLine().trim(), " ");
			cycleR[i] = Integer.parseInt(st.nextToken());
			cycleC[i] = Integer.parseInt(st.nextToken());
			cycleS[i] = Integer.parseInt(st.nextToken());
		}
		makeOrder(0);
		System.out.println(minValue);
	}
	public static void makeOrder(int cnt) {
		if(cnt>=cycle) {
			for(int a=1;a<=N;a++) {
				for(int b=1;b<=M;b++) {
					copyArr[a][b] = arr[a][b];
				}
			}
			for(int i=0;i<cycle;i++) {
				minX = cycleR[cycleOrder[i]] - cycleS[cycleOrder[i]];
				maxX = cycleR[cycleOrder[i]] + cycleS[cycleOrder[i]];
				minY = cycleC[cycleOrder[i]] - cycleS[cycleOrder[i]];
				maxY = cycleC[cycleOrder[i]] + cycleS[cycleOrder[i]];
				makeCycleArr();
			}
			for(int i=1;i<=N;i++) {
				int sum = 0;
				for(int j=1;j<=M;j++) {
					sum+=copyArr[i][j];
				}
				if(minValue>sum) {
					minValue = sum;
				}
			}
		} else {
			for(int i=0;i<cycle;i++) {
				if(useOrder[i]==false) {
					useOrder[i] = true;
					cycleOrder[cnt] = i;
					makeOrder(cnt+1);
					useOrder[i] = false;
				}
			}
		}
	}
	// 방향을 정하자! 왼1 아2 오3 위4 끝5
	public static void makeCycleArr() {
		while(minX<maxX) {
			// 돌려준다
			int dir = 1;
			int x = minX;
			int y = minY;
			int prevValue = copyArr[x][y];
			while(dir!=5) {
				int temp = copyArr[x][y]; 
				copyArr[x][y] = prevValue;
				prevValue = temp;
				
				if(dir==1) {
					if(y+1>maxY) {
						dir++;
						x++;
					} else {
						y++;
					}
				} else if(dir==2) {
					if(x+1>maxX) {
						dir++;
						y--;
					} else {
						x++;
					}
				} else if(dir==3) {
					if(y-1<minY) {
						dir++;
						x--;
					} else {
						y--;
					}
				} else if(dir==4) {
					if(x-1<minX) {
						dir++;
					} else {
						x--;
					}
				}
			}
			// 돌리면 값을 줄인다.
			minX++;
			minY++;
			maxX--;
			maxY--;
		}
	}
}
