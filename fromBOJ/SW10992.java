package AlgorithmStudy.fromBOJ;

import java.io.*;

public class SW10992 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int max = (N * 2) - 1;
        int star = 1;
        int space = N - 1;
        while (star <= N) {
            if (star == N) {
                for (int i = 0; i < max; i++) {
                    bw.write("*");
                }
            } else {
                for (int i = 0; i < space; i++) {
                    bw.write(" ");
                }
                bw.write("*");
                int midSpace = max - 2 - space * 2;
                for (int i = 0; i < midSpace; i++) {
                    bw.write(" ");
                }
                if (star != 1) {
                    bw.write("*");
                }
                bw.write("\n");
            }
            star++;
            space--;
        }
        bw.flush();
        bw.close();
    }
}
