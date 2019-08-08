package fromSWExpertAcademy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW8189 {
	static int[] letterTime;
	static int[] answer;
	static int N;
	static int maxCnt;
	static int maxTime;
	static int tcNum;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		tcNum = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= tcNum; tc++) {
			String[] str = br.readLine().trim().split(" ");
			N = Integer.parseInt(str[0]);
			maxCnt = Integer.parseInt(str[1]);
			maxTime = Integer.parseInt(str[2]);
			st = new StringTokenizer(br.readLine().trim());
			letterTime = new int[N];
			answer = new int[N];
			for(int i=0;i<N;i++) {
				letterTime[i] = Integer.parseInt(st.nextToken());
 			}
			int index = 0;
			int cnt = 0;
			int preIndex = 0;
			
			while(preIndex<N) {
				if(index>=N) { // 잔류된 데이터들
					int readed = cnt/2 + cnt%2;
					cnt -= readed;
					for(int i=preIndex; i<preIndex+readed;i++) {
						answer[i] = letterTime[preIndex]+maxTime;
					}
					preIndex = preIndex + readed;
				} else { // 아직 전체 letterTime을 안봄
					int nowTime = letterTime[index];
					int overTime = letterTime[preIndex] + maxTime;
					if(overTime < nowTime) { // 이전 편지가 만료됨
						int readed = cnt/2 + cnt%2;
						cnt -= readed;
						for(int i=preIndex; i<preIndex+readed;i++) {
							answer[i] = overTime;
						}
						preIndex = preIndex + readed;
					} else { // 이전 편지가 만료되기전에 새편지가 들어옴
						cnt++;
						index++;
						if(maxCnt<=cnt){
							int readed = cnt/2 + cnt%2;
							cnt -= readed;
							for(int i=preIndex; i<preIndex+readed;i++) {
								answer[i] = nowTime;
							}
							preIndex = preIndex + readed;
						}
					}
				}
			}
			
			System.out.print("#"+tc+" ");
			for(int ans : answer) {
				System.out.print(ans+ " ");
			}
			System.out.println();
		}
	}
}