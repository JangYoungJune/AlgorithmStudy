package fromSWExpertAcademy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SW1266 {
	static int[] npSet = {0,1,4,6,8,9,10,12,14,15,16,18};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tcNum = Integer.parseInt(br.readLine().trim());
		for(int tc=1;tc<=tcNum;tc++) {
			String[] str = br.readLine().trim().split(" ");
			int x1 = Integer.parseInt(str[0]);
			int x2 = Integer.parseInt(str[1]);
			if((x1==100 && x2==100) || (x1==0 && x2==0)) {
				System.out.println("#"+tc+" 0.000000");
				continue;
			}
			double s1 = (double)x1/100.0;
			double f1 = 1.0-(double)s1;
			double s2 = (double)x2/100.0;
			double f2 = 1.0-(double)s2;
			
			double m1 = 0.0;
			double m2 = 0.0;
			for(int npNum : npSet) {
				m1 += comb(npNum)*Math.pow(s1, npNum)*Math.pow(f1, (18-npNum));
				m2 += comb(npNum)*Math.pow(s2, npNum)*Math.pow(f2, (18-npNum));
			}
			double result = 1.0 - m1*m2;
			System.out.printf("#%d %.6f\n", tc, result);
		}
		br.close();
	}
	public static double comb(int x) {
		double top = 1;
		double bot = 1;
		for(int i=18;i>18-x;i--) {
			top *= i;
		}
		for(int i=x;i>0;i--) {
			bot *= i;
		}
		return top/bot;
	}
}
