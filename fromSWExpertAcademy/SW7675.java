package fromSWExpertAcademy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW7675 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int tcNum = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= tcNum; tc++) {
			int N = Integer.parseInt(br.readLine().trim());
			StringBuilder sb = new StringBuilder("#" + tc);
			int nameCnt = 0;
			st = new StringTokenizer(br.readLine().trim(), " ");
			while (st.hasMoreTokens()) {
				String word = st.nextToken();
				char firstChar = word.charAt(0);
				char lastChar = word.charAt(word.length() - 1);
				if (lastChar == '.' || lastChar == '!' || lastChar == '?') {
					if (!(firstChar >= 'A' && firstChar <= 'Z')) {
						sb.append(" ").append(nameCnt);
						nameCnt = 0;
						continue;
					}
					boolean isName = true;
					for (int i = 1; i < word.length() - 1; i++) {
						if (!(word.charAt(i) >= 'a' && word.charAt(i) <= 'z')) {
							isName = false;
							break;
						}
					}
					if (isName) {
						nameCnt++;
					}
					sb.append(" ").append(nameCnt);
					nameCnt = 0;
				} else {
					if (!(firstChar >= 'A' && firstChar <= 'Z')) {
						continue;
					}
					boolean isName = true;
					for (int i = 1; i < word.length(); i++) {
						if (!(word.charAt(i) >= 'a' && word.charAt(i) <= 'z')) {
							isName = false;
							break;
						}
					}
					if (isName) {
						nameCnt++;
					}
				}
			}
			System.out.println(sb.toString());
		}
	}
}
