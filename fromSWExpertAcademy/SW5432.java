package fromSWExpertAcademy;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SW5432 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testNum = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=testNum;tc++) {
			char[] woods = br.readLine().trim().toCharArray();
			int stack = 0;
			int answer = 0;
			for(int i=0;i<woods.length;i++) {
				if(woods[i]=='(' && woods[i+1]==')') {
					answer+=stack;
					i++;
				} else if(woods[i]=='(') {
					stack++;
				} else {
					answer++;
					stack--;
				}
			}
			System.out.printf("#%d %d\n",tc, answer);
		}
	}
}
