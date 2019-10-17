package fromBOJ;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class SW16235 {
	static class Tree{
		int r;
		int c;
		int age;
		boolean isLive;
		public Tree(int r, int c, int age) {
			this.r = r;
			this.c = c;
			this.age = age;
			this.isLive = true;
		}
	}
	static int N, M, K;
	static int[][] supply;
	static int[][] fert;
	static LinkedList<Tree> trees;
	static int[][] dir = {{1,0},{0,1},{-1,0},{0,-1},{1,1},{-1,-1},{1,-1},{-1,1}};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		supply = new int[N][N];
		fert =  new int[N][N];
		trees = new LinkedList<>();
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine().trim()," ");
			for(int j=0;j<N;j++) {
				supply[i][j] = Integer.parseInt(st.nextToken());
				fert[i][j] = 5;
			}
		}
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine().trim()," ");
			int r = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken())-1;
			int age = Integer.parseInt(st.nextToken());
			trees.add(new Tree(r,c,age));
		}
		Collections.sort(trees, (o1, o2)->	o1.age-o2.age);
		
		int age = 0;
		while(age!=K) {
			// spring
			for(Iterator<Tree> it=trees.iterator();it.hasNext();) {
				Tree t = it.next();
				if(fert[t.r][t.c] < t.age) {
					t.isLive = false;
				} else {
					fert[t.r][t.c] -= t.age;
					t.age++;
				}
			}
			// summer
			for(Iterator<Tree> it=trees.iterator();it.hasNext();) {
				Tree t = it.next();
				if(!t.isLive) {
					fert[t.r][t.c] += t.age/2;
					it.remove();
				}
			}
			// autumn
			LinkedList<Tree> temp = new LinkedList<>();
			for(Iterator<Tree> it=trees.iterator(); it.hasNext();) {
				Tree now = it.next();
				if(now.age%5==0) {
					for(int d=0;d<8;d++) {
						int nowR = now.r+dir[d][0];
						int nowC = now.c+dir[d][1];
						if(nowR>=0 && nowR<N && nowC>=0 && nowC<N) {
							temp.add(new Tree(nowR, nowC, 1));
						}
					}
				}
			}
			for(Iterator<Tree> it=temp.iterator(); it.hasNext();) {
				trees.addFirst(it.next());
			}
			
			// winter
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					fert[i][j] += supply[i][j];
				}
			}
			age++;
		}
		
		System.out.println(trees.size());
	}
}
