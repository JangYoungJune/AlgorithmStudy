package fromBOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SW17143 {
	static class Shark{
		int r;
		int c;
		int s;
		int d;
		int z;
		public Shark(int r, int c, int s, int d, int z) {
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}
	}
	static List<Shark> sharkList;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int sharkCnt = Integer.parseInt(st.nextToken());
		int[][] arr = new int[R][C];
		sharkList = new ArrayList<>();
		for(int i=0;i<sharkCnt;i++) {
			st = new StringTokenizer(br.readLine().trim());
			int inputR = Integer.parseInt(st.nextToken())-1;
			int inputC = Integer.parseInt(st.nextToken())-1;
			int inputS = Integer.parseInt(st.nextToken()); // 속도
			int inputD = Integer.parseInt(st.nextToken()); // 방향
			int inputZ = Integer.parseInt(st.nextToken()); // 무게
			sharkList.add(new Shark(inputR,inputC,inputS,inputD,inputZ));
			arr[inputR][inputC]++;
		}
		// 사람 움직이면서 상어 잡기
		int answer = 0;
		for(int c=0;c<C;c++) {
			int lowR = -1;
			for(int r=0;r<R;r++) {
				if(arr[r][c]==1) {
					lowR = r;
					break;
				}
			}
			if(lowR!=-1) {
				for(int i=0;i<sharkList.size();i++) {
					if(sharkList.get(i).r==lowR && sharkList.get(i).c==c) {
						arr[lowR][c]--;
						answer += sharkList.remove(i).z;
						break;
					}
				}
			}
			for(int i=0;i<sharkList.size();i++) {
				Shark shark = sharkList.get(i);
				arr[shark.r][shark.c]--;
				int speed = shark.s;
				if(shark.d==1 || shark.d==2) { // 상하
					speed = speed % (R*2-2);
					while(speed!=0) {
						if(shark.d==1 && shark.r==0) {
							shark.d=2;
						}
						if(shark.d==2 && shark.r==R-1) {
							shark.d=1;
						}
						if(shark.d==1) {
							shark.r--;
						} else {
							shark.r++;
						}
						speed--;
					}
				} else {
					speed = speed % (C*2-2);
					while(speed!=0) {
						if(shark.d==4 && shark.c==0) {
							shark.d=3;
						}
						if(shark.d==3 && shark.c==C-1) {
							shark.d=4;
						}
						if(shark.d==4) {
							shark.c--;
						} else {
							shark.c++;
						}
						speed--;
					}
				}
				arr[shark.r][shark.c]++;
			}
			for(int i=0;i<R;i++) {
				for(int j=0;j<C;j++) {
					if(arr[i][j]>1) {
						int cnt = arr[i][j];
						int maxWeight = -1;
						int maxIdx = -1;
						for(int idx=sharkList.size()-1;idx>=0;idx--) {
							if(sharkList.get(idx).r==i && sharkList.get(idx).c==j) {
								if(maxIdx==-1) {
									maxIdx = i;
									maxWeight = sharkList.get(i).z;
									cnt--;
								} else {
									if(maxWeight>sharkList.get(i).z) {
										sharkList.remove(i);
									} else {
										sharkList.remove(maxIdx);
										maxIdx = i;
										maxWeight = sharkList.get(i).z;
									}
									cnt--;
								}
								
								if(cnt==0) {
									break;
								}
							}
						}
						arr[i][j]=1;
					}
				}
			}
			
		}
		System.out.println(answer);
	}
}
