package fromProgrammers;

import java.util.LinkedList;
import java.util.Queue;

/* project URL: https://programmers.co.kr/learn/courses/30/lessons/42583
*/

public class StackQueue3 {
	public static int solution(int bridge_length, int weight, int[] truck_weights) {
		int answer = 0;
		Queue<Integer> waitTruck = new LinkedList<>();
		Queue<Integer> runTruckPosition = new LinkedList<>();
		Queue<Integer> lengthState = new LinkedList<>();
		
		for(int value : truck_weights) {
			waitTruck.add(value);
		}
		
		do {
			answer++;
			// car pass by road
			while(!lengthState.isEmpty() && lengthState.peek() >= bridge_length) {
				runTruckPosition.poll();
				lengthState.poll();
			}
			// car enter the road
			int road_weight = runTruckPosition.stream().mapToInt(i->i.intValue()).sum();
			if(!waitTruck.isEmpty() && (road_weight+ waitTruck.peek() <= weight)) {
				runTruckPosition.add(waitTruck.poll());
				lengthState.add(0);
			}
			// run truck's position add 1
			for(int i=0;i<lengthState.size();i++) {
				lengthState.add(lengthState.poll()+1);
			}
		}while(waitTruck.size()!=0 || runTruckPosition.size()!=0);
		
		return answer;
	}
	
	public static void main(String args[]) {
		int a = 100;
		int b = 100;
		int[] c = {10,10,10,10,10,10,10,10,10,10};
		
		
		int answer = solution(a, b, c);
		System.out.println(answer);
	}
}
