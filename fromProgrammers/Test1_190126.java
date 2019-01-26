package fromProgrammers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Test1_190126 {
	public static boolean solution(int[] arrA, int[] arrB) {
		boolean answer = false;
		Queue<Integer> queueA = new LinkedList<Integer>();
		for(int i=0;i<arrA.length;i++) {
			queueA.offer(arrA[i]);
		}
		for(int i=0;i<arrA.length;i++) {
			if(Arrays.equals(queueA.stream().mapToInt(w->w.intValue()).toArray(), arrB)) {
				answer = true;
				break;
			}
			queueA.offer(queueA.poll());
		}
		
		return answer;
	}
	
	
	public static void main(String args[]) {
		int[] a = {7,8,10};
		int[] b = {10,7,8};
		
		Boolean answer = solution(a, b);
		System.out.println(answer);
	}
}
