package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class DancingTheCheekyCheeky {

	public static void main(String[] args) throws IOException {
		BufferedReader tec = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int casos = Integer.parseInt(tec.readLine().trim());
		for (int caso = 0; caso < casos; caso++) {
			String line = tec.readLine();
			boolean cambio = false;
			for (int i = 1; i < line.length(); i++) {
				if (line.charAt(i) != line.charAt(i - 1)) {
					cambio = true;
					break;
				}
			}
			if (!cambio) {
				for (int i = 0; i < 8; i++)
					out.print(line.charAt(i % line.length()));
				out.println("...");
				continue;
			}
			int m = z(line);
			int x = line.length() - m * 2;
			String cad = line.substring(0, m);
			for (int i = x; i < x + 8; i++)
				out.print(cad.charAt(i % cad.length()));
			out.println("...");
		}
		out.close();
	}

	static int[] z;

	public static int z(String cad) {
		z = new int[cad.length()];
		int l = 0, r = 0, n = cad.length();
		int max = 0;
		int ind = 0;
		for (int i = 1; i < n; i++) {
			if (i > r) {
				l = r = i;
				while (r < n && cad.charAt(r - l) == cad.charAt(r))
					r++;
				z[i] = r - l;
				r--;
			} else {
				int k = i - l;
				if (z[k] < r - i + 1)
					z[i] = z[k];
				else {
					l = i;
					while (r < n && cad.charAt(r - l) == cad.charAt(r))
						r++;
					z[i] = r - l;
					r--;
				}
			}
			if (z[i] > max) {
				ind = i;
			}
			max = Math.max(max, z[i]);
		}
		return ind;
	}
}