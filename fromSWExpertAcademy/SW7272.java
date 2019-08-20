package fromSWExpertAcademy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SW7272 {
	static int[] alpha = new int[26];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tcNum = Integer.parseInt(br.readLine().trim());
		alpha[1] = 2; // "B"
		String oneRound = "ADOPQR";
		for(int i=0;i<oneRound.length();i++) {
			alpha[oneRound.charAt(i)-'A']=1;
		}
		for(int tc=1;tc<=tcNum;tc++) {
			boolean isSame = true;
			String[] str = br.readLine().trim().split(" ");
			if(str[0].length()==str[1].length()) {
				for(int i=0;i<str[0].length();i++) {
					if(alpha[str[0].charAt(i)-'A'] != alpha[str[1].charAt(i)-'A']) {
						isSame = false;
						break;
					}
				}
			} else {
				isSame = false;
			}
			System.out.println("#"+tc+" "+ (isSame? "SAME" : "DIFF"));
		}
	}
}
