package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.math.BigInteger;

public class SquareRoot {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
		long casos = Long.parseLong(in.readLine().trim());
		for (long i = 0; i < casos; i++) {
			in.readLine();
			out.println(sqrt(new BigInteger(in.readLine().trim())));
			if(i<casos-1){
				out.println();
			}
		}
		out.close();
		in.close();
	}
	public static BigInteger sqrt(BigInteger n){
		for (BigInteger x=n,y;;x=y) {
			y=x.add(n.divide(x)).shiftRight(1);
			if(y.compareTo(x)>=0){
				return x;
			}
		}
	}

}
