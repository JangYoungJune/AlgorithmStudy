package fromSWExpertAcademy;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SW7206 {
	static int answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tcNum = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= tcNum; tc++) {
			answer = 0;
			int num = Integer.parseInt(br.readLine().trim());
			countSplit(num, 0);
			System.out.println("#" + tc + " " + answer);
		}
	}

	public static void countSplit(int num, int count) {
		if (num / 10 == 0) {
			if (answer < count) {
				answer = count;
			}
		} else {
			int div = 10;
			while (num / div != 0) {
				splitMultiply(num/div, num%div, count);
				div *= 10;
			}
		}
	}
	
	public static void splitMultiply(int multiply, int remain, int count) {
		countSplit(multiply * remain, count+1);
		if(remain/10==0) {
			return;
		} else {
			int div=10;
			while(remain/div!=0) {
				splitMultiply(multiply * (remain/div), remain%div, count);
				div *= 10;
			}
		}
	}
}
