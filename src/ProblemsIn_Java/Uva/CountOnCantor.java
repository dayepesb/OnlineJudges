package ProblemsIn_Java.Uva;

import java.util.Scanner;

public class CountOnCantor {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		while (in.hasNext()) {
			int N = in.nextInt(), index = N, diagonal = 0;

			for (diagonal = 1; index > diagonal; diagonal++)
				index -= diagonal;

			int u = diagonal % 2 == 0 ? index : diagonal - index + 1;
			int d = diagonal - u + 1;

			System.out.printf("TERM %d IS %d/%d%n", N, u, d);
		}
	}
}