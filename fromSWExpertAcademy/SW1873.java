package fromSWExpertAcademy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SW1873 {
	static int N, M;
	static char[][] map;
	static int tx, ty, tdir;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tcNum = Integer.parseInt(br.readLine().trim());
		for(int tc=1;tc<=tcNum;tc++) {
			String[] str = br.readLine().trim().split(" ");
			N = Integer.parseInt(str[0]);
			M = Integer.parseInt(str[1]);
			map = new char[N][M];
			for(int i=0;i<N;i++) {
				char[] ch = br.readLine().trim().toCharArray();
				for(int j=0;j<M;j++) {
					if(ch[j]=='^' || ch[j]=='v' || ch[j]=='<' || ch[j]=='>') {
						map[i][j] = '.';
						tx = i;
						ty = j;
						tdir = (ch[j]=='^')? 0 : ((ch[j]=='v')? 1: ((ch[j]=='<')? 2: 3));
					} else {
						map[i][j] = ch[j];
					}
				}
			}
			int inputNum = Integer.parseInt(br.readLine().trim());
			char[] input = br.readLine().trim().toCharArray();
			for(int in=0;in<inputNum;in++) {
				switch(input[in]) {
				case 'U':
					tdir = 0;
					if(tx-1>=0 && map[tx-1][ty]=='.') {
						tx--;
					}
					break;
				case 'D':
					tdir = 1;
					if(tx+1<N && map[tx+1][ty]=='.') {
						tx++;
					}
					break;
				case 'L':
					tdir = 2;
					if(ty-1>=0 && map[tx][ty-1]=='.') {
						ty--;
					}
					break;
				case 'R':
					tdir = 3;
					if(ty+1<M && map[tx][ty+1]=='.') {
						ty++;
					}
					break;
				case 'S':
					if(tdir==0) {
						for(int i=tx-1;i>=0;i--) {
							if(map[i][ty]=='.' || map[i][ty]=='-') {
								continue;
							} else if(map[i][ty]=='#'){
								break;
							} else {
								map[i][ty] = '.';
								break;
							}
						}
					} else if(tdir==1) {
						for(int i=tx+1;i<N;i++) {
							if(map[i][ty]=='.' || map[i][ty]=='-') {
								continue;
							} else if(map[i][ty]=='#'){
								break;
							} else {
								map[i][ty] = '.';
								break;
							}
						}
					} else if(tdir==2) {
						for(int i=ty-1;i>=0;i--) {
							if(map[tx][i]=='.' || map[tx][i]=='-') {
								continue;
							} else if(map[tx][i]=='#'){
								break;
							} else {
								map[tx][i] = '.';
								break;
							}
						}
					} else {
						for(int i=ty+1;i<M;i++) {
							if(map[tx][i]=='.' || map[tx][i]=='-') {
								continue;
							} else if(map[tx][i]=='#'){
								break;
							} else {
								map[tx][i] = '.';
								break;
							}
						}
					}
					break;
				}
			}
			if(tdir==0) {
				map[tx][ty] = '^';
			} else if(tdir==1) {
				map[tx][ty] = 'v';
			} else if(tdir==2) {
				map[tx][ty] = '<';
			} else {
				map[tx][ty] = '>';
			}
			
			System.out.print("#"+tc+" ");
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
		}
	}
}
