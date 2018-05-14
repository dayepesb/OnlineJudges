package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class IdCodes {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		String line;
		while ((line = in.readLine()) != null) {
			if (line.equals("#")) {
				break;
			}
			boolean ada = false;
			int[] arr = new int[line.length()];
			for (int i = 0; i < line.length(); i++) {
				arr[i] = line.charAt(i) - 'a';
			}
			while (nextPermutation(arr)) {
				ada = true;
				for (int i = 0; i < arr.length; i++) {
					System.out.print((char) (arr[i] + 'a'));
				}
				System.out.println();
				break;
			}
			if (!ada) {
				out.println("No Successor");
			}
		}

		in.close();
		out.close();
	}

	static boolean nextPermutation(int[] p) {
		for (int a = p.length - 2; a >= 0; --a) {
			if (p[a] < p[a + 1]) {
				for (int b = p.length - 1;; --b) {
					if (p[b] > p[a]) {
						int t = p[a];
						p[a] = p[b];
						p[b] = t;
						for (++a, b = p.length - 1; a < b; ++a, --b) {
							t = p[a];
							p[a] = p[b];
							p[b] = t;
						}
						return true;
					}
				}
			}
		}
		return false;
	}
}