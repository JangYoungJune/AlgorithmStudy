package fromProgrammers;

import java.util.HashMap;

/*
  * problem URL: https://programmers.co.kr/learn/courses/30/lessons/42577
  * */
public class Hash2 {
	public static boolean solution(String[] p) {
		Boolean answer = true;
		for(int i=0;i<p.length;i++) {
			for(int j=0;j<p.length;j++) {
				if(i==j) {
					continue;
				} else {
					if(p[i].indexOf(p[j])==0) {
						answer = false;
						break;
					}
				}
			}
		}
		return answer;
	}
	
	public static void main(String args[]) {
		String[] a = {"12232332", "12", "222222"};
		String[] b = {"123", "456", "789"};
		String[] c = {"12", "123", "1235", "567", "88"};
		
		Boolean answer = solution(a);
		System.out.println(answer);
	}
}
