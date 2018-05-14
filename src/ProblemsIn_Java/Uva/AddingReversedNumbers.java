package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class AddingReversedNumbers {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

		StringBuffer n1,n2,nres;
		BigInteger b1,b2,br;
		StringTokenizer st;
		int casos = Integer.parseInt(in.readLine());

		for (int i = 0; i < casos; i++) {
			st = new StringTokenizer(in.readLine());
			n1 = new StringBuffer(st.nextToken());
			n2 = new StringBuffer(st.nextToken());
			n1 = n1.reverse();
			n2=n2.reverse();
			b1 = new BigInteger(n1.toString());
			b2 = new BigInteger(n2.toString());
			br = b1.add(b2);
			nres = new StringBuffer(br.toString());
			out.println(new BigInteger(nres.reverse().toString()).toString().trim());
		}
		
		out.close();
		in.close();
	}

}
