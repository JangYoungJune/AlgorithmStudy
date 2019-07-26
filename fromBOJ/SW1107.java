package fromBOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//고민한 내용: 내가 짠 코트의 맨앞 값이 0이 나올 수 있다 >> 막자 + 자릿수가 -1, +1도 될 수 있다.
public class SW1107 {
	static int min;
	static int channel;
	static int channelLength;
	static boolean[] brokeSet = new boolean[10];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int now = 100;
		String tempChannel = br.readLine().trim();
		channelLength = tempChannel.length();
		channel = Integer.parseInt(tempChannel);
		int N = Integer.parseInt(br.readLine().trim());
		if(N>0) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			for (int i = 0; i < N; i++) {
				brokeSet[Integer.parseInt(st.nextToken())] = true;
			}
		}

		min = Math.abs(channel - now);

		findMinValue("");

		System.out.println(min);
	}

	public static void findMinValue(String num) {
		if (num.length() > 0 && num.length() >= channelLength - 1 && num.length() <= channelLength + 1) {
			int inputChannel = Integer.parseInt(num);
			int inputLength = String.valueOf(inputChannel).length();
			int tempMin = Math.abs(inputChannel - channel) + inputLength;
			if (tempMin < min) {
				min = tempMin;
			}
		}

		if (num.length() == channelLength + 1) {
			return;
		} else {
			for (int i = 0; i < 10; i++) {
				if (!brokeSet[i]) {
					findMinValue(num + i);
				}
			}
		}

	}
}
