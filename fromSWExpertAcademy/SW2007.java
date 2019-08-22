package fromSWExpertAcademy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SW2007 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tcNum = Integer.parseInt(br.readLine().trim());
		for(int tc = 1;tc<=tcNum;tc++) {
			int maxVal = 0;
			int answerLength = 0;
			String str = br.readLine().trim();
			for(int i=10;i>=1;i--) {
				int j = 0;
				String std = str.substring(0, i);
				int cnt = 0;
				boolean isSame = true;
				for(j=i;j<str.length()-i+1;j+=i) {
					if(!std.equals(str.substring(j, j+i))) {
						isSame = false;
						break;
					}
					cnt++;
				}
				if(isSame && !str.substring(j, str.length()).equals(std.substring(0, str.length()-j))) {
					isSame = false;
				}
				if(isSame && maxVal<cnt) {
					maxVal = cnt;
					answerLength = std.length();
				}
			}
			System.out.println("#"+tc+" "+answerLength);
		}
		
	}
}
