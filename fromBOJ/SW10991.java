package AlgorithmStudy.fromBOJ;

import java.io.*;

public class SW10991 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int star = 1;
        int space = N - 1;
        while (star <= N) {
            for (int i = 0; i < space; i++) {
                bw.write(" ");
            }
            for (int i = 0; i < star; i++) {
                bw.write("* ");
            }
            bw.write("\n");
            star++;
            space--;
        }
        bw.flush();
        bw.close();
    }
}
