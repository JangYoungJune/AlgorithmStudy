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
			for(int i=1;i<cage.length;i++) {
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
			
			splitX(0, startCage[0], endCage[0], hamster[0]);
			System.out.print("#"+tc);
			if(!satisfy){
				System.out.print(" -1");
			} else{
				for(int i=1;i<=N;i++){
					System.out.print(" "+answerCage[i]);
				}
			}
			System.out.println();
		}
	}
	public static void splitX(int order, int now, int end, int size) {
		if(order==M) {
			satisfy = true;
			int nowMax = 0;
			for(int i=1;i<=N;i++) {
				if(cage[i]==-1) {
					nowMax += X;
					cage[i] = X;
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
						for(int j=1;j<=N;j++) {
							answerCage[j] = cage[j];
						}
						break;
					} else if(cage[i]==answerCage[i]){
						continue;
					} else{
						break;
					}
				}
			}
		} else {
			if(now>end) { // 다음값으로 처리
				if(order+1==M){
					splitX(order+1, startCage[order], endCage[order], hamster[order]);
				}else{
					splitX(order+1, startCage[order+1], endCage[order+1], hamster[order+1]);
				}
			} else {
				if(end==now){
					if(size>X || (cage[now]!=-1 && cage[now]!=size)){
						return;
					}
					int temp = cage[now];
					cage[now] = size;
					splitX(order, now+1, end, size - cage[now]);
					cage[now] = temp;
				}else{
					if(cage[now]!=-1){
						if(size<cage[now]){
							return;
						}
						splitX(order, now+1, end, size - cage[now]);
					}else{
						int possibleLoop = (size>=X)? X : size;
						for(int i=0;i<=possibleLoop;i++){
							int temp = cage[now];
							cage[now] = i;
							splitX(order, now+1, end, size - i);
							cage[now] = temp;
						}
					}
				}
			}
		}
	}
}
