package ProblemsIn_Java.Uri;

import java.io.PrintWriter;
import java.util.Scanner;

public class SixOddNumbers {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		int n = in.nextInt();
		int count = 0;
		while (count <= 5) {
			if (n % 2 == 1) {
				count++;
				out.printf("%d\n", n);
			}
			n++;
		}

		out.close();
		in.close();
	}
}
