package fromSWExpertAcademy;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SW1225 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 1; tc <= 10; tc++) {
			int tcNum = Integer.parseInt(br.readLine().trim());
			int[] arr = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(i -> Integer.parseInt(i)).toArray();
			int i = -1;
			int subVal = 0;
			do {
				i = (i + 1) % 8;
				subVal = subVal + 1;
				subVal = (subVal>5)? subVal-5 : subVal;
				arr[i] -= subVal;
			}while(arr[i] > 0);
			
			System.out.printf("#%d ", tcNum);
			for (int j = (i + 1) % 8; j != i; j = (j + 1) % 8) {
				System.out.printf("%d ", arr[j]);
			}
			System.out.printf("0\n");
		}
	}
}