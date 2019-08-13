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
			int reverseDir = 0;
			if(dir!=0) {
				reverseDir = (dir%2==0)? dir-1 : dir+1;
			}
			for(int i=0;i<dir4d.length;i++) {
				boolean isPossible = false;
				int x = dir4d[i][0];
				int y = dir4d[i][1];
				int multi = 1;
				// 상하좌우에 R/B 가 붙어있을경우를 처리
				if(map[rPos[0]+x][rPos[1]+y]==map[bPos[0]][bPos[1]]) {
					multi++;
				}
				// 빈공간이 잇을경우 가능 처리 + 전방향을 돌아가는건 막자
				
				if(reverseDir!=i+1 && map[rPos[0]+multi*x][rPos[1]+multi*y]=='.') {
					isPossible = true;
				}
				// 해당 방향으로 이동이 불가능하다고 하면 다른 방향 체크
				if(!isPossible) {
					continue;
				}
				// 같은 라인에 있을경우를 체크
				boolean isSameLine = true;
				boolean moveRedFirst = true;
				if(x==0 && rPos[0]==bPos[0]) { // 가로축
					for(int j=Math.min(rPos[1], bPos[1]);j<=Math.max(rPos[1], bPos[1]);j++) {
						if(map[rPos[0]][j]=='#') {
							isSameLine = false;
							break;
						}
						if(isSameLine) {
							if(y>0) { // 왼쪽
								moveRedFirst = (Math.min(rPos[1],bPos[1])==rPos[1])? true : false;
							} else {
								moveRedFirst = (Math.min(rPos[1],bPos[1])==rPos[1])? false : true;
							}
						}
					}
				} else if(y==0 && rPos[1]==bPos[1]) { // 세로축
					for(int j=Math.min(rPos[0], bPos[0]);j<=Math.max(rPos[0], bPos[0]);j++) {
						if(map[j][rPos[1]]=='#') {
							isSameLine = false;
							break;
						}
						if(isSameLine) {
							if(x>0) { // 위
								moveRedFirst = (Math.min(rPos[0],bPos[0])==rPos[0])? true : false;
							} else {
								moveRedFirst = (Math.min(rPos[0],bPos[0])==rPos[0])? false : true;
							}
						}
					}
				}
				
				// 거리를 재서 R과 B를 이동시킨다.
				// 그다음에 방향값을 넣고 dfs 돌린다.
				int[] firstPos = (moveRedFirst)? rPos : bPos;
				int[] secondPos = (moveRedFirst)? bPos : rPos;
			}
		}
	}
	
	
	
}
