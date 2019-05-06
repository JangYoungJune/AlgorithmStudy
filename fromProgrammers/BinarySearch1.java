package fromProgrammers;

import java.util.Arrays;
/*
*  Problem URL: https://programmers.co.kr/learn/courses/30/lessons/43238?language=java
*  최소: 1 / 최대: times중 가장 큰값 * 인원
*  중간값을 구한 뒤, 각 time으로 사람이 몇명 가능한지 확인한다.
*  >> 사람수가 더 적다 : 시간을 더 늘려야 한다(left = mid+1 > +1은 무한루프 방지)
*  >> 사람수가 같거나 더 많다 : 시간을 더 줄일 수 있다(right = mid)
*  left<right될때 right값이 최소시간이 된다
* */
public class BinarySearch1 {
    public static long solution(int n, int[] times) {
        long left = 1;
        long right = (long)Arrays.stream(times).max().getAsInt() * (long)n;
        while(left<right){
            long mid = (right+left)/2;
            long cnt = 0;
            for(long time : times){
                cnt = cnt + (mid/time);
            }
            if(cnt<n){
                left = mid + 1;
            } else{
                right = mid;
            }
        }

        return right;
    }

    public static void main(String[] args) {
        int a = 6;
        int[] b = {7,10};

        long answer = solution(a,b);
        System.out.println(answer);
    }
}
