package fromSWExpertAcademy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class SW7396 {
	static class Pos implements Comparable<Pos>{
		int n;
		int m;
		char c;
		int lv;
		
		public Pos(int n, int m, char c, int lv) {
			this.n = n;
			this.m = m;
			this.c = c;
			this.lv = lv;
		}
		
		@Override
		public int compareTo(Pos o) {
			if(this.lv!=o.lv) {
				return this.lv - o.lv;
			} else {
				return this.c - o.c;
			}
		}
	}
	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tcNum = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= tcNum; tc++) {
			StringBuilder answer = new StringBuilder();
			String[] strArr = br.readLine().trim().split(" ");
			int N = Integer.parseInt(strArr[0]);
			int M = Integer.parseInt(strArr[1]);
			char[][] nameMap = new char[N][M];
			for(int i=0;i<N;i++) {
				char[] lineChars = br.readLine().trim().toCharArray();
				for(int j=0;j<M;j++){
					nameMap[i][j] = lineChars[j];
				}
			}
			boolean[][] checkMap = new boolean[N][M];
			PriorityQueue<Pos> q = new PriorityQueue<>();
			q.add(new Pos(0, 0, nameMap[0][0],1));
			while(!q.isEmpty()) {
				char smallestC = q.peek().c;
				answer.append(smallestC);
				q.removeIf(p->p.c!=smallestC);
				
				int cycle = q.size();
				for(int i=0;i<cycle;i++) {
					Pos now = q.poll();
					if(now.m+1<M && !checkMap[now.n][now.m+1]) {
						checkMap[now.n][now.m+1] = true;
						q.offer(new Pos(now.n, now.m+1, nameMap[now.n][now.m+1],now.lv+1));
					}
					if(now.n+1<N && !checkMap[now.n+1][now.m]) {
						checkMap[now.n+1][now.m] = true;
						q.offer(new Pos(now.n+1, now.m, nameMap[now.n+1][now.m],now.lv+1));
					}
				}
			}
			
			
			System.out.println("#"+tc+" "+answer.toString());
		}
		
	}
}
