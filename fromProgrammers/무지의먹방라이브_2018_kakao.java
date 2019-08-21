
public class 무지의먹방라이브_2018_kakao {
	public static void main(String[] args) {
		무지의먹방라이브_2018_kakao test = new 무지의먹방라이브_2018_kakao();
		int[] food_times = { 3, 1, 2 };
		long k = 5;
		System.out.println(test.solution(food_times, k));
	}

	public int solution(int[] food_times, long k) {
		boolean isContinued = true;
		boolean isEmpty = false;
		int size = food_times.length;
		while (isContinued) {
			int minFood = minFoodValue(food_times);
			if (minFood == -1) {
				isEmpty = true;
				break;
			}
			long deleteFoods = (long)size * (long)minFood;
			if (deleteFoods <= k) { // k가 deleteFoods보다 크다 > 돌려!
				k -= deleteFoods;
				size -= countFoodValue(food_times, minFood); // 각 어레이를 지우면서 같은 갯수를 반환
			} else { // 아니다! 지워지는 구간 중간에 먹방이 끝난다!
				k %= size;
				isContinued = false;
			}
		}
		if (isEmpty) {
			return -1;
		} else {
			int idx = 0;
			int i = 0;
			for (i = 0; i < food_times.length; i++) {
				if (food_times[i] != 0) {
					idx++;
					if (idx > k) {
						break;
					}
				}
			}
			return i + 1;
		}
	}

	public int minFoodValue(int[] food_times) {
		int minValue = Integer.MAX_VALUE;
		for (int i = 0; i < food_times.length; i++) {
			if (food_times[i] != 0 && minValue > food_times[i]) {
				minValue = food_times[i];
			}
		}
		return (minValue == Integer.MAX_VALUE) ? -1 : minValue;
	}

	public int countFoodValue(int[] food_times, int value) {
		int count = 0;
		for (int i = 0; i < food_times.length; i++) {
			if (food_times[i] == value) {
				count++;
			}
			if (food_times[i] != 0) {
				food_times[i] -= value;
			}
		}
		return count;
	}

}
