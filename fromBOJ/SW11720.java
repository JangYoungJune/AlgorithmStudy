package fromBOJ;

import java.util.Scanner;
import java.util.stream.IntStream;

public class SW11720 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc.nextInt();
		String words = sc.next();
		System.out.println(words.chars().map(x->x-'0').sum());
	}
}
