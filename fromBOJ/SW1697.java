package fromBOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class SW1697 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().trim().split(" ");
		int N = Integer.parseInt(str[0]);
		int K = Integer.parseInt(str[1]);
		int[] map = new int[100001];
		Queue<Integer> queue =  new LinkedList<>();
		queue.add(N);
		while(!queue.isEmpty()) {
			int now = queue.poll();
			if(now==K) {
				break;
			}
			if(now+1<map.length && map[now+1]==0) {
				map[now+1] = map[now]+1;
				queue.add(now+1);
			}
			if(now-1>=0 && map[now-1]==0) {
				map[now-1] = map[now]+1;
				queue.add(now-1);
			}
			if(now*2<map.length && map[now*2]==0) {
				map[now*2] = map[now]+1;
				queue.add(now*2);
			}
		}
		System.out.println(map[K]);
	}
}
