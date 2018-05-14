package ProblemsIn_Java.Uri;

import java.io.PrintWriter;
import java.util.Scanner;

public class EvenOrOdd {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		int caso = in.nextInt();
		while (caso-- > 0) {
			int n = in.nextInt();
			if (n == 0) {
				out.println("NULL");
			} else if (n % 2 == 0) {
				if (n > 0) {
					out.println("EVEN POSITIVE");
				} else
					out.println("EVEN NEGATIVE");
			} else {
				if (n > 0) {
					out.println("ODD POSITIVE");
				} else
					out.println("ODD NEGATIVE");
			}
		}

		out.close();
		in.close();
	}
}
