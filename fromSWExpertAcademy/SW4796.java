package fromSWExpertAcademy;
import java.util.Scanner;

public class SW4796 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int tcNum = sc.nextInt();
		for (int tc = 1; tc <= tcNum; tc++) {
			int N = sc.nextInt();
			int[] arr = new int[N];
			for(int i=0;i<N;i++) {
				arr[i] = sc.nextInt();
			}
			long answer = 0;
			int start = 0;
			int end = -1;
			int top = -1;
			int pre = -1;
			boolean isUp = false;
			for (int i = 0; i < N; i++) {
				if (pre > arr[i]) { // 작아지는중
					if (isUp) {
						isUp = false;
						top = (i<1)? 0 : i-1;
					}
					end = i;
				} else { // 커지는중
					if(!isUp){
						isUp = true;
						int length = end-start+1;
						if (length>= 3 && top!=start && top!=end) {
							answer+=(top-start) * (end-top);
						}
						start = (i!=0)? i-1 : i;
					}
				}
				pre = arr[i];
			}
			int length = end-start+1;
			if (length>= 3 && top!=start && top!=end) {
				answer+=(top-start) * (end-top);
			}
			System.out.println("#"+tc+" "+answer);
		}
		sc.close();
	}
}
