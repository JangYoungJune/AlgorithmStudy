package fromProgrammers;
/*
*  Problem URL: https://programmers.co.kr/learn/courses/30/lessons/43236
* */
import java.util.Arrays;

public class BinarySearch2 {
    public static int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks);
        int left = 0;
        int right = distance;
        int prevRight = -1, prevLeft = -1;

        while(left<right){
            if(prevLeft==left && prevRight==right){
                break;
            }
            int mid = (right+left)/2;
            int removeCnt = possibleRemoveRock(rocks, mid, distance);

            prevLeft = left;
            prevRight = right;

            if(removeCnt<=n){
                left = mid;
            } else{
                right = mid;
            }
        }
        int minValue = possibleRemoveRock(rocks, left, distance);
        int maxValue = possibleRemoveRock(rocks, right, distance);
        return (minValue==maxValue)? right : ((maxValue <= n)? right : left);
    }

    public static int possibleRemoveRock(int[] rocks, int std, int end){
        int removeCnt = 0;
        int prev = -1;
        int gap = 0;
        for(int i=0;i<=rocks.length;i++){
            if(prev == -1 && i!=rocks.length){
                gap = rocks[i];
            } else if(i==rocks.length){
                gap = end - rocks[rocks.length-1];
            } else{
                gap = rocks[i] - rocks[prev];
            }
            if(gap<std){
                removeCnt++;
            } else{
                prev = i;
            }
        }
        return removeCnt;
    }

    public static void main(String[] args) {
        int a = 25;
        int[] b = {3, 6, 10, 14, 21};
        int c = 2;
        int answer = solution(a,b,c);
        System.out.println(answer);
    }
}
