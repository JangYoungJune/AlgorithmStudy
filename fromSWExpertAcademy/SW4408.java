package fromSWExpertAcademy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SW4408 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int tcNum = Integer.parseInt(br.readLine().trim());
		for(int tc=1;tc<=tcNum;tc++) {
			int N = Integer.parseInt(br.readLine().trim());
			int[] room = new int[401];
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine().trim()," ");
				int r1 = Integer.parseInt(st.nextToken());
				int r2 = Integer.parseInt(st.nextToken());
				if(r1>r2) {
					int temp = r1;
					r1 = r2;
					r2 = temp;
				}
				if(r1%2==0) {
					r1--;
				}
				if(r2%2==1) {
					r2++;
				}
				for(int j=r1;j<=r2;j++) {
					room[j]++;
				}
			}
			System.out.println("#"+tc+" "+Arrays.stream(room).max().getAsInt());
		}
	}
}
