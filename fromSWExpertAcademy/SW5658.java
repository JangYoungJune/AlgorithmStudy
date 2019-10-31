package fromSWExpertAcademy;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class SW5658 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tcNum = Integer.parseInt(br.readLine().trim());
		for(int tc=1;tc<=tcNum;tc++) {
			String[] strArr = br.readLine().trim().split(" ");
			int N = Integer.parseInt(strArr[0]);
			int M = Integer.parseInt(strArr[1]);
			int size = N/4;
			String str = br.readLine().trim();
			Set<Integer> valueSet = new HashSet<>();
			for(int i=0;i<size;i++) {
				for(int j=0;j<4;j++) {
					String temp = str.substring(j*size, j*size+size);
					valueSet.add(Integer.valueOf(temp, 16));
				}
				str = str.substring(N-1) + str.substring(0,N-1);
			}
			System.out.println("#"+tc+" "+valueSet.stream().sorted((o1,o2)->o2-o1).limit(M).skip(M-1).findFirst().get());
		}
	}
}
