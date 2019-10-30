package fromSWExpertAcademy;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class SW4050 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tcNum = Integer.parseInt(br.readLine().trim());
		for(int tc=1;tc<=tcNum;tc++) {
			int N = Integer.parseInt(br.readLine().trim());
			int[] arr = Arrays.stream(br.readLine().trim().split(" ")).map(Integer::valueOf).sorted(Collections.reverseOrder()).mapToInt(i->i).toArray();
			int arrSize = arr.length;
			int answer = 0;
			for(int i=0;i<arrSize;i++) {
				if(i%3==2) {
					continue;
				}
				answer += arr[i];
			}
			System.out.println("#"+tc+" "+answer);
		}
	}
}
