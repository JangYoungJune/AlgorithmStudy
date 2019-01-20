package fromProgrammers;

import java.util.HashMap;

/*
  * problem URL: https://programmers.co.kr/learn/courses/30/lessons/42578
  * */
public class Hash4 {
    public static int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        HashMap<String, HashMap<Integer, Integer>> musicMap = new HashMap<>();
        for(int i=0;i<genres.length;i++) {
        	if(musicMap.containsKey(genres[i])) {
        		if(musicMap.get(genres[i]).size()==2) {
        			// �� �ΰ��� ���� �޾Ƽ� ũ�⸦ Ȯ���� ��, �������� ������, �̰��� �߰��Ѵ�.
        		}
        		musicMap.get(genres[i]).put(i, plays[i]);
        	} else {
        		musicMap.put(genres[i], new HashMap<Integer, Integer>());
        		musicMap.get(genres[i]).put(i, plays[i]);
        	}
        }

        return answer;
    }

    public static void main(String args[]) {
        String[] a = { "classic", "pop", "classic", "classic", "pop" };
        int[] b = { 500, 600, 150, 800, 2500 };
        
        int[] answer = solution(a, b);
        System.out.println(answer);
    }
}
