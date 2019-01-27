package fromProgrammers;

import java.util.LinkedList;
import java.util.Queue;


/* project URL: https://programmers.co.kr/learn/courses/30/lessons/42587
*/

public class StackQueue2 {
	public static int solution(int[] priorities, int location) {
		int answer = 0;
		boolean isEnd = false;
		Queue<Integer> order = new LinkedList<Integer>();
		for(int i=0;i<priorities.length;i++) {
			order.offer(priorities[i]);
		}
		while(!isEnd) {
			int maxVal = order.stream().mapToInt(i->i).max().getAsInt();
			int frontVal = order.poll();
			if(frontVal<maxVal) {
				order.offer(frontVal);
				if(location==0) {
					location = order.size()-1;
				} else {
					location--;
				}
				
			} else {
				answer++;
				if(location==0) {
					isEnd = true;
				} else {
					location--;
				}
			}
		}
		return answer;
	}
	
	public static void main(String args[]) {
		int[] a = {1,1,9,1,1,1};
		int b = 0;
		
		int answer = solution(a, b);
		System.out.println(answer);
	}
}
