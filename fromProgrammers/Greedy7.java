package fromProgrammers;

import java.util.Arrays;

public class Greedy7 {
    public static int solution(int n, int[][] costs) {
        int answer = 0;
        int count = 0;
        // find the number of islands
        for(int[] cost : costs){
            count = Math.max(count, Math.max(cost[0], cost[1]));
        }
        int[] island = new int[count+1];
        for(int i=0;i<island.length;i++){
            island[i] = i;
        }
        Arrays.sort(costs, (o1,o2)->o1[2]-o2[2]);

        for(int[] cost : costs){
            // road is already connected
            if(island[cost[0]]==island[cost[1]]){
                continue;
            }
            // is not connected
            else{
                int changeValue = island[cost[1]];
                int fixValue = island[cost[0]];
                for(int i=0;i<island.length;i++){
                    if(island[i] == changeValue){
                        island[i] = fixValue;
                    }
                }
                answer += cost[2];
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int a = 4;
        int[][] b = {{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}};
        int answer = solution(a,b);
        System.out.println(answer);
    }
}
