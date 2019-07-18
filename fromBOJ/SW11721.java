package fromBOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class SW11721 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String tc = bf.readLine();
		int i=0;
		while(true) {
			int maxEnd = (i+1)*10;
			boolean isEnd = (maxEnd>tc.length())? true : false;
			bw.write(tc.substring(i*10, (isEnd)? tc.length():maxEnd)+"\n");
			if(isEnd) {
				break;
			}
			i++;
		}
		bw.flush();
		bw.close();
	}
}
