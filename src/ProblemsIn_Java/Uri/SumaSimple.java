package ProblemsIn_Java.Uri;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class SumaSimple {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		for (String line; (line=in.readLine())!=null;) {
			long r = Long.parseLong(line.trim())+Long.parseLong(in.readLine().trim());
			out.println("SOMA = "+r);
		}

		out.close();
		in.close();
	}

}
