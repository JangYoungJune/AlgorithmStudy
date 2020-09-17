package fromBOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SW1275 {
	static int[] arr;
	static long[] seg;
	static int n;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(st.nextToken());
		int tcNum = Integer.parseInt(st.nextToken());
		arr = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
		setSegments();

		for (int tc = 0; tc < tcNum; tc++) {
			st = new StringTokenizer(br.readLine().trim(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int cIdx = Integer.parseInt(st.nextToken());
			int newNum = Integer.parseInt(st.nextToken());
			if (x > y) {
				int temp = x;
				x = y;
				y = temp;
			}
			sb.append(sumRange(x, y)).append('\n');
			setSegmentChange(cIdx, newNum);
		}
		System.out.println(sb.toString());
	}

	public static void setSegments() {
		seg = new long[2 * n];
		for (int i = 1; i <= n; i++) {
			seg[i + n - 1] = arr[i - 1];
		}
		for (int i = n - 1; i >= 1; i--) {
			seg[i] = seg[i << 1] + seg[(i << 1) + 1];
		}
	}

	public static long sumRange(int start, int end) {
		long sum = 0l;
		start += n - 1;
		end += n - 1;

		while (start <= end) {
			if ((start & 1) == 1) {
				sum += seg[start++];
			}
			if ((end & 1) == 0) {
				sum += seg[end--];
			}
			start /= 2;
			end /= 2;
		}
		return sum;
	}

	public static void setSegmentChange(int idx, int newValue) {
		int bottomIdx = idx + n - 1;
		long diff = seg[bottomIdx] - newValue;
		seg[bottomIdx] -= diff;

		do {
			bottomIdx /= 2;
			seg[bottomIdx] -= diff;
		} while (bottomIdx > 0);
	}
}
