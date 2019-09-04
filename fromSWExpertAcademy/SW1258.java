package fromSWExpertAcademy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SW1258 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int tcNum = Integer.parseInt(br.readLine().trim());
		for(int tc=1;tc<=tcNum;tc++) {
			int N = Integer.parseInt(br.readLine().trim());
			int[][] arr = new int[N][N];
			int[][] info = new int[3000][2];
			int infoCnt = 0;
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine().trim(), " ");
				for(int j=0;j<N;j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i=0;i<info.length;i++) {
				info[i][0] = Integer.MAX_VALUE;
			}
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(arr[i][j]!=0) {
						int r, c;
						for(r=i+1;r<N && arr[r][j]!=0; r++) {}
						for(c=j+1;c<N && arr[i][c]!=0; c++) {}
						for(int a = i;a<r;a++) {
							for(int b=j;b<c;b++) {
								arr[a][b] = 0;
							}
						}
						info[infoCnt][0] = r-i;
						info[infoCnt][1] = c-j;
						infoCnt++;
					}
				}
			}
			
			Arrays.sort(info, (o1, o2)->{
				if(o1[0]==Integer.MAX_VALUE && o2[0]==Integer.MAX_VALUE) {
					return 0;
				} else if(o1[0]==Integer.MAX_VALUE) {
					return 1;
				} else if(o2[0]==Integer.MAX_VALUE) {
					return -1;
				} else if(o1[0]*o1[1]!=o2[0]*o2[1]) {
					return Integer.valueOf(o1[0]*o1[1]).compareTo(o2[0]*o2[1]);
				} else {
					return Integer.valueOf(o1[0]).compareTo(o2[0]);
				}
			});
			
			StringBuilder sb = new StringBuilder().append("#").append(tc).append(" ").append(infoCnt);
			for(int i=0;i<infoCnt;i++) {
				sb.append(" ").append(info[i][0]);
				sb.append(" ").append(info[i][1]);
			}
			System.out.println(sb.toString());
		}
	}
}
