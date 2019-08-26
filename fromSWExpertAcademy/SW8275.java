package fromSWExpertAcademy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW8275 {
	static int[] startCage;
	static int[] endCage;
	static int[] hamster;
	static int maxX;
	static int[] answerCage;
	static int[] cage;
	static boolean satisfy;
	static int N,X,M;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int tcNum = Integer.parseInt(br.readLine().trim());
		for(int tc=1;tc<=tcNum;tc++) {
			st = new StringTokenizer(br.readLine().trim());
			N = Integer.parseInt(st.nextToken()); // 우리 갯수
			X = Integer.parseInt(st.nextToken()); // 한 우리당 햄스터 최대 값
			M = Integer.parseInt(st.nextToken());
			
			cage = new int[N+1];
			answerCage = new int[N+1];
			for(int i=0;i<=cage.length;i++) {
				cage[i] = -1;
			}
			maxX = -1;
			satisfy = false;
			
			startCage = new int[M];
			endCage = new int[M];
			hamster = new int[M];
			
			for(int i=0;i<M;i++) {
				st = new StringTokenizer(br.readLine().trim());
				startCage[i] = Integer.parseInt(st.nextToken());
				endCage[i] = Integer.parseInt(st.nextToken());
				hamster[i] = Integer.parseInt(st.nextToken());
			}
			
			splitX(0, startCage[0], endCage[0]);
			
		}
	}
	public static void splitX(int order, int now, int end) {
		if(order==M) {
			satisfy = true;
			int nowMax = 0;
			for(int i=1;i<=N;i++) {
				if(cage[i]==-1) {
					nowMax += X;
				}else {
					nowMax += cage[i];
				}
			}
			if(nowMax>maxX) {
				maxX = nowMax;
				for(int i=1;i<=N;i++) {
					answerCage[i] = cage[i];
				}
			} else if(nowMax==maxX) {
				for(int i=1;i<=N;i++) {
					if(cage[i]<answerCage[i]) {
						
					}
				}
				
			}
		} else {
			if(now>end) { // 다음값으로 처리
				splitX(order+1, startCage[order+1], endCage[order+1]);
			} else {
				splitX(order, now+1, end);
			}
		}
	}
}

/**
3 5
1 3 8
0 3 5
5 1 2
5 0 3
 */

