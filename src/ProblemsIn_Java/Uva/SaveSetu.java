package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class SaveSetu {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		int testCase = Integer.parseInt(in.readLine().trim());
		String input;
		int totalAmount = 0;
		int inputAmount;

		while (testCase-- > 0) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			input = st.nextToken().toLowerCase();

			if (input.equals("donate")) {
				totalAmount += Integer.parseInt(st.nextToken());
			} else {
				out.printf("%d\n", totalAmount);
			}
		}

		out.close();
		in.close();
	}
}
