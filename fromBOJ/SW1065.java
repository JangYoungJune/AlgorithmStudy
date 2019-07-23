package fromBOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SW1065 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int answer = 0;
		for(int i=1;i<=n;i++) {
			if(i/100<=0) {
				answer++;
			} else {
				int d3,d2,d1;
				d3 = i/100;
				d2 = (i%100)/10;
				d1 = (i%100)%10;
				answer += (d3-d2 == d2-d1)? 1:0;  
			}
		}
		System.out.println(answer);
	}
}
