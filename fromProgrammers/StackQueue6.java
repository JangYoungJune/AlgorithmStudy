package fromProgrammers;

public class StackQueue6 {
	public static int[] solution(int[] prices) {
		int[] answer = new int[prices.length];
		int priceLength = prices.length;
		for(int i=0; i<priceLength; i++) {
			int timer = 0;
			for(int j=i+1; j<priceLength; j++) {
				timer++;
				if(prices[i] > prices[j]) {
					break;
				}
			}
			answer[i] = timer;
		}
		return answer;
    }
	
	public static void main(String args[]) {
		int[] a = {498,501,470,489};
		int[] answer = solution(a);
        for(int value : answer){
            System.out.print(value+" ");
        }
	}
}
