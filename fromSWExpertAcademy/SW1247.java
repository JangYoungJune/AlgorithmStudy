package fromSWExpertAcademy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SW1247 {
	static int[] xSet, ySet;
	static int xHome, yHome;
	static int xCom, yCom;
	static int answer;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tcNum = Integer.parseInt(br.readLine().trim());
		for(int tc=1;tc<=tcNum;tc++) {
			int N = Integer.parseInt(br.readLine().trim());
			xSet = new int[N];
			ySet = new int[N];
			answer = Integer.MAX_VALUE;
			
			String[] str = br.readLine().trim().split(" ");
			xCom = Integer.parseInt(str[0]);
			yCom = Integer.parseInt(str[1]);
			xHome = Integer.parseInt(str[2]);
			yHome = Integer.parseInt(str[3]);
			for(int i=4;i<str.length;i+=2) {
				xSet[i/2-2] = Integer.parseInt(str[i]);
				ySet[i/2-2] = Integer.parseInt(str[i+1]);
			}
			
			perm(N, 0);
			
			System.out.println("#"+tc+" "+answer);
		}
	}
	public static void perm(int max, int idx) {
		if(idx==max) {
			int score = 0;
			score += (Math.abs(xCom-xSet[0]) + Math.abs(yCom-ySet[0]));
			score += (Math.abs(xHome-xSet[max-1]) + Math.abs(yHome-ySet[max-1]));
			for(int i=0;i<max-1;i++) {
				score += (Math.abs(xSet[i+1]-xSet[i]) + Math.abs(ySet[i+1]-ySet[i]));
			}
			if(answer>score) {
				answer = score;
			}
		} else {
			for(int i = idx;i<max;i++) {
				int tempX = xSet[idx];
				xSet[idx] = xSet[i];
				xSet[i] = tempX;
				int tempY = ySet[idx];
				ySet[idx] = ySet[i];
				ySet[i] = tempY;
				perm(max, idx+1);
				tempX = xSet[idx];
				xSet[idx] = xSet[i];
				xSet[i] = tempX;
				tempY = ySet[idx];
				ySet[idx] = ySet[i];
				ySet[i] = tempY;
			}
		}
	}
}
