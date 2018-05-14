package ProblemsIn_Java.Uri;

import java.io.PrintWriter;
import java.util.Scanner;

public class EvenBetweenFiveNumbers {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		int X, even = 0;
		for (int i = 1; i <= 5; i++) {
			X = in.nextInt();
			if (X % 2 == 0)
				even++;
		}
		out.print(even + " valores pares\n");

		out.close();
		in.close();
	}

}