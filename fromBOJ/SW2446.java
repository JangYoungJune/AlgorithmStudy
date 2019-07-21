package AlgorithmStudy.fromBOJ;

import java.io.*;

public class SW2446 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int max = 2 * N - 1;
        for (int i = 1; i <= max; i++) {
            if (i <= N) {
                for (int j = 1; j <= i - 1; j++) {
                    bw.write(" ");
                }
                for (int j = 1; j <= max - ((i - 1) * 2); j++) {
                    bw.write("*");
                }
                for (int j = 1; j <= i - 1; j++) {
                    bw.write(" ");
                }
            }
            if (i > N) {
                for (int j = 1; j <= max - i; j++) {
                    bw.write(" ");
                }
                for (int j = 1; j <= max - ((max - i) * 2); j++) {
                    bw.write("*");
                }
                for (int j = 1; j <= max - i; j++) {
                    bw.write(" ");
                }
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}
