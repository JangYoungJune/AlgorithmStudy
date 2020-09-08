package fromBOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class SW12865 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] arr = new int[K + 1];
		TreeSet<Integer> knapSack = new TreeSet<>((k1, k2) -> k2 - k1);
		Queue<Integer> q = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine().trim(), " ");
			int w = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			if (w > K)
				continue;

			for (int weight : knapSack) {
				if (weight + w > K)
					continue;
				if (arr[weight + w] < arr[weight] + v) {
					if (arr[weight + w] == 0) {
						q.offer(weight + w);
					}
					arr[weight + w] = arr[weight] + v;
				}
			}

			if (arr[w] < v) {
				if (arr[w] == 0) {
					q.offer(w);
				}
				arr[w] = v;
			}

			while (!q.isEmpty()) {
				knapSack.add(q.poll());
			}
		}
		int maxValue = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > maxValue) {
				maxValue = arr[i];
			}
		}
		System.out.println(maxValue);
	}
}
