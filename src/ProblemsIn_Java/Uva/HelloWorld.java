package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * @author david yepes buitrago
 * @date 10-09-2017
 * @time 0.060 ms
 */
public class HelloWorld {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		String s;
		int testCase = 1;

		while ((s = in.readLine()) != null && !s.startsWith("-"))
			out.println(
					"Case " + testCase++ + ": " + (int) Math.ceil(Math.log(Double.parseDouble(s)) / Math.log(2)));

		in.close();
		out.close();
	}
}
