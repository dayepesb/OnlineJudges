package ProblemsIn_Java.Uri;

import java.util.Scanner;

public class SumaDeN�merosConsecutivosImparesI {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int X, Y, total = 0;
		X = in.nextInt();
		Y = in.nextInt();

		if (X > Y) {
			for (int i = X - 1; i > Y; i--) {
				if (i % 2 != 0) {
					total += i;
				}
			}
		} else {
			for (int i = Y - 1; i > X; i--) {
				if (i % 2 != 0) {
					total += i;
				}
			}
		}

		System.out.print(total + "\n");

		in.close();
	}
}
