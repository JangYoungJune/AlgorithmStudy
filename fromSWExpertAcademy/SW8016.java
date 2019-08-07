package fromSWExpertAcademy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SW8016 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tcNum = Integer.parseInt(br.readLine().trim());
		for(int tc=1;tc<=tcNum;tc++) {
			int height = Integer.parseInt(br.readLine().trim());
			long aLeft = 2l*((long)(height-1)*(long)(height-1)+1)-1;
			long aRight = 2l*(long)height*(long)height-1;
			System.out.printf("#%d %d %d\n", tc, aLeft, aRight);
		}
	}
}
