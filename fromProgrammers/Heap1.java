package fromProgrammers;

import java.util.Arrays;

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
		// while문은 제일 위의 값이 k값보다 클경우 / 또는 값이 1개밖에없을경우
		// 처음 상태를 힙소팅(소팅은 무조건 오름차순으로)
		// 상단 값을 뺀다.
		// 힙소팅한다.
		// 상단값을 뺀다.
		// 힙소팅한다.
		// 새 값을 추가한다.
		// 힙소팅한다.
		// 전체 사이클값을 1 올린다.

		int answer = 0;
		HeapClass heapArr = new HeapClass(scoville);
		while(heapArr.getMin() < k || heapArr.getSize() > 1){
			int lowestScoville = heapArr.heapPop();
			int secondLowScoville = heapArr.heapPop();
			heapArr.heapPush(lowestScoville + (secondLowScoville *2));
			answer++;
		}
		return answer;
	}

	public static void main(String args[]) {
		int[] a = {1,2,3,9,10,12};
		int b = 7;

		int answer = solution(a, b);
		System.out.println(answer);
	}
}
