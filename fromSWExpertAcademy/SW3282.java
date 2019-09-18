package fromSWExpertAcademy;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
/**
 * SWEA 3282 - 0/1 Knapsack
 * link: https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWBJAVpqrzQDFAWr&categoryId=AWBJAVpqrzQDFAWr&categoryType=CODE
 */
public class SW3282 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tcNum = Integer.parseInt(br.readLine().trim());
		for(int tc=1;tc<=tcNum;tc++) {
			String[] bStr = br.readLine().trim().split(" ");
			int N = Integer.parseInt(bStr[0]);
			int K = Integer.parseInt(bStr[1]);
			int[][] item = new int[N][2];
			for(int i=0;i<N;i++) {
				String[] cStr = br.readLine().trim().split(" ");
				item[i][0] = Integer.parseInt(cStr[0]);
				item[i][1] = Integer.parseInt(cStr[1]); 
			}
			int[] vArr = new int[K+1];
			for(int i=0;i<N;i++) {
				int[] nowArr = new int[K+1];
				for(int j=0;j<=K;j++) {
					nowArr[j] = vArr[j];
				}
				for(int j=item[i][0];j<=K;j++) {
					int now = vArr[j-item[i][0]] + item[i][1];
					int pre = vArr[j];
					if(now>pre) {
						nowArr[j] = now;
					}
				}
				System.out.println(Arrays.toString(nowArr));
				vArr = nowArr;
			}
			System.out.println("#"+tc+" "+vArr[K]);
		}
		
	}
}
