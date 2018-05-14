package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Batman {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

		StringTokenizer st;
		HashMap<String, Integer> poderesNombre;
		int poder[], costoPoder[], vidaVillano[], dp[][];
		boolean matarVillano[][];

		int P, V, E;
		String line;
		while (!(line = in.readLine()).equals("0 0 0")) {
			st = new StringTokenizer(line);
			P = Integer.parseInt(st.nextToken());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());

			poderesNombre = new HashMap<>();
			poder = new int[P + 1];
			costoPoder = new int[P + 1];
			vidaVillano = new int[P + 1];
			matarVillano = new boolean[V + 1][P + 1];
			dp = new int[V + 1][P + 1];

			for (int i = 1; i <= P; ++i) {
				st = new StringTokenizer(in.readLine());
				String name = st.nextToken();
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				poderesNombre.put(name, i);
				poder[i] = a;
				costoPoder[i] = b;
			}

			for (int i = 1; i <= V; ++i) {
				st = new StringTokenizer(in.readLine());
				st.nextToken();
				vidaVillano[i] = Integer.parseInt(st.nextToken());
				;
				String c[] = st.nextToken().split(",");
				for (int j = 0; j < c.length; j++) {
					int y = poderesNombre.get(c[j]);
					matarVillano[i][y] = true;
				}
			}
			for (int i = 0; i <= P;dp[0][i] = 0, i++);
			for (int i = 1; i <= V;dp[i][0] = E + 1, i++);

			for (int i = 1; i <= V; ++i) {
				for (int j = 1; j <= P; ++j) {
					dp[i][j] = dp[i][j - 1];
					if (matarVillano[i][j] && poder[j] >= vidaVillano[i]) {
						dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1] + costoPoder[j]);
					}
				}
			}

			if (dp[V][P] <= E)
				out.println("Yes");
			else
				out.println("No");

		}

		out.close();
	}
}
