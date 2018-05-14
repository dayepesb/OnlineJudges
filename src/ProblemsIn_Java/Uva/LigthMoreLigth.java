package ProblemsIn_Java.Uva;

import java.util.Scanner;

public class LigthMoreLigth {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		long N = -1;
		while ((N = in.nextLong()) != 0) {
			long sq = (long) Math.floor(Math.sqrt(N));
			System.out.println((sq * sq == N) ? "yes" : "no");
		}
	}

}
