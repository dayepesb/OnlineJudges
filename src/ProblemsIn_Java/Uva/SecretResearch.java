package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class SecretResearch {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		String line = "";
		int noOfCases = Integer.parseInt(in.readLine());
		for (int i = 0; i < noOfCases; i++) {
			line = (in.readLine());
			if (line.equals("1") || line.equals("4") || line.equals("78"))
				out.println("+");
			else if (line.endsWith("35"))
				out.println("-");
			else if (line.startsWith("9") && line.endsWith("4"))
				out.println("*");
			else if (line.startsWith("190"))
				out.println("?");
		}

		out.close();
		in.close();
	}
}