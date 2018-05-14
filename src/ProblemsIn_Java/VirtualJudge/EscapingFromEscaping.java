package ProblemsIn_Java.VirtualJudge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;

/**
 * @author david yepes buitrago
 * @date 01-08-2017
 * @time 0.840 ms
 */
public class EscapingFromEscaping {
	static long inf = (long) Math.pow(2, 100000);

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int t = Integer.parseInt(in.readLine().trim());
		for (int c = 0; c < t; c++) {
			StringBuilder sb = new StringBuilder(in.readLine().trim());
			int indice = 0;
			HashSet<String> digitos;
			do {
				digitos = new HashSet<String>();
				indice++;
				for (int j = 0; j + indice <= sb.length(); j++) {
					digitos.add(sb.substring(j, j + indice));
				}
			} while (digitos.size() == Math.pow(2, indice));

			out.println(indice);
		}

		in.close();
		out.close();
	}
}
