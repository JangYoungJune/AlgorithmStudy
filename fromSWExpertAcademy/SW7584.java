package fromSWExpertAcademy;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SW7584{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		for(int i=1;i<=T;i++) {
			long K = Long.parseLong(br.readLine());
			while(K%2l==0l) {
				K = K / 2l;
			}
			System.out.printf("#%d %d\n", i, (K%4l==3l)? 1 : 0);
		}
	}
}