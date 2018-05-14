package ProblemsIn_Java.Uri;

import java.util.Scanner;

public class EvenSquare {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		for (int i = 1; i <= n; ++i) {
			if (i % 2 == 0) {
				System.out.printf("%d^2 = %d\n", i, (i * i));
			}
		}

		in.close();
	}

}
