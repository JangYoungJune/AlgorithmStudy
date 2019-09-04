package fromBOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW14890 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine().trim()," ");
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][N];
		int answer = 0;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine().trim()," ");
			for(int j=0;j<N;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0;i<N;i++) {
			int combo = 0;
			int slope = 0;
			int pre = 0;
			boolean canPass = true;
			for(int j=0;j<N;j++) {
				if(pre==0) { // 맨처음
					pre = arr[i][j];
					combo++;
					continue;
				}
				if(arr[i][j]==pre) { // 이전값이랑 같음
					combo++;
					continue;
				}
				if(Math.abs(arr[i][j]-pre)!=1) { // 경사를 못만듬
					canPass = false;
					break;
				} 
				 // 경사를 만들 수 있음
				int nowSlope = (arr[i][j]>pre)? 1 : -1;
				if(slope==0 && nowSlope==1) { // 없었다가 올라감
					if(combo<L) {
						canPass = false;
						break;
					}
					pre = arr[i][j];
					slope = nowSlope;
					combo = 1;
				} else if(slope==0 && nowSlope==-1) { // 없었다가 내려감
					slope = nowSlope;
					pre = arr[i][j];
					combo = 1;
				} else if(slope==nowSlope) { // 계속 내려감 / 올라감
					if(combo<L) {
						canPass = false;
						break;
					}
					pre = arr[i][j];
					combo = 1;
				} else { 
					if(nowSlope==1) { // 내렸다 올라감
						if(combo<L*2) {
							canPass = false;
							break;
						}
						pre = arr[i][j];
						slope = nowSlope;
						combo = 1;
					} else { // 올랐다 내려감
						pre = arr[i][j];
						slope = nowSlope;
						combo = 1;
					}
				}
			}
			if(slope==-1 && combo<L) {
				canPass = false;
			}
			if(canPass) {
				answer++;
			}
			
			combo = 0;
			slope = 0;
			pre = 0;
			canPass = true;
			for(int j=0;j<N;j++) {
				if(pre==0) { // 맨처음
					pre = arr[j][i];
					combo++;
					continue;
				}
				if(arr[j][i]==pre) { // 이전값이랑 같음
					combo++;
					continue;
				}
				if(Math.abs(arr[j][i]-pre)!=1) { // 경사를 못만듬
					canPass = false;
					break;
				} 
				 // 경사를 만들 수 있음
				int nowSlope = (arr[j][i]>pre)? 1 : -1;
				if(slope==0 && nowSlope==1) { // 없었다가 올라감
					if(combo<L) {
						canPass = false;
						break;
					}
					pre = arr[j][i];
					slope = nowSlope;
					combo = 1;
				} else if(slope==0 && nowSlope==-1) { // 없었다가 내려감
					slope = nowSlope;
					pre = arr[j][i];
					combo = 1;
				} else if(slope==nowSlope) { // 계속 내려감 / 올라감
					if(combo<L) {
						canPass = false;
						break;
					}
					pre = arr[j][i];
					combo = 1;
				} else { 
					if(nowSlope==1) { // 내렸다 올라감
						if(combo<L*2) {
							canPass = false;
							break;
						}
						pre = arr[j][i];
						slope = nowSlope;
						combo = 1;
					} else { // 올랐다 내려감
						pre = arr[j][i];
						slope = nowSlope;
						combo = 1;
					}
				}
			}
			if(slope==-1 && combo<L) {
				canPass = false;
			}
			if(canPass) {
				answer++;
			}
		}
		System.out.println(answer);
	}
}
