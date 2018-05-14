package ProblemsIn_Java.Uri;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Remaining2 {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		out.println("2");
		int n = Integer.parseInt(in.readLine().trim())+2;
		int aux=n-2;
		for (;n<=10000; n+=aux) {
			out.println(n);
		}

		out.close();
		in.close();
	}
}
