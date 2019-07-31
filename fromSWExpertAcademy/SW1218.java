package fromSWExpertAcademy;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class SW1218 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 1; tc <= 10; tc++) {
			Stack<Character> s = new Stack<>();
			boolean isPossible = true;
			int N = Integer.parseInt(br.readLine().trim());
			char[] arr = br.readLine().trim().toCharArray();
			outer: for (int i = 0; i < arr.length; i++) {
				char nowChar = arr[i];
				if (nowChar == ')' || nowChar == '}' || nowChar == ']' || nowChar == '>') {
					if (s.isEmpty() || Math.abs(nowChar - s.pop()) > 2) {
						isPossible = false;
						break outer;
					}
				} else {
					s.push(nowChar);
				}
			}
			if (!s.isEmpty()) {
				isPossible = false;
			}
			System.out.printf("#%d %d\n", tc, (isPossible) ? 1 : 0);
		}
	}
}
