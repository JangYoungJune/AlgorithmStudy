package fromSWExpertAcademy;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW5607 {
	static final int DIVNUM = 1234567891;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int tcNum = Integer.parseInt(br.readLine().trim());
		for(int tc=1;tc<=tcNum;tc++) {
			st = new StringTokenizer(br.readLine().trim()," ");
			int N = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			long headerValue = multiple(N, N-R);
			long fermatValue = fermat(multiple(R,0), DIVNUM-2);
			long answer = (headerValue * fermatValue)%DIVNUM;
			System.out.println("#"+tc+" "+answer);
		}
	}
	
	public static long fermat(long num, long sqr) {
		if(sqr<=1) {
			return (sqr==1)? num : 1;
		} else {
			long halfNum = fermat(num, sqr/2);
			long answer = (halfNum*halfNum)%DIVNUM;
			if(sqr%2==1) {
				answer = (answer*num)%DIVNUM;
			}
			return answer;
		}
	}
	
	public static long multiple(int start, int end) {
		long value = 1;
		for(long i=start; i>end;i--) {
			value = (value * i) % DIVNUM;
		}
		return value;
	}
}
