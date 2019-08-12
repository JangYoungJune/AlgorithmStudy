package fromSWExpertAcademy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SW7087 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tcNum = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= tcNum; tc++) {
			int N = Integer.parseInt(br.readLine().trim());
			int answer = 0;
			boolean[] arr = new boolean[26];
			for (int i = 0; i < N; i++) {
				String temp = br.readLine();
				arr[temp.charAt(0) - 'A'] = true;
			}
			for (int i=0;i<arr.length;i++) {
				if (!arr[i]) {
					break;
				}
				answer++;
			}
			System.out.println("#" + tc + " " + answer);
		}
		br.close();
	}
}
