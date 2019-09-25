package fromSWExpertAcademy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SW3378 {
	static String[] otherStr;
	static String[] myStr;
	static int[] results;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tcNum = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= tcNum; tc++) {
			String[] input = br.readLine().trim().split(" ");
			int n1 = Integer.parseInt(input[0]);
			int n2 = Integer.parseInt(input[1]);
			otherStr = new String[n1];
			myStr = new String[n2];
			results = new int[n2];

			for (int i = 0; i < n2; i++) {
				results[i] = -2;
			}

			for (int i = 0; i < n1; i++) {
				otherStr[i] = br.readLine().trim();
			}
			for (int i = 0; i < n2; i++) {
				myStr[i] = br.readLine().trim();
			}

			for (int R = 1; R <= 20; R++) {
				for (int C = 1; C <= 20; C++) {
					for (int S = 1; S <= 20; S++) {
						if (canMatch(R, C, S)) {
							saveAnswer(R, C, S);
						}
					}
				}
			}
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc);
			for (int result : results) {
				sb.append(" ").append(result);
			}
			System.out.println(sb.toString());
		}
	}

	public static boolean canMatch(int R, int C, int S) {
		int r = 0, c = 0, s = 0;
		for (int n = 0; n < otherStr.length; n++) {
			String str = otherStr[n];
			boolean isDot = true;
			int dotCnt = 0;
			for (int i = 0; i < str.length(); i++) {
				char ch = str.charAt(i);
				if (ch == '.' && isDot) {
					dotCnt++;
				} else {
					if(isDot) {
						isDot = false;
						if ((r * R + c * C + s * S) != dotCnt) {
							return false;
						}
					}
					switch (ch) {
					case '(':
						r++;
						break;
					case ')':
						r--;
						break;
					case '{':
						c++;
						break;
					case '}':
						c--;
						break;
					case '[':
						s++;
						break;
					case ']':
						s--;
						break;
					}
				}
			}
		}
		return true;
	}

	public static void saveAnswer(int R, int C, int S) {
		int r = 0, c = 0, s = 0;
		for (int n = 0; n < myStr.length; n++) {
			String str = myStr[n];
			int result = r * R + c * C + s * S;
			if(results[n]==-2) {
				results[n] = result;
			} else if(results[n]>=0){
				if(results[n]!=result) {
					results[n]=-1;
				}
			} else {
				results[n] = -1;
			}
			for (int i = 0; i < str.length(); i++) {
				char ch = str.charAt(i);
				switch (ch) {
				case '(':
					r++;
					break;
				case ')':
					r--;
					break;
				case '{':
					c++;
					break;
				case '}':
					c--;
					break;
				case '[':
					s++;
					break;
				case ']':
					s--;
					break;
				}
			}
		}
	}
}
