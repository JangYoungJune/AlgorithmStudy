package fromBOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SW15552 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int tc = Integer.parseInt(bf.readLine());
		for(int i=0;i<tc;i++) {
			String[] arr = bf.readLine().split(" ");
			bw.write(Integer.parseInt(arr[0])+Integer.parseInt(arr[1])+"\n");
		}
		bw.flush();
		bw.close();
	}
}
