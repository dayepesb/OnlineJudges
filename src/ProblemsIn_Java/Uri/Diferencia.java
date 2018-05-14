package ProblemsIn_Java.Uri;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Diferencia {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		int a = Integer.parseInt(in.readLine()), b = Integer.parseInt(in.readLine()),
				c = Integer.parseInt(in.readLine()), d = Integer.parseInt(in.readLine());
		out.printf("DIFERENCA = %d%n", (a*b-c*d));

		out.close();
		in.close();
	}

}
