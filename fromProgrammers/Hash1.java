package fromProgrammers;

import java.util.HashMap;

public class Hash1 {
	public static String solution(String[] participant, String[] completion) {
		String answer = "";
		HashMap<String, Integer> part_map = new HashMap<>();
		for(String person : participant) {
			if(part_map.containsKey(person)) {
				part_map.put(person, part_map.get(person)+1);
			}else {
				part_map.put(person, 1);
			}
		}
		for(String person: completion) {
			if(part_map.get(person)!=1) {
				part_map.put(person, part_map.get(person)-1);
			} else {
				part_map.remove(person);
			}
		}
		return (String)part_map.keySet().toArray()[0];
	}
	
	public static void main(String args[]) {
		String[] a = {"leo", "kiki", "eden"};
		String[] b = { "kiki", "eden"};
		
		String answer = solution(a, b);
		System.out.println(answer);
	}

}
