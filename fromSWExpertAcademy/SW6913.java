package fromSWExpertAcademy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW6913 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int tcNum = Integer.parseInt(br.readLine().trim());
		for(int tc=1;tc<=tcNum;tc++) {
			st = new StringTokenizer(br.readLine().trim()," ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int max = -1;
			int maxCnt = 0;
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine().trim()," ");
				int correctCnt = 0;
				for(int j=0;j<M;j++) {
					int correct = Integer.parseInt(st.nextToken());
					if(correct==1) {
						correctCnt++;
					}
				}
				if(correctCnt>max) {
					max = correctCnt;
					maxCnt = 1;
				} else if(correctCnt==max) {
					maxCnt++;
				}
			}
			System.out.println("#"+tc+" "+maxCnt+" "+max);
		}
	}
}
