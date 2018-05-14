package ProblemsIn_Java.Uri;

import java.io.PrintWriter;
import java.util.Scanner;

public class OddNumbers {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		int X = in.nextInt();
		out.print(1 + "\n");
		for (int i = 1; i < X - 1; i += 2) {
			int oddNumber = i + 2;
			out.print(oddNumber + "\n");
		}

		out.close();
		in.close();
	}
}
