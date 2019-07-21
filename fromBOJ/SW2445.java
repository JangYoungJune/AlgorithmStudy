package AlgorithmStudy.fromBOJ;

import java.io.*;

public class SW2445 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        for (int i = 1; i <= N * 2 - 1; i++) {
            if (i <= N) {
                for (int j = 0; j < i; j++) {
                    bw.write("*");
                }
                for (int j = N * 2 - 2 * i; j > 0; j--) { // 8 6 4 2 0
                    bw.write(" ");
                }
                for (int j = 0; j < i; j++) {
                    bw.write("*");
                }
            }
            if (i > N) {
                for (int j = N; j > i - N; j--) {
                    bw.write("*");
                }
                for (int j = 0; j < (i - N) * 2; j++) {
                    bw.write(" ");
                }
                for (int j = N; j > i - N; j--) {
                    bw.write("*");
                }
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}
