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
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int sharkCnt = Integer.parseInt(st.nextToken());
		int[][] arr = new int[R][C];
		List<Shark> sharkList = new ArrayList<>();
		for(int i=0;i<sharkCnt;i++) {
			st = new StringTokenizer(br.readLine().trim());
			int inputR = Integer.parseInt(st.nextToken()) - 1;
			int inputC = Integer.parseInt(st.nextToken()) - 1;
			int inputS = Integer.parseInt(st.nextToken());
			int inputD = Integer.parseInt(st.nextToken());
			int inputZ = Integer.parseInt(st.nextToken());
			sharkList.add(new Shark(inputR,inputC,inputS,inputD,inputZ));
			arr[inputR][inputC]++;
		}
		
		int answer = 0;
		for(int cycle=0;cycle<C;cycle++) {
			// 현재 위치 상어 잡기
			int lowR = -1;
			for(int r=0;r<R;r++) {
				if(arr[r][cycle]==1) {
					lowR = r;
					break;
				}
			}
			if(lowR!=-1) {
				int size = sharkList.size();
				for(int i=size-1;i>=0;i--) {
					if(sharkList.get(i).r==lowR && sharkList.get(i).c==cycle) {
						arr[lowR][cycle]--;
						answer += sharkList.remove(i).z;
						break;
					}
				}
			}
			// 상어 이동하기
			for(int i=0;i<sharkList.size();i++) {
				Shark shark = sharkList.get(i);
				arr[shark.r][shark.c]--;
				int speed = shark.s;
				if(shark.d==1 || shark.d==2) {
					speed = speed % ((R-1)*2);
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
					speed = speed % ((C-1)*2);
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
			// 겹치는 상어 정리
			for(int i=0;i<R;i++) {
				for(int j=0;j<C;j++) {
					if(arr[i][j]<=1) {
						continue;
					}
					int cnt = arr[i][j];
					int maxWeight = -1;
					int maxIdx = -1;
					int size = sharkList.size();
					
					for(int idx=size-1;idx>=0;idx--) {
						if(sharkList.get(idx).r==i && sharkList.get(idx).c==j) {
							if(maxIdx==-1) {
								maxIdx = idx;
								maxWeight = sharkList.get(idx).z;
								cnt--;
							} else {
								if(maxWeight>sharkList.get(idx).z) {
									sharkList.remove(idx);
									maxIdx--;
								} else {
									sharkList.remove(maxIdx);
									maxIdx = idx;
									maxWeight = sharkList.get(idx).z;
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
		System.out.println(answer);
	}
}
