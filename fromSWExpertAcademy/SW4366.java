package fromSWExpertAcademy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SW4366 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tcNum = Integer.parseInt(br.readLine().trim());
		for(int tc=1;tc<=tcNum;tc++) {
			StringBuilder str2 = new StringBuilder(br.readLine().trim());
			String str3 = br.readLine().trim();
			long digit3 = Long.valueOf(str3,3);
			long answer = 0;
			for(int i=0;i<str2.length();i++) {
				str2.replace(i, i+1, (str2.charAt(i)=='0')? "1" :"0");
				long digit2 = Long.valueOf(str2.toString(), 2);
				long sub = Math.abs(digit2 - digit3);
				if(isSquare(sub)) {
					answer = digit2;
					break;
				}
				str2.replace(i, i+1, (str2.charAt(i)=='1')? "0" :"1");
			}
			System.out.println("#"+tc+" "+answer);
		}
	}
	public static boolean isSquare(long n) {
		if(n%2==0) {
			n = n/2;
		}
		while(n%3==0) {
			n = n/3;
		}
		if(n==1) {
			return true;
		} else {
			return false;
		}
	}
}
