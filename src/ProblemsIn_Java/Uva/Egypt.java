package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Egypt {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		while (true) {
			String line = in.readLine().trim();
			if (line.equals("0 0 0"))
				break;
			StringTokenizer st = new StringTokenizer(line);
			int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken()),
					c = Integer.parseInt(st.nextToken()), A, B, C;
			A = (b * b + c * c - a * a);
			B = (a * a + c * c - b * b);
			C = (a * a + b * b - c * c);
			if (A == 0 || B == 0 || C == 0) {
				out.println("right");
			} else {
				out.println("wrong");
			}
		}

		out.close();
		in.close();
	}
}
