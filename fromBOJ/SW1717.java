package fromBOJ;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW1717 {
	static int[] arr;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		arr = new int[N+1];
		for(int i=0;i<N+1;i++) {
			arr[i] = i;
		}
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine().trim()," ");
			int notify = Integer.parseInt(st.nextToken());
			int val1 = Integer.parseInt(st.nextToken());
			int val2 = Integer.parseInt(st.nextToken());
			if(val1>val2) {
				int temp = val1;
				val1 = val2;
				val2 = temp;
			}
			if(notify==0) {
				enrollParent(val2, val1);
			} else {
				System.out.println(checkParent(val1)==checkParent(val2)? "YES" : "NO");
			}
		}
		
	}
	public static void enrollParent(int nodeNum, int dest) {
		while(arr[nodeNum]!=dest && arr[nodeNum]!=nodeNum) {
			if(dest>arr[nodeNum]) {
				int temp = dest;
				dest = arr[nodeNum];
				nodeNum = temp;  
			} else {
				nodeNum = arr[nodeNum];
			}
		}
		if(arr[nodeNum]==nodeNum) {
			arr[nodeNum] = dest;
		}
	}
	
	public static int checkParent(int nodeNum) {
		while(arr[nodeNum]!=nodeNum) {
			nodeNum = arr[nodeNum];
		}
		return nodeNum;
	}
}
