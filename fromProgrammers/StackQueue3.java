package fromProgrammers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/* project URL: https://programmers.co.kr/learn/courses/30/lessons/42583
*/

public class StackQueue3 {
	public static int solution(int bridge_length, int weight, int[] truck_weights) {
		int answer = 0;
		int truckOrder = 0;
		Queue<Integer> bridgeState = new LinkedList<>();
		List<Integer> timer = new ArrayList<>();
		do {
			answer++;
			for(int i=0;i<timer.size();i++) {
				timer.set(i, timer.get(i)+1);
			}
			if(!timer.isEmpty() && timer.get(0)==bridge_length) {
				bridgeState.poll();
				timer.remove(0);
			}
			int sumOfBridge = bridgeState.stream().reduce(0, (a,b)->a+b).intValue();
			if(truckOrder < truck_weights.length) {
				if(sumOfBridge + truck_weights[truckOrder] <= weight && bridge_length > bridgeState.size()) {
					bridgeState.offer(truck_weights[truckOrder]);
					timer.add(1);
					truckOrder++;
				}
			}
		}while(bridgeState.size()!=0);
		
		return answer+1;
	}
	
	public static void main(String args[]) {
		int a = 2;
		int b = 10;
		int[] c = {7,4,5,6};
		
		
		int answer = solution(a, b, c);
		System.out.println(answer);
	}
}
