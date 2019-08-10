package fromProgrammers;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA_Solution_8049 {
	static String[][] boom = {{"FF", "MCM"},{"FC","MF"}}; 
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tcNum = Integer.parseInt(br.readLine().trim());
		for(int tc=1;tc<=tcNum;tc++) {
			String str = br.readLine().trim();
			boolean isAnswer = false;
			isAnswer = findBoom(str, 0) & findBoom(str, 1);
			System.out.println(String.format("#%d %s", tc, isAnswer? "DETECTED!" : "NOTHING!"));
		}
	}
	
	public static boolean findBoom(String str, int type) {
		int idx = 0;
		boolean isFirstCheck = false;
		boolean isSecondCheck = false;
		while(idx<str.length()) {
			if(!isFirstCheck) {
				int findIdx = str.indexOf(boom[type][0],idx);
				if(findIdx>=0) {
					idx = findIdx+2;
					isFirstCheck = true;
				}else {
					idx = str.length();
				}
			} else {
				int findIdx = str.indexOf(boom[type][1],idx);
				if(findIdx>=0) {
					isSecondCheck = true;
					break;
				}else {
					idx = str.length();
				}
			}
		}
		return (isFirstCheck && isSecondCheck);
	}
}
