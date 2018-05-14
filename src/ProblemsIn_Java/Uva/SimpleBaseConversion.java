package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class SimpleBaseConversion {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		while (true) {
			String a = in.readLine().trim();
			if (a.charAt(0)=='-')
				break;
			if (a.length() > 2 && a.charAt(1) == 'x') {
				String aux = "";
				for (int j = 2; j < a.length(); aux += a.charAt(j), j++)
					;
				String b = Integer.toString(Integer.parseInt("" + aux, 16), 10);
				out.println(b);
			} else {
				String b = Integer.toHexString(Integer.parseInt(a));
				out.println("0x" + b.toUpperCase());
			}

		}
		out.close();
		in.close();
	}
}
