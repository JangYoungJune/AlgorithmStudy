package fromBOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW2357 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] minSeg = new int[2 * n];
		int[] maxSeg = new int[2 * n];
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(br.readLine().trim());
			minSeg[n + i] = num;
			maxSeg[n + i] = num;
		}
		initSegments(minSeg, maxSeg, n);
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine().trim(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			sb.append(findValue(minSeg, n, start, end, true)).append(" ")
					.append(findValue(maxSeg, n, start, end, false)).append('\n');
		}
		System.out.println(sb.toString());
	}

	private static void initSegments(int[] minSeg, int[] maxSeg, int n) {
		for (int i = n - 1; i > 0; i--) {
			minSeg[i] = Math.min(minSeg[i * 2], minSeg[i * 2 + 1]);
			maxSeg[i] = Math.max(maxSeg[i * 2], maxSeg[i * 2 + 1]);
		}
	}

	private static int findValue(int[] seg, int n, int start, int end, boolean isMin) {
		start += n - 1;
		end += n - 1;
		int condition = isMin ? Integer.MAX_VALUE : 0;
		while (start <= end) {
			int c1 = isMin ? Integer.MAX_VALUE : 0;
			int c2 = isMin ? Integer.MAX_VALUE : 0;

			if ((start & 1) == 1) {
				c1 = seg[start++];
			}
			if ((end & 1) == 0) {
				c2 = seg[end--];
			}
			condition = isMin ? Math.min(condition, Math.min(c1, c2)) : Math.max(condition, Math.max(c1, c2));

			start /= 2;
			end /= 2;
		}
		return condition;
	}
}
