package fromProgrammers;

import java.util.Arrays;
/*
 * problem URL: https://programmers.co.kr/learn/courses/30/lessons/42626
 * */
public class Heap1 {

	static class HeapClass{
		private int[] arr;
		private int size;

		public HeapClass(int[] arr){
			Arrays.sort(arr);
			this.arr = arr;
			this.size = arr.length;
		}

		public int heapPop(){
			int popValue = arr[0];
			arr[0] = arr[size-1];
			arr[size-1] = -1;
			size--;
			int startIdx = 0;
			while(startIdx*2+1 <= size-1){
				boolean isSingleChild = (startIdx*2+2 <= size-1)? false : true;
				int firstIdx = startIdx*2+1;
				int secondIdx = startIdx*2+2;
				int selectIdx;
				if(isSingleChild){
					selectIdx = firstIdx;
				} else {
					selectIdx = (arr[firstIdx]>arr[secondIdx])? secondIdx : firstIdx;
				}

				if(arr[selectIdx] >= arr[startIdx]){
					break;
				}
				int tempValue = arr[startIdx];
				arr[startIdx] = arr[selectIdx];
				arr[selectIdx] = tempValue;
				startIdx = selectIdx;
			}
			return popValue;
		}

		public void heapPush(int inputed){
			int startIdx = size;
			arr[size] = inputed;
			size++;
			while(startIdx!=0){
				int parentIdx = (startIdx%2==1)? (startIdx / 2) : (startIdx / 2 - 1);
				if(arr[parentIdx] <= arr[startIdx]){
					break;
				}
				int tempValue = arr[startIdx];
				arr[startIdx] = arr[parentIdx];
				arr[parentIdx] = tempValue;
				startIdx = parentIdx;
			}
		}

		public int getMin(){
			return this.arr[0];
		}

		public int getSize(){
			return this.size;
		}
	}

	public static int solution(int[] scoville, int k) {
		// while loop - min heap's value is bigger then k / only 1 left scoville
		// in heapclass -> initialize array by ascend order
		// pop 2 values(by heapsort)
		// add 1 new scoville value(by heapsort)
		// 1 add to cycle(answer)
		// before return value, check exception situation(min value lack the limitaion(K))
		int answer = 0;
		HeapClass heapArr = new HeapClass(scoville);
		while(heapArr.getMin() < k && heapArr.getSize() > 1){
			int lowestScoville = heapArr.heapPop();
			int secondLowScoville = heapArr.heapPop();
			heapArr.heapPush(lowestScoville + (secondLowScoville *2));
			answer++;
		}
		return (heapArr.getMin()<k)? -1 : answer;
	}

	public static void main(String args[]) {
		int[] a = {1,2,3,9,10,12};
		int b = 7;

		int answer = solution(a, b);
		System.out.println(answer);
	}
}
