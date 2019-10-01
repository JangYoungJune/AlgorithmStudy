
public class 괄호변환_2020_kakao {
	public static void main(String[] args) {
		괄호변환_2020_kakao solve = new 괄호변환_2020_kakao();
		System.out.println(solve.solution("()))((()"));
	}

	public String solution(String p) {
		if(p.length()==0) {
			return "";
		} else {
			int stack = 0;
			StringBuilder sb = new StringBuilder();
			boolean isCorrect = true;
			for(int i=0;i<p.length();i++) {
				if(p.charAt(i)=='(') {
					stack++;
				} else {
					stack--;
				}
				if(stack<0) {
					isCorrect = false;
				}
				if(stack==0) {
					String u = p.substring(0, i+1);
					String v = solution(p.substring(i+1));
					if(!isCorrect) {
						sb.append('(').append(v).append(')');
						for(int j=1;j<i;j++) {
							if(u.charAt(j)=='(') {
								sb.append(')');
							} else {
								sb.append('(');
							}
						}
					} else {
						sb.append(u).append(v);
					}
					break;
				}
			}
			return sb.toString();
		}
    }
}
