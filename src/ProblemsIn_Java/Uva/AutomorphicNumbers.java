package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.math.BigInteger;

public class AutomorphicNumbers {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

		for (String line; (line = in.readLine()) != null;) {
			BigInteger a = new BigInteger(line);
			BigInteger b = a.multiply(a);
			if (b.toString().endsWith(a.toString()) && !a.equals(BigInteger.ZERO) && !a.equals(BigInteger.ONE)) {
				out.println("Automorphic number of " + line.toString().length() + "-digit.");
			} else {
				out.println("Not an Automorphic number.");
			}
		}

		out.close();
		in.readLine();
	}

}
