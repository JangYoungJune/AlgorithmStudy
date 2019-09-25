package fromSWExpertAcademy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SW4672 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tcNum = Integer.parseInt(br.readLine().trim());
		for(int tc=1;tc<=tcNum;tc++) {
			String str = br.readLine().trim();
			int[] arr = new int[26];
			for(int i=0;i<str.length();i++) {
				arr[str.charAt(i)-'a']++;
			}
			int answer = 0;
			for(int i=0;i<arr.length;i++) {
				if(arr[i]==0) {
					continue;
				}
				for(int val=arr[i];val>=1;val--) {
					answer+=val;
				}
			}
			System.out.println("#"+tc+" "+answer);
		}
	}
}
