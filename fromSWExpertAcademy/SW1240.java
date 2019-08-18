package fromSWExpertAcademy;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW1240 {
	static String[] decode = {
			"0001101",
			"0011001",
			"0010011",
			"0111101",
			"0100011",
			"0110001",
			"0101111",
			"0111011",
			"0110111",
			"0001011"
	};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int tcNum = Integer.parseInt(br.readLine().trim());
		for(int tc = 1;tc<=tcNum;tc++) {
			st = new StringTokenizer(br.readLine().trim(), " ");
			int total = Integer.parseInt(st.nextToken());
			int size = Integer.parseInt(st.nextToken());
			int answer = 0;
			for(int i=0;i<total;i++) {
				int[] password = new int[15]; 
				int passIdx = 0;
				String words = br.readLine().trim();
				int idx = size-1;
				while(idx>=6) {
					if(words.charAt(idx)==0) {
						idx--;
						continue;
					} else{
						String part = words.substring(idx-6, idx+1);
						int passPart = -1;
						for(int j=0;j<10;j++) {
							if(decode[j].equals(part)) {
								passPart = j;
								break;
							}
						}
						if(passPart != -1) {
							password[passIdx] = passPart;
							passIdx++;
							idx = idx-7;
						} else {
							idx--;
						}
					}
				}
				if(passIdx==8) {
					int correct = 0;
					int result = 0;
					
					for(int j=0;j<8;j++) {
						result += password[j];
					}
					correct = ((password[7]+password[5]+password[3]+password[1])*3)+(password[0] + password[2] +password[4] +password[6]);
					if(correct%10==0) {
						answer = result;
					}
				} 
			}
			System.out.println("#"+tc+" "+answer);
		}
		
	}
}
