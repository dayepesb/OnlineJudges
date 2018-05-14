package ProblemsIn_Java.Uri;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class HighestAndPosition {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		int a = -1, b = -1;
		for (int i = 1; i <= 100; i++) {
			int x = Integer.parseInt(in.readLine().trim());
			if (x > a) {
				a = x;
				b = i;
			}
		}
		out.println(a+"\n"+b);

		out.close();
		in.close();
	}
}
