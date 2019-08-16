package fromSWExpertAcademy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SW7510 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tcNum = Integer.parseInt(br.readLine().trim());
		for(int tc=1;tc<=tcNum;tc++) {
			int N = Integer.parseInt(br.readLine().trim());
			
			int min = 1;
			int maxValue = (N+1/2);
			int answer = 0;
			int sum = 0;
			
			for(int i=1;i<=maxValue;i++) {
				sum+=i;
				while(sum>=N) {
					if(sum==N) {
						answer++;
					}
					sum-=(min++);
				}
			}
			System.out.println("#"+tc+" "+answer);
		}
	}
}
