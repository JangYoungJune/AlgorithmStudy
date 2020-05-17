
public class 카카오_4단고음 {
	public static void main(String[] args) {
		System.out.println(solution(2147483647));
	}

	static int answer = 0;
	static int maxCnt = 0;

	public static int solution(int n) {
		answer = 0;
		maxCnt = (int)(Math.log10(n) / Math.log10(3));
		dfs(n, 0, 0);
		return answer;
	}

	public static void dfs(int number, int starCnt, int plusCnt) {
		if(number<1) {
			return;
		} else if(plusCnt==starCnt*2 && number==1) {
			answer++;
			return;
		} else {
			if((plusCnt/2)>maxCnt) {
				return;
			}
			if(starCnt==2*plusCnt) {
				dfs(number-2, starCnt, plusCnt+2);
			} else {
				if(number%3==2) {
					dfs(number-2, starCnt, plusCnt+2);
				} else if(number%3==1) {
					dfs(number-1, starCnt, plusCnt+1);
				} else {
					if(plusCnt >= (starCnt+1)*2) {
						dfs(number/3, starCnt+1, plusCnt);
					}
					dfs(number-3, starCnt, plusCnt+3);
				}
			}
		}
	}
}
