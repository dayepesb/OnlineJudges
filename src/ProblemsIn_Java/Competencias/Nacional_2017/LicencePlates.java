package ProblemsIn_Java.Competencias.Nacional_2017;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;

public class LicencePlates {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		boolean[] lenguaje_1, lenguaje_2;
		String line;
		int t = Integer.parseInt(in.readLine().trim());
		while (t-- > 0) {
			line = in.readLine().trim();
			HashSet<String> set = new HashSet<>();
			lenguaje_1 = new boolean[26];
			for (int i = 0; i < line.length(); i++) {
				if (!lenguaje_1[line.charAt(i) - 'A']) {
					lenguaje_1[line.charAt(i) - 'A'] = true;
					for (int j = i+1; j < line.length(); j++) {
						lenguaje_2 = new boolean[26];
						if (!lenguaje_2[line.charAt(j) - 'A']) {
							lenguaje_2[line.charAt(j) - 'A'] = true;
							for (int k = j+1; k < line.length(); k++) {
								set.add(line.charAt(i) + "" + line.charAt(j) + "" + line.charAt(k));
							}
						}
					}
				}
			}
			out.println(set.size());
		}

		out.close();
		in.close();
	}
}
