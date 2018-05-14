package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class JumpingMario {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int cases = Integer.parseInt(in.readLine().trim());
		StringTokenizer st;
		for (int i = 1; i <= cases; i++) {
			int muros = Integer.parseInt(in.readLine());
			int grandes = 0, peque = 0;
			st = new StringTokenizer(in.readLine());
			int actual = Integer.parseInt(st.nextToken()), siguiente;
			while (st.hasMoreTokens()) {
				siguiente = Integer.parseInt(st.nextToken());
				if (siguiente > actual) {
					grandes++;
				} else if (siguiente < actual) {
					peque++;
				}
				actual = siguiente;
			}
			out.printf("Case %d: %d %d%n", i, grandes, peque);
		}

		out.close();
		in.close();
	}
}
