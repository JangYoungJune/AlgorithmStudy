package fromSWExpertAcademy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SW7103 {
	static int[] powSet = new int[32768];
	static int count;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// make powSet
		int idx = 1;
		while(idx*idx<powSet.length) {
			for(int i=idx*idx;i<(idx+1)*(idx+1);i++) {
				if(i==powSet.length) {
					break;
				}
				powSet[i] = idx;
			}
			idx++;
		}
		// input keyboard and process algorithm
		int tcNum = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= tcNum; tc++) {
			int N = Integer.parseInt(br.readLine().trim());
			count = 0;
			findSqrt(N,0, Integer.MAX_VALUE);
			System.out.println("#"+tc+" "+count);
		}
	}
	public static void findSqrt(int remain, int cnt, int preIdx) {
		if(cnt==4 || remain==0) {
			if(remain==0) {
				count++;
			}
			return;
		} else {
			int maxIdx = (preIdx<powSet[remain])? preIdx : powSet[remain];
			int divVal = remain/(4-cnt);
			int minIdx = powSet[divVal] - ((divVal!=0 && powSet[divVal]!=powSet[divVal-1])? 1:0);
			for(int i=maxIdx;i>minIdx;i--) {
				findSqrt(remain-i*i, cnt+1, i);
			}
		}
	}
}
