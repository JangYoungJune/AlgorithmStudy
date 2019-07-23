package fromBOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SW11004 {
	static int N, O;
	static int[] temp;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		O = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		temp = new int[N];
		st = new StringTokenizer(br.readLine().trim());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		mergeSort(arr, 0, arr.length-1);
		bw.write(Integer.toString(arr[O-1]));
		bw.flush();
		bw.close();
	}
	public static void mergeSort(int[] arr, int l, int r) {
		if(l<r) {
			int mid = (l+r)/2;
			mergeSort(arr, l, mid);
			mergeSort(arr, mid+1, r);
			merge(arr, l , mid, r);
		}
	}
	public static void merge(int[] arr, int l, int mid, int r) {
		int i = l;
		int j = mid+1;
		int k = l;
		while(i<=mid && j<=r) {
			if(arr[i]<arr[j]) {
				temp[k++] = arr[i++];
			}else {
				temp[k++] = arr[j++];
			}
		}
		while(i<=mid) {
			temp[k++] = arr[i++];
		}
		while(j<=r) {
			temp[k++] = arr[j++];
		}
		for(int index=l; index<k;index++) {
			arr[index] = temp[index];
		}
	}
}
