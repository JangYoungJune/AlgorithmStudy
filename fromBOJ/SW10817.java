package fromBOJ;

import java.util.Scanner;

public class SW10817 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int ans = 0;
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		int num3 = sc.nextInt();

		int com1 = (num1 > num2) ? num1 : num2;
		int com2 = (num2 > num3) ? num2 : num3;
		int com3 = (num3 > num1) ? num3 : num1;
		
		if(com1==com2 && com2==com3) {
			ans = com1;
		} else if(com1==com2) {
			ans = com3;
		} else if(com2==com3) {
			ans = com1;
		} else {
			ans = com2;
		}
		
		System.out.println(ans);
		sc.close();
	}
}
