package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class RomeoAndJulietSecrets {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		int k;
		int t = Integer.parseInt(in.readLine().trim());
		while (t-- > 0) {
			StringBuilder sb1 = new StringBuilder(in.readLine().trim());
			StringBuilder sb2 = new StringBuilder(in.readLine().trim());
			k = Integer.parseInt(in.readLine().trim());
			int z1[] = z(sb2.length() + 1, sb2.toString() + "$" + sb1.toString());
			int z3[] = z(sb2.length() + 1, sb2.reverse().toString() + "$" + sb1.reverse().toString());
			int z2[] = new int[z3.length];
			for (int i = 0, j = z3.length - 1; i < z3.length; i++, j--) {
				z2[i] = z3[j];
			}
			System.out.println(Arrays.toString(z1));
			System.out.println(Arrays.toString(z2));
			int s = z1.length, cont = 0;
			int l = sb2.length();
			k = l - k;
			for (int i = 0; i <= s - l; i++) {
				if ((z1[i] + z2[i + l - 1]) >= k) {
					cont++;
				}
			}
			out.println(cont);
		}

		out.close();
		in.close();
	}

	public static int[] z(int f, String cad) {

		int[] z = new int[cad.length()];
		int l = 0, r = 0, n = cad.length();
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
		}
		return Arrays.copyOfRange(z, f, z.length);
	}

}
