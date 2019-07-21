package AlgorithmStudy.fromBOJ;

import java.io.*;

public class SW2522 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        for (int i = 1; i <= N * 2 - 1; i++) {
            if (i <= N) {
                for (int j = 1; j <= N - i; j++) {
                    bw.write(" ");
                }
                for (int j = 1; j <= i; j++) {
                    bw.write("*");
                }
            }
            if (i > N) {
                for (int j = 1; j <= i - N; j++) {
                    bw.write(" ");
                }
                for (int j = 1; j <= N * 2 - i; j++) {
                    bw.write("*");
                }
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}
