package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;

public class SimplyEmirp {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		String line;
		while ((line = in.readLine()) != null) {
			int a = Integer.parseInt(line.trim());
			BigInteger first = BigInteger.valueOf(a);
			String temp = first.toString();
			StringBuffer tempBuffer = new StringBuffer(temp);
			tempBuffer = tempBuffer.reverse();
			temp = tempBuffer.toString();
			int b = Integer.parseInt(temp);
			BigInteger second = new BigInteger(temp);
			out.printf("%d is ", a);
			if (!first.isProbablePrime(10)) {
				out.println("not prime.");
			} else if ((a != b) && (second.isProbablePrime(10))) {
				out.println("emirp.");
			} else {
				out.println("prime.");
			}
		}
		out.close();
		in.close();
	}
}