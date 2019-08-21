
public class 무지의먹방라이브_2018_kakao2 {
	public static void main(String[] args) {
		무지의먹방라이브_2018_kakao2 test = new 무지의먹방라이브_2018_kakao2();
		int[] food_times = { 3, 1, 2 };
		long k = 5;
		System.out.println(test.solution(food_times, k));
	}

	public int solution(int[] food_times, long k) {
		int size = food_times.length;
		long divide = k/size;
		k %= size;
		for(int i=0;i<food_times.length;i++) {
			if(food_times[i]==0) {
				continue;
			}
			food_times[i] -= divide;
			if(food_times[i]<=0) {
				
			}
		}
		
		return 0;
	}
}
