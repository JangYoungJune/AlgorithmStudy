package fromBOJ;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class SW2628 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine().trim(), " ");
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		int c = Integer.parseInt(br.readLine().trim());
		List<Integer> cutN = new ArrayList<>();
		List<Integer> cutM = new ArrayList<>();
		for(int i=0;i<c;i++) {
			st = new StringTokenizer(br.readLine().trim(), " ");
			if(Integer.parseInt(st.nextToken())==0) {
				cutN.add(Integer.parseInt(st.nextToken()));
			} else {
				cutM.add(Integer.parseInt(st.nextToken()));
			}
		}
		cutN.add(0);
		cutN.add(N);
		cutM.add(0);
		cutM.add(M);
		Collections.sort(cutN);
		Collections.sort(cutM);
		int size = 0;
		for(int i=1;i<cutN.size();i++){
			for(int j=1;j<cutM.size();j++) {
				int n = cutN.get(i) - cutN.get(i-1);
				int m = cutM.get(j) - cutM.get(j-1);
				if(size<n*m) {
					size = n*m;
				}
			}
		}
		System.out.println(size);
	}
}
