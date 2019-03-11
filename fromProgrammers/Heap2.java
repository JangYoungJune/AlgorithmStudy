package AlgorithmStudy.fromProgrammers;

import java.util.Collections;
import java.util.PriorityQueue;

/*
 * problem URL: https://programmers.co.kr/learn/courses/30/lessons/42629?language=java
 * */
public class Heap2 {
    // use priorityQueue(heap)
    // use while loop when stock is less then k(k is limitation value)
    // in while loop - use for loop to offer supplyQueue's value.
    // At the same time, set and condition startDate to control supplies array's value duplication
    // in while loop - pop the biggest value and add stock value.
    // in while loop - add cycle count(answer's value)
    public static int solution(int stock, int[] dates, int[] supplies, int k) {
        int answer = 0;
        int startDate = -1;
        PriorityQueue<Integer> supplyQueue = new PriorityQueue<>(Collections.reverseOrder());
        while(stock < k){
            for(int i=0;i<dates.length;i++){
                if(dates[i]<=stock && startDate<dates[i]){
                    supplyQueue.offer(supplies[i]);
                    startDate = dates[i];
                }
            }
            int popValue = supplyQueue.poll();
            stock += popValue;
            answer++;
        }
        return answer;
    }

    public static void main(String args[]) {
        int a = 4;
        int[] b = {4,10,15};
        int[] c = {20, 5, 10};
        int d = 30;

        int answer = solution(a,b,c,d);
        System.out.println(answer);
    }
}
