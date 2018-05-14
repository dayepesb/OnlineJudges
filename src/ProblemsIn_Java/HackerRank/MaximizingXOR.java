package ProblemsIn_Java.HackerRank;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class MaximizingXOR {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		int l = Integer.parseInt(in.readLine());
		int r = Integer.parseInt(in.readLine());
		int max = Integer.MIN_VALUE;
		for (int i = l; i <= r; i++) {
			for (int j = l; j <= r; j++) {
				max = Math.max(max, (i^j));
			}
		}
		out.println(max);

		out.close();
		in.close();
	}
}
