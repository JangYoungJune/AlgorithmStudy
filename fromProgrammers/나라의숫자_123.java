import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 나라의숫자_123 {

	public static void main(String[] args) {
		System.out.println(solution(82));
	}

	public static String solution(int n) {
		StringBuilder answer = new StringBuilder();
		List<Integer> threeMultiSet = new ArrayList<>();
		int threeMulti = 3;
		while(threeMulti<500000000) {
			threeMultiSet.add(threeMulti);
			threeMulti*=3;
		}
		threeMultiSet.sort(Collections.reverseOrder());
		boolean isWrite = false;
		for(int nowMultiVal : threeMultiSet) {
			if(nowMultiVal>n && !isWrite) {
				continue;
			}
			isWrite = true;
			int multiCnt = n/nowMultiVal;
			n = n - multiCnt*nowMultiVal;
			answer.append(multiCnt);
		}
		answer.append(n);
		
		int zeroCnt = 0;
		for(int i=answer.length()-1;i>=0;i--) {
			if(answer.charAt(i)=='0') {
				zeroCnt++;
				continue;
			} else if(answer.charAt(i)!='0' && zeroCnt>0) {
				for(int j=i+1; j<i+1+zeroCnt;j++) {
					answer.replace(j-1, j, Character.toString((char)(answer.charAt(j-1)-1)));
					answer.replace(j, j+1, "3");
				}
				zeroCnt = 0;
				i++;
			}
		}
		
		return answer.toString().replaceAll("0", "").replaceAll("3", "4");
	}

}
