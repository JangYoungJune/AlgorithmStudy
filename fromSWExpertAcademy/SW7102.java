package fromSWExpertAcademy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SW7102 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tcNum = Integer.parseInt(br.readLine().trim());
		for(int tc=1;tc<=tcNum;tc++) {
			String[] set = br.readLine().trim().split(" ");
			int n1 = Integer.parseInt(set[0]);
			int n2 = Integer.parseInt(set[1]);
			int[] countSet = new int[41];
			for(int i=1;i<=n1;i++) {
				for(int j=1;j<=n2;j++) {
					countSet[i+j]++;
				}
			}
			int max = -1;
			for(int i=0;i<countSet.length;i++) {
				if(max<countSet[i]) {
					max = countSet[i];
				}
			}
			StringBuilder sb = new StringBuilder();
			for(int i=0;i<countSet.length;i++) {
				if(max==countSet[i]) {
					sb.append(" ");
					sb.append(i);
				}
			}
			System.out.println("#"+tc+sb.toString());
		}
	}
}
