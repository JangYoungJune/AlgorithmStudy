package fromProgrammers;

/* project URL: https://programmers.co.kr/learn/courses/30/lessons/42585
*/
public class StackQueue1 {
	public static int solution(String arrangement) {
		int answer = 0;
		int depth = 0;
		int length = arrangement.length();
		for(int i=0;i<length;i++) {
			char mark = arrangement.charAt(i);
			if(mark == '(') {
				depth++;
			} else {
				if(arrangement.charAt(i-1)=='(') {
					depth--;
					answer += depth;
				} else {
					answer++;
					depth--;
				}
				
			}
		}
		return answer;
	}
	
	public static void main(String args[]) {
		String a = "()(((()())(())()))(())";
		
		int answer = solution(a);
		System.out.println(answer);
	}
}
