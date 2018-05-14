package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class VirtualFriends {
	static int conj[];

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		HashMap<String, Integer> ady;
		StringTokenizer st;
		int ind1;
		int casos = Integer.parseInt(in.readLine());
		for (int k = 0; k < casos; k++) {
			int nodos = Integer.parseInt(in.readLine().trim());
			conj = new int[2 * nodos];
			Arrays.fill(conj, -1);
			ady = new HashMap<>();
			ind1 = 0;
			for (int i = 0; i < nodos; i++) {
				st = new StringTokenizer(in.readLine());
				String x = st.nextToken();
				String y = st.nextToken();
				if (!ady.containsKey(x)) {
					ady.put(x, ind1);
					ind1++;
				}
				if (!ady.containsKey(y)) {
					ady.put(y, ind1);
					ind1++;
				}

				// nodo raiz de cada arbol del nodo
				int p = find(ady.get(x));
				int q = find(ady.get(y));

				if (p == q) {
					out.printf("%d\n", conj[p] * -1);
					continue;
				}
				// union del union find
				if (conj[p] < conj[q]) {
					conj[p] += conj[q];
					conj[q] = p;
					out.printf("%d\n", conj[p] * -1);
				} else {
					conj[q] += conj[p];
					conj[p] = q;
					out.printf("%d\n", conj[q] * -1);
				}
			}
		}

		out.close();
		in.close();
	}

	static int find(int n) {
		if (conj[n] < 0)
			return n;
		return conj[n] = find(conj[n]);
	}
}
