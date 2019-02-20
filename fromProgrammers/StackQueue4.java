package fromProgrammers;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

/* project URL: https://programmers.co.kr/learn/courses/30/lessons/42586
*/

public class StackQueue4 {
	public static int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> progressList = new LinkedList<Integer>(Arrays.stream(progresses).boxed().collect(Collectors.toList()));
        List<Integer> speedList = new ArrayList<>(Arrays.stream(speeds).boxed().collect(Collectors.toList()));
        List<Integer> answer = new ArrayList<>();

        while(!progressList.isEmpty()){
            int popCount = 0;
            while(!progressList.isEmpty() && progressList.peek()>=100){
                progressList.poll();
                speedList.remove(0);
                popCount++;
            }
            if(popCount!=0){
                answer.add(popCount);
            }
            for(int i=0;i<progressList.size();i++){
                progressList.add(progressList.poll()+speedList.get(i));
            }
        }
        return answer.stream().mapToInt(i->i).toArray();
    }
	
	public static void main(String args[]) {
		int[] a = {93,30,55};
		int[] b = {1,30,5};
		
		
		int[] answer = solution(a, b);
        for(int value : answer){
            System.out.print(value+" ");
        }
	}
}
