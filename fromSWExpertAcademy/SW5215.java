package fromSWExpertAcademy;

import java.util.Scanner;

public class SW5215 {
	static int ind_num, max_cal, max_score;
	static int[] scores, cals;
	
	public static void dfs(int score, int cal, int pos) {
		if(cal>max_cal) {
			return;
		}
		if(pos+1 > ind_num) {
			max_score = (max_score>=score)? max_score : score;
			return;
		}
		dfs(score+scores[pos], cal+cals[pos], pos+1);
		dfs(score, cal, pos+1);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc_num = sc.nextInt();
		for(int tc=1;tc<=tc_num;tc++) {
			max_score = 0;
			ind_num = sc.nextInt();
			max_cal = sc.nextInt();
			scores = new int[ind_num];
			cals = new int[ind_num];
			
			for(int i=0;i<ind_num;i++) {
				scores[i] = sc.nextInt();
				cals[i] = sc.nextInt();
			}
			
			dfs(0, 0, 0);
			
			System.out.println("#"+tc+" "+max_score);
		}
		sc.close();
	}
}
