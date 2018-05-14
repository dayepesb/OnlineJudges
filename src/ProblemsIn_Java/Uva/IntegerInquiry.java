package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.math.BigInteger;

public class IntegerInquiry {
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

		String line;
		BigInteger sum = BigInteger.ZERO;  
		for (;!(line=in.readLine().trim()).equals("0") ;) {
			sum = sum.add(new BigInteger(line));
		}
		out.println(sum);
		out.close();
		in.close();
	}
}
