package fromSWExpertAcademy;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW1209 {
	static int[][] arr;
	static int testNum;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int tc=0;tc<10;tc++) {
			arr = new int[101][101];
			testNum = Integer.parseInt(br.readLine());
			for (int i = 0; i < 100; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < 100; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int diag1=0, diag2=0;
			for(int i=0;i<100;i++) {
				diag1+=arr[i][i];
				diag2+=arr[i][99-i];
				for(int j=0;j<100;j++) {
					arr[i][100] += arr[i][j];
					arr[100][i] += arr[j][i];
				}
			}
			int max = Math.max(diag1, diag2);
			for(int i=0;i<100;i++) {
				int arrMax = Math.max(arr[i][100], arr[100][i]);
				if(max<arrMax) {
					max = arrMax;
				}
			}
			System.out.printf("#%d %d\n", testNum, max);
		}
		
	}
}
