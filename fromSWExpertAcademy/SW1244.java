package fromSWExpertAcademy;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
 * times 만큼 도는데
 * 지정된 자리 vs 자리 이후 arr
 * 만약에 reverse sort가 완료된 시점
 * > 1. 같은 값이 있을경우 : 그냥 답 도출
 * > 2. 같은 값이 없을경우 : 아래 두개 짝수행 실행 계산하여 값 처리
 * >> 그리디적 접근에서 오류남: 32888 2 >> dfs로 접근하자.
*/

public class SW1244 {
	static int[] arr;
	static int answer;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cycle_num = sc.nextInt();
		
		for(int cycle = 1; cycle<=cycle_num; cycle++) {
			answer = 0;
			arr = Integer.toString(sc.nextInt()).chars().map(c -> c-'0').toArray();
			int times = sc.nextInt();
			dfs(times, 0);
			
			System.out.println("#"+cycle+" "+answer);
		}
		sc.close();
	}
	
	public static void dfs(int times, int idx) {
		if(times==0 || idx>=arr.length-2) {
			boolean is_distinct = (arr.length==IntStream.of(arr).boxed().collect(Collectors.toSet()).size());
			if(times>0 && is_distinct && times%2!=0) {
				int temp = arr[arr.length-1];
				arr[arr.length-1] = arr[arr.length-2]; 
				arr[arr.length-2] = temp;
			}
			int result = Integer.parseInt(IntStream.of(arr).mapToObj(String::valueOf).collect(Collectors.joining("")));
			answer = (answer>=result)? answer : result;
		} else {
			
			int now_val = arr[idx];
			int[] others = Arrays.copyOfRange(arr, idx+1, arr.length);
			
			// find max idx between now index+1 to end 
			int max = Arrays.stream(others).max().getAsInt();
			int max_count = (int) Arrays.stream(others).filter(i->i==max).count();
			if(max>now_val) {
				for(int i=0;i<others.length;i++) {
					if(others[i]==max) {
						int origin_idx = i+(idx+1);
						int temp = arr[idx];
						arr[idx] = arr[origin_idx];
						arr[origin_idx] = temp;
						dfs(times-1, idx+1);
						if(max_count!=1) {
							arr[origin_idx] = arr[idx];
							arr[idx] = temp;
						}
					}
				}
			} else {
				dfs(times, idx+1);
			}
			
		}
	}
}
