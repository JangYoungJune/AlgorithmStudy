package fromBOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW17281 {
	static int[][] arr;
	static int[] order;
	static int N;
	static int answer;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine().trim());
		arr = new int[N][9];
		order = new int[9];
		order[3] = 0;
		answer = 0;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine().trim(), " ");
			for(int j=0;j<9;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		perm(new int[] {1,2,3,4,5,6,7,8}, 0);
		System.out.println(answer);
	}
	public static void perm(int[] idxSet, int idx) {
		if(idx==idxSet.length) {
			int sIdx = 0;
			for(int i=0;i<9;i++) {
				if(i==3) {
					continue;
				}
				order[i] = idxSet[sIdx];
				sIdx++;
			}
			calcScore();
		} else {
			for(int i=idx;i<idxSet.length;i++) {
				int temp = idxSet[idx];
				idxSet[idx] = idxSet[i];
				idxSet[i] = temp;
				perm(idxSet, idx+1);
				idxSet[i] = idxSet[idx];
				idxSet[idx] = temp;
			}
			
		}
	}
	public static void calcScore() {
		int idx = 0;
		int inning = 0;
		int zeroCnt = 0;
		int score = 0;
		boolean[] bases = new boolean[3];
		while(inning<N) {
			int hit = arr[inning][order[idx]];
			
			if(hit==1 || hit==2 || hit==3) {
				for(int i=bases.length-1;i>=0;i--) {
					if(bases[i] && i+hit>=3) {
						bases[i] = false;
						score++;
					}else if(bases[i] && i+hit<3){
						bases[i] = false;
						bases[i+hit] = true;
					}
				}
				bases[hit-1] = true;
			} else if(hit==4) {
				int basePerson = 0;
				for(int i=0;i<bases.length;i++) {
					if(bases[i]) {
						basePerson++;
						bases[i] = false;
					}
				}
				score+=(basePerson+1);
			} else {
				zeroCnt++;
			}
			
			idx = (idx+1)%9;
			if(zeroCnt>=3) {
				for(int i=0;i<bases.length;i++) {
					bases[i] = false;
				}
				inning++;
				zeroCnt = 0;
			}
		}
		if(score>answer) {
			answer = score;
		}
	}
}
