package fromBOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class SW17140 {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		Comparator<int[]> myComparator = new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1]==0 && o2[1]==0) {
					return 0;
				} else if(o1[1]==0) {
					return 1;
				} else if(o2[1]==0) {
					return -1;
				}else if(o1[1]!=o2[1]) {
					return Integer.valueOf(o1[1]).compareTo(o2[1]);
				} else {
					return Integer.valueOf(o1[0]).compareTo(o2[0]);
				}
			}
		};
		st = new StringTokenizer(br.readLine().trim()," ");
		int[][] map = new int[100][100];
		int[][] sortValue = new int[100][2];
		int r = Integer.parseInt(st.nextToken())-1;
		int c = Integer.parseInt(st.nextToken())-1;
		int k = Integer.parseInt(st.nextToken());
		
		int R = 3;
		int C = 3;
		
		for(int i=0;i<R;i++) {
			st = new StringTokenizer(br.readLine().trim()," ");
			for(int j=0;j<C;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int answer = 0;
		
		int maxR = R;
		int maxC = C;
		
		while(map[r][c]!=k) {
			if(maxR>=maxC) {
				int rangeC = 0;
				for(int i=0;i<maxR;i++) {
					for(int idx=0;idx<sortValue.length;idx++) {
						sortValue[idx][0] = idx+1;
						sortValue[idx][1] = 0;
					}
					for(int j=0;j<maxC;j++) {
						if(map[i][j]==0) {
							continue;
						}
						sortValue[map[i][j]-1][1]++;
					}
					Arrays.sort(sortValue, myComparator);
					
					int range;
					for(range=0;range<50 && sortValue[range][1]!=0;range++) {
						map[i][2*range] = sortValue[range][0];
						map[i][2*range+1] = sortValue[range][1];
					}
					for(int j=range*2; j<maxC;j++) {
						map[i][j] = 0;
					}
					if(rangeC<range*2) {
						rangeC = range*2;
					}
				}
				maxC = rangeC;
			} else {
				int rangeR = 0;
				for(int j=0;j<maxC;j++) {
					for(int idx=0;idx<sortValue.length;idx++) {
						sortValue[idx][0] = idx+1;
						sortValue[idx][1] = 0;
					}
					for(int i=0;i<maxR;i++) {
						if(map[i][j]==0) {
							continue;
						}
						sortValue[map[i][j]-1][1]++;
					}
					Arrays.sort(sortValue, myComparator);
					
					int range;
					for(range=0;range<50 && sortValue[range][1]!=0;range++) {
						map[2*range][j] = sortValue[range][0];
						map[2*range+1][j] = sortValue[range][1];
					} 
					for(int i=range*2; i<maxR;i++) {
						map[i][j] = 0;
					}
					if(rangeR<range*2) {
						rangeR = range*2;
					}
				}
				maxR = rangeR;
			}
			if(answer>100) {
				break;
			}
			answer++;
		}
		
		if(answer>100) {
			answer = -1;
		}
		System.out.println(answer);
	}
}
