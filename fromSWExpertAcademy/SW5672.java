package fromSWExpertAcademy;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SW5672 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tcNum = Integer.valueOf(br.readLine().trim());
		for (int tc = 1; tc <= tcNum; tc++) {
			int N = Integer.valueOf(br.readLine().trim());
			char[] arr = new char[N];
			for (int i = 0; i < N; i++) {
				arr[i] = br.readLine().trim().charAt(0);
			}
			StringBuilder sb = new StringBuilder();

			int curstart = 0;
			int curend = N-1;
			for (int i = 0; i < N; i++) {
				if (arr[curstart] > arr[curend]) {
					sb.append(arr[curend--]);
				} else if (arr[curstart] < arr[curend]) {
					sb.append(arr[curstart++]);
				} else {
					int tempstart = curstart;
					int tempend = curend;
					boolean check = true;

					while (tempstart < tempend) {
						if (arr[tempstart] > arr[tempend]) {
							break;
						} else if (arr[tempstart] < arr[tempend]) {
							check = false;
							break;
						}

						tempstart++;
						tempend--;
					}

					if (check) {
						sb.append(arr[curend--]);
					} else {
						sb.append(arr[curstart++]);
					}
				}
			}
			System.out.println("#" + tc + " " + sb.toString());
		}
	}
}