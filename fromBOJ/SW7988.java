package fromBOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class SW7988 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tcNum = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= tcNum; tc++) {
			int N = Integer.parseInt(br.readLine().trim());
			ArrayList<String> nameArr = new ArrayList<>();
			boolean[][] connMap = new boolean[201][201];
			for (int i = 0; i < N; i++) {
				String[] inputArr = br.readLine().trim().split(" ");
				int idx1 = nameArr.indexOf(inputArr[0]);
				int idx2 = nameArr.indexOf(inputArr[1]);
				if (idx1 < 0) {
					nameArr.add(inputArr[0]);
					idx1 = nameArr.size() - 1;
				}
				if (idx2 < 0) {
					nameArr.add(inputArr[1]);
					idx2 = nameArr.size() - 1;
				}
				connMap[idx1][idx2] = true;
				connMap[idx2][idx1] = true;
			}

			int size = nameArr.size();
			int[] teamArr = new int[size];
			Queue<Integer> connQ = new LinkedList<>();
			boolean answer = true;

			connQ.offer(0);
			teamArr[0] = 1;

			wLoop: while (!connQ.isEmpty()) {
				int nowValue = connQ.poll();
				int nowTeam = teamArr[nowValue];
				for (int i = 0; i < size; i++) {
					if (connMap[nowValue][i]) {
						if(teamArr[i] == nowTeam) {
							answer = false;
							break wLoop;
						} else {
							connQ.offer(i);
							connMap[nowValue][i] = false;
							connMap[i][nowValue] = false;
							if(teamArr[i] == 0) {
								teamArr[i] = nowTeam * -1;
							}
						}
					}
				}
			}
			System.out.println("#"+tc+" "+(answer? "Yes" : "No"));
		}
	}
}
