package fromBOJ;

import java.util.Arrays;
import java.util.Scanner;

public class SW17144 {
	static int[][] map;
	static int R, C, T;
	static int upACPos = -1;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		T = sc.nextInt();
		map = new int[R][C];
		//init AC position and dust
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j]==-1 && upACPos==-1) {
					upACPos = i;
				}
			}
		}
		// 임시 어레이를 만든 후 맵을 기반으로 임시 어레이에 먼지 번진걸 적용한다.(공기청정기 / 칸없으면 확산 X)
		// 바람으로 민다.
		for(int time=0;time<T;time++) {
			// 먼지 퍼짐 적용
			int[][] tempMap = new int[R][C];
			tempMap[upACPos][0] = -1;
			tempMap[upACPos+1][0] = -1;
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if(map[i][j]==-1 || map[i][j]==0) {
						continue;
					}
					dustSpread(tempMap, i, j);
				}
			}
			map = tempMap;
			
			// 바람 적용
			airPress(true);
			airPress(false);
		}
		System.out.println(totalDust());
	}
	
	public static int totalDust() {
		int sum = 0;
		for(int i=0;i<R; i++) {
			for(int j=0;j<C;j++) {
				if(map[i][j]==-1) {
					continue;
				}
				sum += map[i][j];
			}
		}
		return sum;
	}

	public static void airPress(boolean isUp) {
		int airX = isUp? upACPos : upACPos+1;
		int preValue = 0;
		// 오른쪽으로
		for(int i=1; i<C;i++) {
			int originValue = map[airX][i];
			map[airX][i] = preValue;
			preValue = originValue;
		}
		// 위나 아래로
		if(isUp) {
			for(int i=airX-1; i>=0;i--) {
				int originValue = map[i][C-1];
				map[i][C-1] = preValue;
				preValue = originValue;
			}
		} else {
			for(int i=airX+1; i<R;i++) {
				int originValue = map[i][C-1];
				map[i][C-1] = preValue;
				preValue = originValue;
			}
		}
		// 왼쪽으로
		for(int i=C-2; i>=0;i--) {
			int xValue = (isUp)? 0:R-1;
			int originValue = map[xValue][i];
			map[xValue][i] = preValue;
			preValue = originValue;
		}
		// 공기청정기쪽으로
		if(isUp) {
			for(int i=1; i<airX;i++) {
				int originValue = map[i][0];
				map[i][0] = preValue;
				preValue = originValue;
			}
		} else {
			for(int i=R-2; i>airX;i--) {
				int originValue = map[i][0];
				map[i][0] = preValue;
				preValue = originValue;
			}
		}
	}
	
	public static void dustSpread(int[][] tempMap, int i, int j) {
		int[] xPos = {i-1, i, i+1, i};
		int[] yPos = {j, j-1, j, j+1};
		int dustVal = map[i][j]/5;
		int spreadCnt = 0;
		
		for(int t=0;t<xPos.length;t++) {
			if(isSpread(xPos[t], yPos[t])) {
				tempMap[xPos[t]][yPos[t]] += dustVal;
				spreadCnt++;
			}
		}
		
		tempMap[i][j] += (map[i][j] - dustVal*spreadCnt);
	}
	
	public static boolean isSpread(int i, int j) {
		return (i>=0 && i<R && j>=0 && j<C && map[i][j]!=-1)? true: false;
	}
}
