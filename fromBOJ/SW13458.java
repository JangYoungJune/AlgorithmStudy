package AlgorithmStudy.fromBOJ;

import java.io.*;
import java.util.StringTokenizer;

public class SW13458 {
    static int N;
    static int[] arr;
    static int mainRef, subRef;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        answer = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        mainRef = Integer.parseInt(st.nextToken());
        subRef = Integer.parseInt(st.nextToken());
        for (int people : arr) {
            answer++;
            int remain = people - mainRef;
            if (remain > 0) {
                int subNum = remain / subRef;
                answer += subNum;
                remain -= subNum * subRef;
                answer += (remain > 0) ? 1 : 0;
            }
        }
        bw.write(answer + "");
        bw.flush();
        bw.close();
    }
}
