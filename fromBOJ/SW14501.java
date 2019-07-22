package fromBOJ;

import java.util.Scanner;

public class SW14501 {
	static int N;
	static int[] time;
	static int[] pay;
	static int answer;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		answer = 0;
		time = new int[N];
		pay = new int[N];
		for(int i=0;i<N;i++) {
			time[i] = sc.nextInt();
			pay[i] = sc.nextInt();
		}
		dfs(0, 0, 0);
		System.out.println(answer);
		sc.close();
	}
	public static void dfs(int day, int ing, int total) {
		if(day==N) {
			answer = (answer<total)? total:answer;
		} else {
			if(ing!=0) {
				dfs(day+1, ing-1, total);
			} else {
				if(day+time[day]<=N) {
					dfs(day+1, time[day]-1, total+pay[day]);
				}
				dfs(day+1, ing, total);
			}
		}
	}
}
