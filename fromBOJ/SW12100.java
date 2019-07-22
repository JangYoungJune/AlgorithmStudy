package fromBOJ;

import java.util.Arrays;
import java.util.Scanner;

public class SW12100 {
	static int N;
	static int[][] board;
	static int ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		board = new int[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				board[i][j] = sc.nextInt();
			}
		}
		for(int[] i : board) {
			System.out.println(Arrays.toString(i));
		}
//		boardSearch(5);
//		System.out.println();
	}
	
	public static void boardSearch(int count) {
		for(int c=0;c<4;c++) {
			int[][] tempBoard = new int[N][N];
			// copy board
			for(int i=0;i<N;i++) {
				tempBoard[i] = Arrays.copyOf(board[i], board[i].length);
			}
			
			// init pre board(use tempboard)
			for(int i=0;i<N;i++) {
				board[i] = Arrays.copyOf(tempBoard[i], tempBoard[i].length);
			}
		}
		
		// up / down / left / right
	}
}
