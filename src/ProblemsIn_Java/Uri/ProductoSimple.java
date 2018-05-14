package ProblemsIn_Java.Uri;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
public class ProductoSimple {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		for (String line;(line = in.readLine())!=null;) {
			int a = Integer.parseInt(line.trim());
			int b = Integer.parseInt(in.readLine().trim());
				out.println("PROD = "+(a*b));
		}

		out.close();
		in.close();
	}
}
