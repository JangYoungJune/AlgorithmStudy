package fromSWExpertAcademy;

import java.util.Scanner;

public class SW1289 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cycle_num = Integer.parseInt(sc.nextLine());
		for (int cycle = 1; cycle <= cycle_num; cycle++) {
			int answer = 0;
			StringBuilder mem = new StringBuilder(sc.nextLine().trim());
			while (mem.indexOf("1") >= 0) {
				int one_idx = mem.indexOf("1");
				for (int i = one_idx; i < mem.length(); i++) {
					mem.setCharAt(i, mem.charAt(i) == '1' ? '0' : '1');
				}
				answer++;
			}
			System.out.println("#" + cycle + " " + answer);
		}
		sc.close();
	}
}