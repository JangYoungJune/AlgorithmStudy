package fromProgrammers;
/*
* Problem URL:https://programmers.co.kr/learn/courses/30/lessons/42899
* Ref: https://blog.leejseo.com/45
* i,j에서 i: 도시 거친 갯수 / j: 시간으로 DP programming
* */
public class Dynamic7 {
    public static int solution(int K, int[][] travel) {
        int size = travel.length;
        int[][] map = new int[size+1][K+1];
        boolean[][] visited = new boolean[size+1][K+1];
        visited[0][0] = true;
        for(int i=0;i<size;i++){
            int[] way = travel[i];
            for(int j=0;j<=K;j++){
                if(visited[i][j]==false){
                    continue;
                } if(j+way[0]<=K){
                    map[i+1][j+way[0]] = Math.max(map[i+1][j+way[0]], map[i][j]+way[1]);
                    visited[i+1][j+way[0]] = true;
                } if(j+way[2]<=K){
                    map[i+1][j+way[2]] = Math.max(map[i+1][j+way[2]], map[i][j]+way[3]);
                    visited[i+1][j+way[2]] = true;
                }
            }
        }
        int answer = 0;
        for(int i=0;i<=K;i++){
            answer = Math.max(answer, map[size][i]);
        }
        return answer;
    }

    public static void main(String[] args) {
        int a1 = 1650;
        int[][] b1 = {{500,200,200,100},{800,370,300,120},{700,250,300,90}};
        System.out.println(solution(a1,b1));
        int a2 = 3000;
        int[][] b2 = {{1000,2000,300,700},{1100,1900,400,900},{900,1800,400,700},{1200,2300,500,1200}};
        System.out.println(solution(a2,b2));
    }
}