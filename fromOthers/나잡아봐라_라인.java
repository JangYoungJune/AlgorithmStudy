package fromOthers;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 출처: https://engineering.linecorp.com/ko/blog/2019-firsthalf-line-internship-recruit-coding-test/
public class 나잡아봐라_라인 {
	static boolean[] mapHistory = new boolean[200001];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		int conyPos = Integer.parseInt(st.nextToken());
		int brownPos = Integer.parseInt(st.nextToken());
		if (conyPos == brownPos) {
			System.out.println(0);
		}

		int time = 0;
		boolean isMeet = false;
		int inc = 1;
		Queue<Integer> brownMap = new LinkedList<>();
		brownMap.offer(brownPos);
		mapHistory[brownPos] = true;
		outerLoop:while (conyPos <= 200000) {
			time++;
			conyPos += inc;
			inc++;
			int brownN = brownMap.size();
			for (int i = 0; i < brownN; i++) {
				int val = brownMap.poll();
				int[] tempArr = {val-1, val+1, val*2};
				for(int j=0;j<tempArr.length;j++) {
					if(tempArr[j]==conyPos) {
						isMeet = true;
						break outerLoop;
					}
					if(checkPosition(tempArr[j])) {
						mapHistory[j] = true;
						brownMap.offer(tempArr[j]);
					}
				}
			}
		}
		System.out.println(isMeet? time : -1);
	}
	
	public static boolean checkPosition(int idx) {
		return !mapHistory[idx] && idx>=0 && idx<=200000; 
	}
}
