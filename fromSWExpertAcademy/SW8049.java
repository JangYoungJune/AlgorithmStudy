package fromSWExpertAcademy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SW8049 {
	static String str;
	static boolean isAnswer = true;
	static String tempStr;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tcNum = Integer.parseInt(br.readLine().trim());
		for(int tc=1;tc<=tcNum;tc++) {
			str = br.readLine().trim();
			isAnswer = true;
			int idx = 0;
			int order = 0;
			while(idx<str.length()) {
				if(order==0) {
					tempStr = str.substring(idx, idx+2);
					if(tempStr.equals("FF")) {
						order = 1;
						idx = idx+2;
						while(idx<str.length() && str.charAt(idx)=='F') {
							idx++;
						}
					} else if(tempStr.equals("FC")) {
						order = 2;
						idx = idx+2;
						while(idx<str.length() && str.charAt(idx)=='C') {
							idx++;
						}
					} else {
						isAnswer = false;
						break;
					}
				} else {
					tempStr = str.substring(idx, order==1? idx+3 : idx+2);
					if(tempStr.equals("MCM") && order==1) {
						order = 0;
						idx = idx+3;
						while(idx<str.length() && str.charAt(idx)=='M') {
							idx++;
						}
					} else if(tempStr.equals("MF") && order==2) {
						order = 0;
						idx = idx+2;
					} else {
						isAnswer = false;
						break;
					}
				}
			}
			if(order!=0) {
				isAnswer = false;
			}
			System.out.println(String.format("#%d %s", tc, isAnswer? "DETECTED!" : "NOTHING!"));
		}
	}
}
