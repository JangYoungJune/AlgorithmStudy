package fromBOJ;

import java.util.Scanner;

public class SW9498 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String ans = new String();
		switch(sc.nextInt()/10) {
		case 10:
		case 9:
			ans = "A";
			break;
		case 8:
			ans = "B";
			break;
		case 7:
			ans = "C";
			break;
		case 6:
			ans = "D";
			break;
		default:
			ans = "F";
			break;
		}
		System.out.println(ans);
	}
}
