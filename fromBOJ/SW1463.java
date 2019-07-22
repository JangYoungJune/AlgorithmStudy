package fromBOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class SW1463 {
	static int N;
	static int[] calc;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		calc = new int[N+1];
		for(int i=N;i>1;i--) {
			if(i%3==0) { 
				calc[i/3] = (calc[i/3]!=0 && calc[i/3]<calc[i]+1)? calc[i/3] : calc[i]+1;
			}
			if(i%2==0) { 
				calc[i/2] = (calc[i/2]!=0 && calc[i/2]<calc[i]+1)? calc[i/2] : calc[i]+1;
			}
			calc[i-1] = (calc[i-1]!=0 && calc[i-1]<calc[i]+1)? calc[i-1] : calc[i]+1;
		}
		bw.write(calc[1]+"");

		bw.flush();
		bw.close();
	}
}
