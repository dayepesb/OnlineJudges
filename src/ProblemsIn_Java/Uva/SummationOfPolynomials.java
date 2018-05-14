package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;

/**
 * @author	david yepes buitrago
 * @date	10-09-2017
 * @time	0.060 ms
 */
public class SummationOfPolynomials {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		for (String line; (line = in.readLine()) != null;) {
			BigInteger bi = new BigInteger(line.trim());
			bi = bi.multiply(bi.add(BigInteger.ONE)).divide(BigInteger.valueOf(2));
			out.println((bi).multiply(bi));
		}

		in.close();
		out.close();
	}
}
