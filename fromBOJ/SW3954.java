package fromBOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class SW3954 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tcNum = Integer.parseInt(br.readLine().trim());
		for(int tc=1;tc<=tcNum;tc++) {
			String[] input = br.readLine().trim().split(" ");
			int memSize = Integer.parseInt(input[0]);
			int N = Integer.parseInt(input[1]);
			int M = Integer.parseInt(input[2]);
			int[] mem = new int[memSize];
			char[] code = br.readLine().trim().toCharArray();
			boolean[] useArr = new boolean[N];
			char[] word = br.readLine().trim().toCharArray();
			int mIdx = 0;
			int wIdx = 0;
			int cIdx = 0;
			for(int l = 0;l<50000000;l++) {
				if(cIdx>=N) {
					break;
				}
				switch(code[cIdx]) {
				case '-':
					mem[mIdx]--;
					if(mem[mIdx]<0) {
						mem[mIdx] = 256+mem[mIdx];
					}
					break;
				case '+':
					mem[mIdx]++;
					if(mem[mIdx]>255) {
						mem[mIdx] = mem[mIdx]-256;
					}
					break;
				case '<':
					mIdx--;
					if(mIdx<0) {
						mIdx = memSize+mIdx;
					}
					break;
				case '>':
					mIdx++;
					if(mIdx>=memSize) {
						mIdx = mIdx - memSize;
					}
					break;
				case '[':
					if(mem[mIdx]==0) {
						int stack = 0;
						for(int i=cIdx+1;i<N;i++) {
							if(code[i]=='[') {
								stack++;
							}
							if(code[i]==']') {
								if(stack!=0) {
									stack--;
								} else {
									cIdx = i;
									break;
								}
							}
						}
					}
					break;
				case ']':
					if(mem[mIdx]!=0) {
						int stack = 0;
						for(int i=cIdx-1;i>=0;i--) {
							if(code[i]==']') {
								stack++;
							}
							if(code[i]=='[') {
								if(stack!=0) {
									stack--;
								} else {
									cIdx = i;
									break;
								}
							}
						}
					} else {
						int stack = 0;
						useArr[cIdx] = true;
						for(int i=cIdx-1;i>=0;i--) {
							if(code[i]==']') {
								stack++;
							}
							if(code[i]=='[') {
								if(stack!=0) {
									stack--;
								} else {
									useArr[i] = true;
									break;
								}
							}
						}
					}
					break;
				case '.':
					break;
				case ',':
					if(wIdx>=M) {
						mem[mIdx] = 255;
					} else {
						mem[mIdx] = word[wIdx];
						wIdx++;
					}
					break;
				}
				cIdx++;
			}
			
			if(cIdx>=N) {
				System.out.println("Terminates");
			} else {
				int sLoop = 0;
				int eLoop = 0;
				for(int i=0;i<N;i++) {
					if(code[i]=='[' && !useArr[i]) {
						sLoop = i;
					} else if(code[i]==']' && !useArr[i]) {
						eLoop = i;
						break;
					}
				}
				System.out.println("Loops "+sLoop+" "+eLoop);
			}
		}
		
	}
}

/**
1
10 8 3
+[+[-]+]
aaa
 */


