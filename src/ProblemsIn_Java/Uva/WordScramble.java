package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class WordScramble {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		for (String line; (line = in.readLine()) != null;) {
			String palabra = "";
			StringTokenizer st = new StringTokenizer(line, " ");
			while (st.hasMoreTokens()) {
				String ci = "";
				String s1 = st.nextToken();
				for (int x = s1.length() - 1; x >= 0; x--) {
					ci = ci + s1.charAt(x);
				}
				palabra += " " + ci;
			}
			// System.out.println(palabra.trim());
			out.write(palabra.trim() + "\n");
		}

		in.close();
		out.close();
	}

}
