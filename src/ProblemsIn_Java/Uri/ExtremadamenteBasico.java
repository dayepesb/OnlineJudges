package ProblemsIn_Java.Uri;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class ExtremadamenteBasico {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		int a = Integer.parseInt(in.readLine()),b = Integer.parseInt(in.readLine());
		out.printf("X = %d%n",(a+b));

		out.close();
		in.close();
	}

}
