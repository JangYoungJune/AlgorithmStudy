package fromProgrammers;

import java.util.Arrays;

public class Test3_190126 {
	public static int solution(int[][] board, int[] nums) {
		int answer = 0;
		int l = board.length;
		Arrays.sort(nums);
		boolean[][] isCheck = new boolean[board.length][board.length];
		//init isCheck to false
		for(int i=0;i<l;i++) {
			for(int j=0;j<l;j++) {
				isCheck[i][j] = false;
			}
		}
		//check board's value is in the nums arr
		for(int i=0;i<l;i++) {
			for(int j=0;j<l;j++) {
				if(Arrays.binarySearch(nums, board[i][j])>=0) {
					isCheck[i][j] = true;
				}
			}
		}
		//find bingo
		// >> vertical / horizonal
		for(int i=0;i<l;i++) {
			boolean isHorizonal = true;
			boolean isVertical = true;
			for(int j=0; j<l;j++) {
				if(isCheck[i][j] != true) {
					isHorizonal = false;
				}
				if(isCheck[j][i] != true) {
					isVertical = false;
				}
			}
			answer = (isHorizonal == true)? answer + 1 : answer;
			answer = (isVertical == true)? answer + 1 : answer;
		}
		// >> diagonal
		boolean isDiagonal1 = true;
		boolean isDiagonal2 = true;
		for(int i=0;i<l;i++) {
			if(isCheck[0+i][0+i] != true) {
				isDiagonal1 = false;
			}
			if(isCheck[0+i][l-1-i] != true) {
				isDiagonal2 = false;
			}
		}
		answer = (isDiagonal1 == true)? answer + 1 : answer;
		answer = (isDiagonal2 == true)? answer + 1 : answer;
		return answer;
	}
	
	
	public static void main(String args[]) {
		int[][] a = {{11,13,15,16},{12,1,4,3},{10,2,7,8},{5,14,6,9}};
		int[] b = {14,3,2,4,13,1,16,11,5,15};
		
		int answer = solution(a, b);
		System.out.println(answer);
	}
}
