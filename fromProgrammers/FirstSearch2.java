package fromProgrammers;
/*
 * Problem URL: https://programmers.co.kr/learn/courses/30/lessons/43162
 */

public class FirstSearch2 {
    static boolean[][] bool;
    public static int solution(int n, int[][] computers){
        int answer = 0;
        bool = new boolean[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(computers[i][j]==0){
                    bool[i][j] = false; // 못감
                } else {
                    bool[i][j] = true; // 갈 수 있음
                }
            }
        }
        for(int i=0;i<n;i++){
            boolean isConn = true;
            boolean isSelf = true;
            for(int j=0;j<n;j++){
                if(bool[i][j]==true){
                    isConn = false;
                }
                if(bool[i][j] == true && i!=j){
                    isSelf = false;
                }
            }
            if(isConn){ // 이미 다 연결된 곳
                continue;
            } else if(isSelf){ // 자기 자신만 있는곳
                answer++;
                continue;
            } else{
                dfs(i, n);
                answer++;
            }
        }
        return answer;
    }
    public static void dfs(int i, int num){
        for(int j=0;j<num;j++){
            if(bool[i][j]){
                if(i==j){
                    bool[i][j] = false;
                    continue;
                } else{
                    bool[i][j] = false;
                    bool[j][i] = false;
                    dfs(j, num);
                }
            }
        }
    }

    public static void main(String[] args) {
        int a = 3;
        int[][] b = {{1,1,0},{1,1,0},{0,0,1}};
        int answer = solution(a,b);
        System.out.println(answer);
        int[][] c = {{1,1,0},{1,1,1},{0,1,1}};
        System.out.println(solution(3, c));
    }
}
