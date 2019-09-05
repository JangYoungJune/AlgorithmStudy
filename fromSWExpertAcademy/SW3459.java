package fromSWExpertAcademy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SW3459 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tcNum = Integer.parseInt(br.readLine().trim());
		for(int tc=1;tc<=tcNum;tc++) {
			long N = Long.parseLong(br.readLine().trim());
			long cnt = 0;
			long copyN = N;
			while(copyN!=1) {
				copyN = copyN/2;
				cnt++;
			}
			boolean isBob = false;
			if(cnt%2==0){
				isBob = true;
			}
			cnt=0;
			while(copyN<=N) {
				if(isBob) {
					copyN = (cnt%2==0)? copyN*2+1 : copyN*2;
				} else {
					copyN = (cnt%2==0)? copyN*2 : copyN*2+1;
				}
				cnt++;
			}
			System.out.println("#"+tc+" "+((cnt%2==1)? "Bob" : "Alice"));
		}
	}
}
