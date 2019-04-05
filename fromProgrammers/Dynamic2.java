package fromProgrammers;
/*
 * Problem URL: https://programmers.co.kr/learn/courses/30/lessons/43105?language=java
 */
import java.util.Arrays;

public class Dynamic2 {
    public static int solution(int[][] triangle){
        for(int i=0;i<triangle.length;i++){
            int border = i+1;
            if(i==0){
                continue;
            }
            for(int j=0;j<border;j++){
                int leftValue = (j-1<0)? 0 : triangle[i-1][j-1];
                int rightValue = (j>i-1)? 0 : triangle[i-1][j];
                triangle[i][j] = triangle[i][j] + Math.max(leftValue, rightValue);
            }
        }

        return Arrays.stream(triangle[triangle.length-1]).max().getAsInt();
    }


    public static void main(String[] args) {
        int[][] a = {{7},{3,8},{8,1,0},{2,7,4,4},{4,5,2,6,5}};
        int answer = solution(a);
        System.out.println(answer);
    }
}
