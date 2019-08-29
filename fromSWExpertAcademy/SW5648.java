package fromSWExpertAcademy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeSet;

public class SW5648 {
	static int N;
	static List<Atom> set;
	static class Atom{
		int x;
		int y;
		int dir;
		int e;
		public Atom(int x, int y, int dir, int e) {
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.e = e;
		}
	}
	static int answer; 
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tcNum = Integer.parseInt(br.readLine().trim());
		for(int tc=1;tc<=tcNum;tc++) {
			HashMap<Integer, Integer> checkSet = new HashMap<>(); 
			TreeSet<Integer> removeIdxSet = new TreeSet<>();
			N = Integer.parseInt(br.readLine().trim());
			set = new ArrayList<>(1000);
			answer = 0;
			for(int i=0;i<N;i++) {
				String[] str = br.readLine().trim().split(" ");
				set.add(new Atom((Integer.parseInt(str[0])+1000)*2,(Integer.parseInt(str[1])+1000)*2,Integer.parseInt(str[2]),Integer.parseInt(str[3])));
			}
			int remain = N;
			for(int l=0;l<4001;l++) {
				if(remain==0) {
					break;
				}
				// 움직임 >> 이때도 지운다(0.5초처리).
				for(int i=0;i<set.size();i++) {
					if(set.get(i).dir==0) {
						set.get(i).y++;
						if(set.get(i).y>4000) {
							set.remove(i);
							i--;
							remain--;
						}
					} else if(set.get(i).dir==1) {
						set.get(i).y--;
						if(set.get(i).y<0) {
							set.remove(i);
							i--;
							remain--;
						}
					} else if(set.get(i).dir==2) {
						set.get(i).x--;
						if(set.get(i).x<0) {
							set.remove(i);
							i--;
							remain--;
						}
					} else {
						set.get(i).x++;
						if(set.get(i).x>4000) {
							set.remove(i);
							i--;
							remain--;
						}
					}
				}
				// 원자 충돌확인
				checkSet.clear();
				// 양쪽에서 움직일 경우를 담는다.
				for(int i=0;i<set.size();i++) {
					int nowPos = ((set.get(i).x+set.get(i).y)*(set.get(i).x+set.get(i).y+1))/2+set.get(i).y;
					if(!checkSet.containsKey(nowPos)) {
						checkSet.put(nowPos, i);
					} else {
						removeIdxSet.add(i);
						removeIdxSet.add(checkSet.get(nowPos));
					}
				}
				while(!removeIdxSet.isEmpty()) {
					Atom removed = set.remove((int)removeIdxSet.pollLast());
					answer += removed.e;
					remain--;
				}
			}
			System.out.println("#"+tc+" "+answer);
		}
	}
}
