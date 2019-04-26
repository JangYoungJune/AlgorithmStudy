package fromProgrammers;
/*
 * Problem URL:https://programmers.co.kr/learn/courses/30/lessons/42898
 */

public class Dynamic4 {
    public static int solution(int m, int n, int[][] puddles) {
        int[][] road = new int[m][n];
        road[0][0]=1;

        // check puddle
        for(int[] puddle : puddles){
            road[puddle[0]-1][puddle[1]-1] = -1;
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                // in puddle
                if(road[i][j]==-1){
                    continue;
                }
                if(i==0 && j==0){
                    continue;
                } else if(i==0 && j!=0){
                    road[i][j] = (road[i][j-1]==-1)? 0 : road[i][j-1];
                }else if(i!=0 && j==0){
                    road[i][j] = (road[i-1][j]==-1)? 0 : road[i-1][j];
                } else{
                    int topWay = (road[i][j-1]!=-1)? road[i][j-1] : 0;
                    int leftWay = (road[i-1][j]!=-1)? road[i-1][j] : 0;
                    road[i][j] = (topWay+leftWay) % 1000000007;
                }
            }
        }
        return road[m-1][n-1];
    }

    public static void main(String[] args) {
        int a = 4;
        int b = 3;
        int[][] c = {{2,2}};
        int answer = solution(a,b,c);
        System.out.println(answer);
    }
}
