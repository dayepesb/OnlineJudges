package ProblemsIn_Java.Uva;

import static java.math.BigInteger.TEN;
import static java.math.BigInteger.ZERO;
import static java.math.BigInteger.valueOf;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;

public class MultipleOf17 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		BigInteger n, d17;
		StringBuffer sb = new StringBuffer();
		d17 = TEN.add(valueOf(7));
		while (true) {
			n = new BigInteger(in.readLine().trim());
			if (n.equals(ZERO))
				break;
			if (n.mod(d17) == ZERO)
				out.println(1);
			else
				out.println(0);
		}
		out.close();
	}

}