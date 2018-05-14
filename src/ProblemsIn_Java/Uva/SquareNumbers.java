package ProblemsIn_Java.Uva;

import java.util.Scanner;

public class SquareNumbers {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			for (int k = 1; k <= 201; k++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				if (a == 0 && b == 0)
					break;
				int cout = 0;
				if (a > 0 && a <= b && b <= 100000) {
					for (int i = a; i <= b; i++) {
						int st = (int) Math.sqrt(i);
						if (st * st == i) {
							cout++;
						}
					}
				}
				System.out.println(cout);
			}
		}
	}
}
