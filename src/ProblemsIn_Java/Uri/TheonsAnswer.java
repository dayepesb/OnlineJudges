package ProblemsIn_Java.Uri;

import java.util.Scanner;

public class TheonsAnswer {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int a, b, c, d = 0, e = 1;
		a = in.nextInt();
		int ara[] = new int[a];
		for (b = 0; b < a; b++)
			ara[b] = in.nextInt();
		c = ara[d];
		for (d = 0; d < a; d++) {
			if (ara[d] < c) {
				c = ara[d];
				e = d + 1;
			}

		}
		System.out.printf("%d\n", e);
		in.close();
	}

}
