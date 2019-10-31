package fromSWExpertAcademy;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW6109 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int tcNum = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= tcNum; tc++) {
			st = new StringTokenizer(br.readLine().trim()," ");
			int N = Integer.parseInt(st.nextToken());
			int[][] arr = new int[N][N];
			boolean[][] sumed = new boolean[N][N];
			char moveChar = st.nextToken().toLowerCase().charAt(0);
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine().trim()," ");
				for(int j=0;j<N;j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			switch(moveChar) {
			case 'u':
				for(int i=1;i<N;i++) {
					for(int j=0;j<N;j++) {
						if(arr[i][j]==0) {
							continue;
						}
						for(int k=i-1;k>=0;k--) {
							if(arr[k][j]==0) {
								if(k==0) {
									arr[k][j] =arr[i][j];
									arr[i][j] = 0;
									break;
								}
								continue;
							} else if(arr[k][j]==arr[i][j] && !sumed[k][j]) {
								arr[k][j] *= 2;
								arr[i][j] = 0;
								sumed[k][j] = true;
								break;
							} else {
								if(k+1 != i) {
									arr[k+1][j] = arr[i][j];
									arr[i][j] = 0;
								}
								break;
							}
						}
					}
				}
				break;
			case 'd':
				for(int i=N-2;i>=0;i--) {
					for(int j=0;j<N;j++) {
						if(arr[i][j]==0) {
							continue;
						}
						for(int k=i+1;k<N;k++) {
							if(arr[k][j]==0) {
								if(k==N-1) {
									arr[k][j] =arr[i][j];
									arr[i][j] = 0;
								}
								continue;
							} else if(arr[k][j]==arr[i][j] && !sumed[k][j]) {
								arr[k][j] *= 2;
								arr[i][j] = 0;
								sumed[k][j] = true;
								break;
							} else {
								if(k-1 != i) {
									arr[k-1][j] = arr[i][j];
									arr[i][j] = 0;
								}
								break;
							}
						}
					}
				}
				break;
			case 'l':
				for(int i=1;i<N;i++) {
					for(int j=0;j<N;j++) {
						if(arr[j][i]==0) {
							continue;
						}
						for(int k=i-1;k>=0;k--) {
							if(arr[j][k]==0) {
								if(k==0) {
									arr[j][k] =arr[j][i];
									arr[j][i] = 0;
								}
								continue;
							} else if(arr[j][k]==arr[j][i] && !sumed[j][k]) {
								arr[j][k] *= 2;
								arr[j][i] = 0;
								sumed[j][k] = true;
								break;
							} else {
								if(k+1 != i) {
									arr[j][k+1] = arr[j][i];
									arr[j][i] = 0;
								}
								break;
							}
						}
					}
				}
				break;
			case 'r':
				for(int i=N-2;i>=0;i--) {
					for(int j=0;j<N;j++) {
						if(arr[j][i]==0) {
							continue;
						}
						for(int k=i+1;k<N;k++) {
							if(arr[j][k]==0) {
								if(k==N-1) {
									arr[j][k] =arr[j][i];
									arr[j][i] = 0;
								}
								continue;
							} else if(arr[j][k]==arr[j][i] && !sumed[j][k]) {
								arr[j][k] *= 2;
								arr[j][i] = 0;
								sumed[j][k] = true;
								break;
							} else {
								if(k-1 != i) {
									arr[j][k-1] = arr[j][i];
									arr[j][i] = 0;
								}
								break;
							}
						}
					}
				}
				break;
			}
			
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc).append('\n');
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(j==N-1) {
						sb.append(arr[i][j]);
					} else {
						sb.append(arr[i][j]).append(' ');
					}
				}
				sb.append('\n');
			}
			
			System.out.print(sb.toString());
		}
	}
}
