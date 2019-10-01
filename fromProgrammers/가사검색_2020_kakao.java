import java.util.Arrays;

public class 가사검색_2020_kakao {
	public static void main(String[] args) {
		가사검색_2020_kakao solve = new 가사검색_2020_kakao();
		String[] input1 = {"frodo", "front", "frost", "frozen", "frame", "kakao"};
		String[] input2 = {"fro??", "????o", "fr???", "fro???", "pro?"};
		System.out.println(solve.solution(input1, input2));
	}

	public int[] solution(String[] words, String[] queries) {
        int[] answer = new int[queries.length];
        Arrays.sort(words, (o1,o2)->{
        	if(o1.charAt(0) != o2.charAt(0)) {
        		return o1.charAt(0) - o2.charAt(0);
        	} else {
        	}
        }) ;
        return answer;
    }
}
