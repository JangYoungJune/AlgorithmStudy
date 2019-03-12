package AlgorithmStudy.fromProgrammers;

import java.util.Collections;
import java.util.PriorityQueue;

/*
 * problem URL: https://programmers.co.kr/learn/courses/30/lessons/42628?language=java
 * */
public class Heap4 {
    public static int[] solution(String[] operations) {
        int[] answer = new int[2];
        PriorityQueue<Integer> ascQueue = new PriorityQueue<>();
        PriorityQueue<Integer> descQueue = new PriorityQueue<>(Collections.reverseOrder());
        for(String mixed : operations){
            String[] mixArr = mixed.split(" ");
            String op = mixArr[0];
            int val = Integer.parseInt(mixArr[1]);
            switch(op){
                case "I":
                    ascQueue.offer(val);
                    descQueue.offer(val);
                    break;
                case "D":
                    boolean removeAsc = (val==-1)? true : false;
                    if(removeAsc){
                        descQueue.remove(ascQueue.poll());
                    } else{
                        ascQueue.remove(descQueue.poll());
                    }
                    break;
            }
        }

        if(ascQueue.size()>=1){
            answer[0] = descQueue.poll();
            answer[1] = ascQueue.poll();
        } else{
            answer[0] = 0;
            answer[1] = 0;
        }
        return answer;
    }

    public static void main(String[] args) {
        String[] a = {"I 7","I 5","I -5","D -1"};

        int[] answer = solution(a);
        for(int idx : answer){
            System.out.print(idx+" ");
        }

    }
}
