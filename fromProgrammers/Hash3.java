package fromProgrammers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
  * problem URL: https://programmers.co.kr/learn/courses/30/lessons/42578
  * */
public class Hash3 {
	public static int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> clothesMap = new HashMap<>();
        for(int i=0;i<clothes.length;i++){
            if(clothesMap.get(clothes[i][1])==null){
                clothesMap.put(clothes[i][1], 1);
            } else{
                clothesMap.put(clothes[i][1], clothesMap.get(clothes[i][1])+1);
            }
        }
        for(Map.Entry<String, Integer> entry : clothesMap.entrySet()){
            int value = entry.getValue();
            answer = answer * (value+1);
        }
        answer = answer-1;
		return answer;
	}
	
	public static void main(String args[]) {
		String[][] a = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
		
		int answer = solution(a);
		System.out.println(answer);
	}
}
