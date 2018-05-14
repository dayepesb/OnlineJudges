package ProblemsIn_Java.CodeForces;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class ShellGame {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int n, m;
		for (String line = in.readLine(); line != null; line = in.readLine()) {
			n = Integer.parseInt(line.trim());
			m = Integer.parseInt(in.readLine().trim());
			if (n % 2 == 0) {
				int k = n / 2;
				if (k % 3 == 0) {
					if (m == 0)
						out.printf("0\n");
					else if (m == 1)
						out.printf("1\n");
					else if (m == 2)
						out.printf("2\n");
				} else if (k % 3 == 1) {
					if (m == 2)
						out.printf("0\n");
					else if (m == 0)
						out.printf("1\n");

					else if (m == 1)
						out.printf("2\n");
				} else if (k % 3 == 2) {
					if (m == 1)
						out.printf("0\n");
					else if (m == 2)
						out.printf("1\n");
					else if (m == 0)
						out.printf("2\n");
				}
			} else {
				int t = (n + 1) / 2;
				if (t % 3 == 0) {
					if (m == 0)
						out.printf("0\n");
					else if (m == 2)
						out.printf("1\n");
					else if (m == 1)
						out.printf("2\n");
				} else if (t % 3 == 1) {
					if (m == 1)
						out.printf("0\n");
					else if (m == 0)
						out.printf("1\n");
					else if (m == 2)
						out.printf("2\n");
				} else if (t % 3 == 2) {
					if (m == 2)
						out.printf("0\n");
					else if (m == 1)
						out.printf("1\n");
					else if (m == 0)
						out.printf("2\n");
				}
			}
		}
		out.close();
		in.close();
	}
}
