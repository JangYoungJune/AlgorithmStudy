package SWExpertAcademy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/*
 * Problem : 1208. [S/W 문제해결 기본] 1일차 - Flatten
 * URL : https://swexpertacademy.com/main/solvingProblem/solvingProblem.do
 * */

public class SW1208 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int cycle=1;cycle<=10;cycle++) {
			int answer = 0;
			int moveCnt = sc.nextInt();
			
			List<Integer> numList = new ArrayList<>(100);
			for(int i=0;i<100;i++) {
				numList.add(sc.nextInt());
			}
			
			numList.sort(Collections.reverseOrder());
			
			while(moveCnt>0) {
				// 첫번째가 가장 높은 값을 유지해야 한다 - 같은값이 있을경우 제일 안쪽부터 제거해 나간다.
				// 마지막 값이 가장 낮게 유지해야 한다 - 마지막쪽에 같은 값이 있을경우 제일 안쪽부터 채워나간다.
				int max_outer = numList.lastIndexOf(numList.get(0));
				int min_inner = numList.indexOf(numList.get(99));
				
				numList.set(max_outer, numList.get(max_outer)-1);
				numList.set(min_inner, numList.get(min_inner)+1);
				
				moveCnt--;
			}
			answer = numList.get(0) - numList.get(99);
			
			System.out.println("#"+cycle+" "+answer);
		}
		sc.close();
	}

}
