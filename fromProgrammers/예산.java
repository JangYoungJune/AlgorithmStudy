import java.util.Arrays;

public class 예산 {
	public static void main(String[] args) {
		int[] budgets = {120, 110, 140, 150};
		int M = 485;
		System.out.println(solution(budgets, M));
	}
	
	public static int solution(int[] budgets, int M) {
		int answer = 0;
		Arrays.sort(budgets);
		int start = 1;
		int end = budgets[budgets.length-1];
		int mid = 0;
		
		while(start<=end) {
			mid = (start+end)/2;
			long sum = 0;
			for(int i=0;i<budgets.length;i++) {
				if(mid>budgets[i]) {
					sum += budgets[i];
				} else {
					sum += (budgets.length-i) * (long)mid;
					break;
				}
			}
			if(sum>M) {
				end = mid-1;
			} else {
				answer = mid;
				start = mid+1;
			}
		}
		return answer;
	}
} 