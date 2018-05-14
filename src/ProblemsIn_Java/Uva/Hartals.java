package ProblemsIn_Java.Uva;

import java.util.Scanner;

public class Hartals {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);

		int cases = s.nextInt();

		for (int case1 = 0; case1 < cases; case1++) {

			int days = s.nextInt();
			int[] hartals = new int[s.nextInt()];

			for (int i = 0; i < hartals.length; i++) {
				hartals[i] = s.nextInt();
			}

			int numberOfDays = 0;

			for (int i = 1; i <= days; i++) {
				if ((i % 7) != 6 && (i % 7) != 0) { // fredag eller s�ndag

					for (int j = 0; j < hartals.length; j++) {
						if (i % hartals[j] == 0) {
							numberOfDays++;
							break; // slutt n�r en er funnet
						}
					}

				}
			}

			System.out.println(numberOfDays);
		}
	}
}