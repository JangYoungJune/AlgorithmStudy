package fromSWExpertAcademy;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SW6782 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tcNum = Integer.parseInt(br.readLine().trim());
		for(int tc=1;tc<=tcNum;tc++) {
			long N = Long.parseLong(br.readLine().trim());
			long answer = 0;
			while(N!=2) {
				long sqrtVal = (long)Math.sqrt(N);
				if(sqrtVal*sqrtVal != N) {
					sqrtVal++;
					answer += (sqrtVal)*(sqrtVal) - N;
				}
				N = sqrtVal;
				answer++;
			}
			System.out.println("#"+tc+" "+answer);
		}
	}
}
