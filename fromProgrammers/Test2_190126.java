package fromProgrammers;

import java.util.Arrays;

public class Test2_190126 {
	public static int solution(int l, int[] v) {
		int answer = 0;
		Arrays.sort(v);
		for(int i=0;i<v.length;i++) {
			if(i==0) {
				answer = v[i];
			} else {
				int nowLength = v[i] - v[i-1];
				int nowD = (nowLength/2) + ((nowLength%2==1)? 1 : 0);
				answer = (answer>nowD)? answer : nowD;
			}
		}
		int sideD = l - v[v.length-1];
		answer = (answer>sideD)? answer : sideD;
		
		return answer;
	}
	
	
	public static void main(String args[]) {
		int a = 1000;
		int[] b = {30};
		
		int answer = solution(a, b);
		System.out.println(answer);
	}
}
