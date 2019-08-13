package fromBOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class SW13460 {
	static int N, M;
	static char map[][];
	static int[] rPos = new int[2];
	static int[] bPos = new int[2];
	static int answer = -1; 
	static int[][] dir4d = {{-1,0},{1,0},{0,-1},{0,1}};
	static Stack<Integer> dir = new Stack<>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().trim().split(" ");
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		map = new char[N][M];
		// init and read data 
		for(int i=0;i<N;i++) {
			char[] charArr = br.readLine().trim().toCharArray();
			for(int j=0;j<M;j++) {
				map[i][j] = charArr[j];
				if(map[i][j]=='R') {
					rPos[0] = i;
					rPos[1] = j;
				} else if(map[i][j]=='B') {
					bPos[0] = i;
					bPos[1] = j;
				}
			}
		}
		// dfs map
		// 먼저 R을 기준으로 상하좌우를 찾는다 >> 되는것은 전부 dfs한다 / 횟수도 체크한다.
		dfs(0, false, false, 0);
		System.out.println(answer);
	}
	// dir = 0:상태없음 / 1: 위 / 2: 아래 / 3: 좌 / 4: 우
	public static void dfs(int cnt, boolean passRed, boolean passBlue, int dir) {
		if(!passBlue && passRed && cnt<=10) {
			if(answer==-1 || answer>cnt) {
				answer=cnt;
			}
		} else if(cnt>10 || passBlue) {
			return;
		} else {
			// 만약 상하나 좌우로 갈때, 공이 같이 움직일 수 있다>? 앞에 있는걸 먼저 움직임 + 다음걸 움직임
			// 공을 움직일때, 미리 빈공간 갯수를 세어 넘겨줌 + 만약 공이 같이 움직이는 상황이면? 공 위치 전으로 옮기는거 잊지말자
			int reverseDir = -1;
			if(dir!=0) {
				reverseDir = (dir%2==0)? dir-1 : dir+1;
			}
			for(int i=0;i<dir4d.length;i++) {
				int x = dir4d[i][0];
				int y = dir4d[i][1];
				// 블루 또는 레드가 해당 방향으로 이동하는데, 값이 바뀔게 없다? 그럼 그 길은 skip / 아니면 케이스 GO + 이전경로로 번복할경우
				// 두 색 중 하나는 방향으로 1칸이라도 이동하는데 .이나 0을 만나야 한다.
				if(dir==reverseDir || !(canMove(rPos[0]+x,rPos[1]+y) || canMove(bPos[0]+x,bPos[1]+y))) {
					continue;
				}
				
				boolean metBlue = false;
				boolean metRed = false;
				boolean canRedPass = false;
				boolean canBluePass = false;
				int rIdx = 0;
				int bIdx = 0;
				// rPos와 bPos를 저장 > 새로운 위치의 rPos, bPos, map을 구성하고 dfs > 다시 돌림
				while(map[rPos[0]+(rIdx+1)*x][rPos[1]+(rIdx+1)*y]!='#') {
					if(map[rPos[0]+(rIdx+1)*x][rPos[1]+(rIdx+1)*y]=='B') {
						metBlue = true;
					}
					if(map[rPos[0]+(rIdx+1)*x][rPos[1]+(rIdx+1)*y]=='O') {
						canRedPass = true;
					}
					rIdx++;
				}
				while(map[bPos[0]+(bIdx+1)*x][bPos[1]+(bIdx+1)*y]!='#') {
					if(map[bPos[0]+(bIdx+1)*x][bPos[1]+(bIdx+1)*y]=='R') {
						metRed = true;
					}
					if(map[bPos[0]+(bIdx+1)*x][bPos[1]+(bIdx+1)*y]=='O') {
						canBluePass = true;
					}
					bIdx++;
				}
				if(canBluePass || canRedPass) {
					dfs(cnt+1,canRedPass, canBluePass, i+1);
				} else {
					int[] copyRPos = new int[2];
					int[] copyBPos = new int[2];
					for(int j=0;j<2;j++) {
						copyRPos[j] = rPos[j];
						copyBPos[j] = bPos[j];
					}
					if(metBlue) { // 가는 길목에 파란공이 있다? 기존 idx값에는 blue공을 넣어주고 이전칸에 빨간공을 이동시켜준다.
						rPos[0] = rPos[0] + (rIdx-1)*x;
						rPos[1] = rPos[1] + (rIdx-1)*y;
						map[copyRPos[0]][copyRPos[1]] = '.';
						map[rPos[0]][rPos[1]] = 'R';
						bPos[0] = bPos[0] + bIdx*x;
						bPos[1] = bPos[1] + bIdx*y;
						map[copyBPos[0]][copyBPos[1]] = '.';
						map[bPos[0]][bPos[1]] = 'B';
					} else if(metRed){ // 빨간공을 해당 위치로 이동시킴 > while로 파란공 위치를 찾는다(R을 만나는 경우에도 멈추게 해주면 된다.) + 파란공 위치로 이동
						rPos[0] = rPos[0] + rIdx*x;
						rPos[1] = rPos[1] + rIdx*y;
						map[copyRPos[0]][copyRPos[1]] = '.';
						map[rPos[0]][rPos[1]] = 'R';
						bPos[0] = bPos[0] + (bIdx-1)*x;
						bPos[1] = bPos[1] + (bIdx-1)*y;
						map[copyBPos[0]][copyBPos[1]] = '.';
						map[bPos[0]][bPos[1]] = 'B';
					} else {
						rPos[0] = rPos[0] + rIdx*x;
						rPos[1] = rPos[1] + rIdx*y;
						map[copyRPos[0]][copyRPos[1]] = '.';
						map[rPos[0]][rPos[1]] = 'R';
						bPos[0] = bPos[0] + bIdx*x;
						bPos[1] = bPos[1] + bIdx*y;
						map[copyBPos[0]][copyBPos[1]] = '.';
						map[bPos[0]][bPos[1]] = 'B';
					}
					
					dfs(cnt+1,canRedPass, canBluePass, i+1);
					
					map[rPos[0]][rPos[1]] = '.';
					map[bPos[0]][bPos[1]] = '.';
					rPos = copyRPos;
					bPos = copyBPos;
					map[rPos[0]][rPos[1]] = 'R';
					map[bPos[0]][bPos[1]] = 'B';
				}
			}
		}
	}
	public static boolean canMove(int x, int y) {
		if(map[x][y]=='.' || map[x][y]=='O') {
			return true;
		} else {
			return false;
		}
	}
	
	
	
}
