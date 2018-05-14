package ProblemsIn_Java.Uva;
/**
 * @author david
 * Se puede hacer con uan estructura de datos union find o con un recorrido en dfs sobre el grafo que se arma
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class GraphConnectivity {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		int casos = Integer.parseInt(in.readLine().trim());
		int conjuntos[];
		in.readLine();
		for (int k = 0; k < casos; k++) {
			int tam = in.readLine().charAt(0) - 64;
			conjuntos = new int[tam];
			Arrays.fill(conjuntos, -1);
			for (String line; (line = in.readLine()) != null && !line.isEmpty();) {
				int a = line.charAt(0) - 65;
				int b = line.charAt(1) - 65;
				conjuntos = union(a, b, conjuntos);
			}
			int max = 0;
			for (int i : conjuntos) {
				if (i < 0)
					max++;
			}
			if (k == casos - 1) {
				out.println(max);
			} else
				out.println(max + "\n");
		}
		out.close();
		in.close();
	}

	static int[] union(int x, int y, int[] set) {
		x = find(x, set);
		y = find(y, set);

		if (x == y)
			return set;

		int sizex = -(set[x]);
		int sizey = -(set[y]);

		if (sizex < sizey) {
			set[y] = set[y] + set[x];
			set[x] = y;
		} else {
			set[x] = set[x] + set[y];
			set[y] = x;
		}

		return set;
	}

	static int find(int x, int[] set) {
		if (set[x] < 0)
			return x;
		else
			return set[x] = find(set[x], set);
	}
}
