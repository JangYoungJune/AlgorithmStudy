package fromSWExpertAcademy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SW1213 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i=1;i<=10;i++) {
			int answer = 0;
			String tc = br.readLine().trim();
			String find = br.readLine().trim();
			StringBuilder str = new StringBuilder(br.readLine().trim());
			int findIdx;
			while((findIdx = str.indexOf(find))>=0) {
				str.delete(0, findIdx+find.length());
				answer++;
			}
			System.out.println("#"+tc+" "+answer);
		}
	}
}
