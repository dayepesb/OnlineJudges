package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Scanner;

public class BigMod {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner in = new Scanner(br);
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
		BigInteger b,m,p;
		while (in.hasNext()) {
			
			b = in.nextBigInteger();
			p = in.nextBigInteger();
			m = in.nextBigInteger();

			out.println(b.modPow(p, m).toString());
		}
		out.close();
		in.close();
	}
}