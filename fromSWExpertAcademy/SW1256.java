package fromSWExpertAcademy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SW1256 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tcNum = Integer.parseInt(br.readLine().trim());
		for(int tc=1;tc<=tcNum;tc++) {
			int K = Integer.parseInt(br.readLine().trim());
			String str = br.readLine().trim();
			String answerStr;
			int[] alpha = new int[26];
			char findC = '=';
			for(int i=0;i<str.length();i++) {
				alpha[str.charAt(i)-'a']++;
			}
			for(int i=0;i<alpha.length;i++) {
				if(K-alpha[i]<=0) {
					findC = (char)('a'+i);
					break;
				} else {
					K -= alpha[i];
				}
			}
			if(findC=='=') {
				answerStr = "none";
			} else {
				List<String> subSet = new ArrayList<>();
				for(int i=0;i<str.length();i++) {
					if(findC==str.charAt(i)) {
						subSet.add(str.substring(i));
					}
				}
				Collections.sort(subSet);
				answerStr = subSet.get(K-1);
			}
			System.out.println("#"+tc+" "+answerStr);
		}
	}
}
