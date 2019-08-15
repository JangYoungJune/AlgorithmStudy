package fromBOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SW16236 {
    static class Pos{
        int x;
        int y;
        public Pos(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int N;
    static int[][] map;
    static Pos shark;
    static int sharkSize = 2;
    static int sharkAte = 0;
    static boolean isContinue = true;
    static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
    static int answer = 0;
    static int distance;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine().trim());
        map = new int[N][N];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine().trim()," ");
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==9){
                    shark=new Pos(i, j);
                }
            }
        }
        do{
            bfs();
        }while(isContinue);
        System.out.println(answer);
        br.close();
    }
    public static void bfs(){
        Queue<Pos> queue = new LinkedList<>();
        Queue<Pos> moveQueue = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];
        distance = 0;
        visited[shark.x][shark.y] = true;
        queue.offer(shark);
        while(!queue.isEmpty() && moveQueue.isEmpty()){
            distance++;
            int size = queue.size();
            for(int i=0;i<size;i++){
                Pos now = queue.poll();
                for(int d=0;d<4;d++){
                    int moveX = now.x+dir[d][0];
                    int moveY = now.y+dir[d][1];
                    if(moveX>=0 && moveX<N && moveY>=0 && moveY<N && !visited[moveX][moveY] && sharkSize>=map[moveX][moveY]){
                        if(map[moveX][moveY] > sharkSize){ // 자기 사이즈보다 큼
                            continue;
                        }else{ // 자기 사이즈보다 같거나 작음
                            Pos temp = new Pos(moveX, moveY);
                            visited[moveX][moveY] = true;
                            queue.offer(temp);
                            if(map[moveX][moveY]>0 && map[moveX][moveY]<sharkSize){ //먹을 수 있음
                                moveQueue.offer(temp);
                            }
                        }
                    }
                }
            }
        }
        if(moveQueue.isEmpty()){
            isContinue = false;
        } else{
            int size = moveQueue.size();
            Pos temp = null;
            for (int i = 0; i < size; i++) {
                if(temp==null){
                    temp = moveQueue.poll();
                } else{
                    Pos pop = moveQueue.poll();
                    if(pop.x<temp.x || (pop.x==temp.x && pop.y<temp.y)){
                        temp = pop;
                    }
                }
            }
            map[shark.x][shark.y] = 0;
            shark.x = temp.x;
            shark.y = temp.y;
            map[shark.x][shark.y] = 9;
            sharkAte++;
            if(sharkAte==sharkSize){
                sharkSize++;
                sharkAte = 0;
            }
            answer += distance;
        }
    }
}
