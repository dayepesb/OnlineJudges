package ProblemsIn_Java.VirtualJudge;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * @author david yepes buitrago
 * @date 02-08-2017
 * @time 0.086 ms
 */
public class RangeProduct {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		StringTokenizer st;
		int a, b;
		for (String line; (line = in.readLine()) != null;) {
			st = new StringTokenizer(line);

			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());

			if ((a < 0 && b > 0) || (a == 0 || b == 0)) {
				out.println("Zero");
			} else if ((a > 0 && b > 0) || (Math.abs(Math.abs(b) + Math.abs(a)) % 2 != 0)) {
				out.println("Positive");
			} else {
				out.println("Negative");
			}

		}

		out.close();
		in.close();
	}
}
