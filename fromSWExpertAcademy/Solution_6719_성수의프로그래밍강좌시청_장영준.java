package fromSWExpertAcademy;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_6719_성수의프로그래밍강좌시청_장영준 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int tcNum = Integer.parseInt(br.readLine().trim());
		for(int tc=1;tc<=tcNum;tc++) {
			st = new StringTokenizer(br.readLine().trim()," ");
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int[] arr = new int[N];
			st = new StringTokenizer(br.readLine().trim()," ");
			for(int i=0;i<N;i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr);
			double value = 0;
			for(int i=N-K;i<N;i++) {
				value = (value+(double)arr[i])/2;
			}
			System.out.printf("#%d %.6f\n",tc, value);
		}
	}
}
