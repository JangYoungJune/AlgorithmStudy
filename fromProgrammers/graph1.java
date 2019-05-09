package fromProgrammers;
/*
 * Problem URL: https://programmers.co.kr/learn/courses/30/lessons/49189
 * 문제: 시간초과 해결해야함
 */
import java.util.Arrays;

public class graph1 {
    static int[] shortest;
    static boolean[][] roadMap;
    public static int solution(int n, int[][] edge) {
        int answer = 0;
        roadMap = new boolean[n+1][n+1];
        shortest = new int[n+1];
        for(int[] e : edge){
            roadMap[e[0]][e[1]] = true;
            roadMap[e[1]][e[0]] = true;
        }
        for(int i=1;i<shortest.length;i++){
            shortest[i] = Integer.MAX_VALUE;
        }

        boolean[] usePoint = new boolean[n+1];
        usePoint[1] = true;

        bfs(usePoint,  1, 0, n);

        int shortestMaxValue = Arrays.stream(shortest).max().getAsInt();
        for(int i=1;i<shortest.length;i++){
            answer = (shortest[i]==shortestMaxValue)? answer+1 : answer;
        }
        return answer;
    }
    public static void bfs(boolean[] usePoint, int position, int depth, int maxMove){
        if(shortest[position]>depth){
           shortest[position] = depth;
        }
        for(int i=1;i<roadMap.length;i++){
            if(roadMap[position][i] &&!usePoint[i] && (shortest[i]>depth+1)){
                usePoint[i] = true;
                bfs(usePoint, i, depth+1, maxMove);
                usePoint[i] = false;
            }
        }
    }
    public static void main(String[] args) {
        int a = 6;
        int[][] b = {{3,6},{4,3},{3,2},{1,3},{1,2},{2,4},{5,2}};
        System.out.println(solution(a,b));
    }
}
