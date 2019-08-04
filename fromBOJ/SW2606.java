package fromBOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SW2606 {
    static boolean[][] map = new boolean[101][101];
    static boolean[] ans;
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine().trim());
        ans = new boolean[N + 1];
        int mapTotal = Integer.parseInt(br.readLine().trim());
        for (int i = 0; i < mapTotal; i++) {
            String[] temp = br.readLine().trim().split(" ");
            int a1 = Integer.parseInt(temp[0]);
            int a2 = Integer.parseInt(temp[1]);
            map[a1][a2] = true;
            map[a2][a1] = true;
        }
        boolean[] moveMap = new boolean[N + 1];
        moveMap[1] = true;
        dfs(moveMap, 1);
        int answer = 0;
        for (int i = 2; i < ans.length; i++) {
            if (ans[i]) {
                answer++;
            }
        }
        System.out.println(answer);
    }

    public static void dfs(boolean[] moveMap, int node) {
        for (int i = 1; i <= N; i++) {
            if (!ans[i] && !moveMap[i] && map[node][i] == true) { // 안갔던 길 + 길이 나있어야 함
                ans[i] = true;

                moveMap[i] = true;
                dfs(moveMap, i);
                moveMap[i] = false;
            }
        }
    }
}

