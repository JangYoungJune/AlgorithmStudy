package fromSWExpertAcademy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SW1928 {
	static StringBuilder encodingSet;
	public static void main(String[] args) throws Exception{
		
		encodingSet = new StringBuilder();
		for(int i=0;i<26;i++) {
			encodingSet.append((char)('A'+i));
		}
		for(int i=0;i<26;i++) {
			encodingSet.append((char)('a'+i));
		}
		for(int i=0;i<10;i++) {
			encodingSet.append((char)('0'+i));
		}
		encodingSet.append('+');
		encodingSet.append('/');
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testNum = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=testNum;tc++) {
			String line = br.readLine();
			StringBuilder binary = new StringBuilder();
			
			for(int i=0;i<line.length();i++) {
				String temp = Integer.toString(encodingSet.indexOf(line.substring(i, i+1)), 2);
				while(temp.length()<6) {
					temp = "0" + temp;
				}
				binary.append(temp);
			}
			System.out.print("#"+tc+" ");
			for(int i=0;i<binary.length()/8;i++) {
				char temp = (char)Integer.parseInt(binary.substring(i*8, (i+1)*8), 2);
				System.out.print(temp);
			}
			System.out.println();
		}
		
	}
}
