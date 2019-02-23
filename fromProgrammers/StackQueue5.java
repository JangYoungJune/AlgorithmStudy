package fromProgrammers;

public class StackQueue5 {
	public static int[] solution(int[] heights) {
		int[] answer = new int[heights.length];
		
		for(int i=heights.length-1;i>=0;i--) {
			int highTop=0;
			for(int j=i-1;j>=0 && i!=0;j--) {
				if(heights[i]<heights[j]) {
					highTop = j+1;
					break;
				}
			}
			answer[i] = highTop;
		}
        return answer;
    }
	
	public static void main(String args[]) {
		int[] a = {6,9,5,7,4};
		
		
		int[] answer = solution(a);
        for(int value : answer){
            System.out.print(value+" ");
        }
	}
}
