package fromSWExpertAcademy;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SW4613 {
	static int N, M;
	static int[][] arr;
	static int answer;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tcNum = Integer.parseInt(br.readLine().trim());
		for(int tc=1;tc<=tcNum;tc++) {
			String[] str = br.readLine().trim().split(" ");
			N = Integer.parseInt(str[0]);
			M = Integer.parseInt(str[1]);
			answer = Integer.MAX_VALUE;
			arr = new int[N][3];
			for(int i=0;i<N;i++) {
				char[] lineVal = br.readLine().trim().toCharArray();
				for(int j=0;j<lineVal.length;j++) {
					switch(lineVal[j]) {
					case 'W':
						arr[i][0]++;
						break;
					case 'B':
						arr[i][1]++;
						break;
					case 'R':
						arr[i][2]++;
						break;
					}
				}
			}
			paintMinCount(0,0,0);
			System.out.println("#"+tc+" "+answer);
		}
	}
	
	public static void paintMinCount(int lineIdx, int color, int paintCnt) {
		if(lineIdx==N && color!=2) {
			return;
		} else if(color==2) { // R
			if(lineIdx==N) {
				return;
			}
			for(int i=lineIdx;i<N;i++) {
				paintCnt += (arr[i][0]+arr[i][1]);
			}
			if(answer>paintCnt) {
				answer = paintCnt;
			}
		} else {
			switch(color) {
			case 0: // W
				paintMinCount(lineIdx+1, color, paintCnt+arr[lineIdx][1]+arr[lineIdx][2]);
				paintMinCount(lineIdx+1, color+1, paintCnt+arr[lineIdx][1]+arr[lineIdx][2]);
				break;
			case 1: // B
				paintMinCount(lineIdx+1, color, paintCnt+arr[lineIdx][0]+arr[lineIdx][2]);
				paintMinCount(lineIdx+1, color+1, paintCnt+arr[lineIdx][0]+arr[lineIdx][2]);
				break;
			}
		}
	}
}
