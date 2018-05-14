package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class SkewBinary {

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		System.out.println((int)'2');
		for (String line; !(line=in.readLine().trim()).equals("0"); ) {
			int res = 0;
			int skew = 2;
			for (int i = line.length()-1; i>=0; i--) {
				res+=(line.charAt(i)-'0')*(skew-1);
				skew*=2;
			}
			out.println(res);
		}

		out.close();
		in.close();
	}

}
