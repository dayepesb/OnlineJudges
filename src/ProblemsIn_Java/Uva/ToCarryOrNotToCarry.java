package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ToCarryOrNotToCarry {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

		for (String line; (line = in.readLine()) != null;) {
			StringTokenizer st = new StringTokenizer(line.trim());
			long a = Long.parseLong(st.nextToken());
			long b = Long.parseLong(st.nextToken());
			out.println(a ^ b);
		}

		out.close();
		in.close();
	}

}
