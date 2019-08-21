
public class 무지의먹방라이브_2018_kakao2 {
	public static void main(String[] args) {
		무지의먹방라이브_2018_kakao2 test = new 무지의먹방라이브_2018_kakao2();
		int[] food_times = { 3, 1, 2 };
		long k = 5;
		System.out.println(test.solution(food_times, k));
	}

	public int solution(int[] food_times, long k) {
		boolean isEmpty = false;
		int size = food_times.length;
		while (k >= size) {
			long divide = k / size;
			k %= size;
			int underZeroCount = 0;
			for (int i = 0; i < food_times.length; i++) {
				if (food_times[i] > 0) {
					food_times[i] -= divide;
				}
				if (food_times[i] <= 0) {
					k += (food_times[i] * -1);
					food_times[i] = 0;
					underZeroCount++;
				}
			}
			size = food_times.length - underZeroCount;
			if(size==0) {
				isEmpty = true;
				break;
			}
		}
		if(isEmpty) {
			return -1;
		}
		int idx = 0;
		int i = 0;
		for(i=0;i<food_times.length;i++) {
			if(food_times[i]!=0) {
				idx++;
			}
			if(idx>k) {
				break;
			}
		}
		return i+1;
	}
}
