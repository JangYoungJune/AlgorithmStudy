import java.util.Arrays;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class 오픈채팅방_2018_kakao {
	public static void main(String[] args) {
		String[] input = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
		String[] answer =  solution(input);
		System.out.println(Arrays.toString(answer));
	}
	public static String[] solution(String[] record) {
		Queue<Boolean> enterList = new LinkedList<>();
		Queue<String> idList = new LinkedList<>();
		Map<String, String> idMap = new HashMap<>();
		for(String input : record) {
			String[] splitArr = input.split(" ");
			switch(splitArr[0]) {
			case "Enter":
				idMap.put(splitArr[1], splitArr[2]);
				enterList.offer(true);
				idList.offer(splitArr[1]);
				break;
			case "Leave":
				enterList.offer(false);
				idList.offer(splitArr[1]);
				break;
			case "Change":
				idMap.put(splitArr[1], splitArr[2]);
				break;
			}
		}
		String[] answer = new String[enterList.size()];
		for(int i=0;i<answer.length;i++) {
			answer[i] = idMap.get(idList.poll()) + ((enterList.poll())? "님이 들어왔습니다." : "님이 나갔습니다.");
		}
		return answer;
	}
}
