package ProblemsIn_Java.Uri;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.TreeSet;

public class ColeccionDePokemons {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		TreeSet<String> ts = new TreeSet<>();
		int n = Integer.parseInt(in.readLine().trim());
		for (int i = 0; i < n; i++) {
			ts.add(in.readLine().trim().toLowerCase());
		}
		out.printf("Falta(m) %d pomekon(s).",151-ts.size());

		out.close();
		in.close();
	}
}
