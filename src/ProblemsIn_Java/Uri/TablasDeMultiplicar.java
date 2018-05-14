package ProblemsIn_Java.Uri;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class TablasDeMultiplicar {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		int n = Integer.parseInt(in.readLine().trim());
		for (int i = 1; i <= 10; i++) {
			out.printf("%d x %d = %d%n",i,n,i*n );
		}

		out.close();
		in.close();
	}
}
