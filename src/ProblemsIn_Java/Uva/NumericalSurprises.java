package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;

public class NumericalSurprises {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		int casos = Integer.parseInt(in.readLine());
		for (int i = 0; i < casos; i++) {
			BigInteger a = new BigInteger(in.readLine()),b=new BigInteger(in.readLine());
			out.println(b.mod(a));
		}

		out.close();
		in.close();
	}
}
