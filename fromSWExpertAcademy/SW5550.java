package fromSWExpertAcademy;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// c를 만나면? 1값인 개구리를 생성
// r을 만나면? 1인 값 +1해줌 // 없으면 에러
// o을 만나면? 2인 값 +1해줌 // 없으면 에러
// a을 만나면? 3인 값 +1해줌 // 없으면 에러
// k을 만나면? 4인 값 +1해줌 // 없으면 에러
public class SW5550 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tcNum = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= tcNum; tc++) {
			char[] words = br.readLine().trim().toCharArray();
			int N = words.length;
			int answer = -1;
			if (N % 5 == 0) {
				answer = 0;
				List<Character> frogs = new ArrayList<>();
				int pos = -1;
				outer: for (char c : words) {
					switch (c) {
					case 'c':
						frogs.add('c');
						if (answer < frogs.size()) {
							answer = frogs.size();
						}
						break;
					case 'r':
						pos = frogs.indexOf('c');
						if (pos >= 0) {
							frogs.set(pos, 'r');
						} else {
							answer = -1;
							break outer;
						}
						break;
					case 'o':
						pos = frogs.indexOf('r');
						if (pos >= 0) {
							frogs.set(pos, 'o');
						} else {
							answer = -1;
							break outer;
						}
						break;
					case 'a':
						pos = frogs.indexOf('o');
						if (pos >= 0) {
							frogs.set(pos, 'a');
						} else {
							answer = -1;
							break outer;
						}
						break;
					case 'k':
						pos = frogs.indexOf('a');
						if (pos >= 0) {
							frogs.remove(pos);
						} else {
							answer = -1;
							break outer;
						}
						break;
					default:
						answer = -1;
						break outer;
					}
				}
				if(!frogs.isEmpty()) {
					answer = -1;
				}
			}
			System.out.printf("#%d %d\n", tc, answer);
		}
	}
}
