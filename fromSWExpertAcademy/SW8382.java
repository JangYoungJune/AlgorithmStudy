package fromSWExpertAcademy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SW8382 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tcNum = Integer.parseInt(br.readLine().trim());
		for(int tc=1;tc<=tcNum;tc++) {
			String[] str = br.readLine().trim().split(" ");
			int xSize= Math.abs(Integer.parseInt(str[0]) - Integer.parseInt(str[2]));
			int ySize= Math.abs(Integer.parseInt(str[1]) - Integer.parseInt(str[3]));
			int diff = Math.abs(xSize - ySize);
			int answer = 0;
			if(diff>=2) {
				diff = (diff%2==1)? diff-1 : diff;
				if(xSize>ySize) {
					ySize += diff;
				} else {
					xSize += diff;
				}
			}
			answer = xSize+ySize;
			System.out.println("#"+tc+" "+answer);
		}
	}
}
