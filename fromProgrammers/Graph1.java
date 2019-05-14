package fromProgrammers;
/*
 * Problem URL: https://programmers.co.kr/learn/courses/30/lessons/49189
 * 문제: 시간초과 해결해야함
 * 05.14 해결함
 * >> 기존 재귀로 풀던것을 bfs+queue를 사용함
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

class Graph1 {
    public static class Node{
        private int vertex;
        private int count;
        public Node(int vertex){
            this.vertex = vertex;
            this.count = Integer.MAX_VALUE;
        }        public int getVertex() {
            return vertex;
        }
        public void setCount(int count) {
            this.count = count;
        }

        public int getCount() {
            return count;
        }
    }

    public static int solution(int n, int[][] edge) {
        boolean[][] roadMap = new boolean[n+1][n+1]; // 간선 표시
        for(int[] e : edge){
            roadMap[e[0]][e[1]] = true;
            roadMap[e[1]][e[0]] = true;
        }
        List<Node> nodeList = new ArrayList<>(); // 노드 만들기
        for(int i=1;i<=n;i++) {
            nodeList.add(new Node(i));
        }

        boolean[] usePoint = new boolean[n+1]; // 이동 표시
        usePoint[1] = true;

        Queue<Node> queue = new ConcurrentLinkedQueue<>();
        Node start = nodeList.get(0);
        start.setCount(0);
        queue.add(start);
        while(!queue.isEmpty()){
            Node nowNode = queue.poll();
            for(int i=1;i<=n;i++){
                boolean existRoad = roadMap[nowNode.getVertex()][i];
                if(existRoad && !usePoint[i]){
                    Node possibleNode = nodeList.get(i-1);
                    possibleNode.setCount(nowNode.getCount()+1);
                    queue.add(possibleNode);
                    usePoint[i] = true;
                }
            }
        }
        int maxValue = nodeList.stream().mapToInt(i->i.getCount()).max().getAsInt();
        return (int) nodeList.stream().filter(i->i.getCount()==maxValue).count();
    }

    public static void main(String[] args) {
        int a = 6;
        int[][] b = {{3,6},{4,3},{3,2},{1,3},{1,2},{2,4},{5,2}};
        System.out.println(solution(a,b));
    }
}
