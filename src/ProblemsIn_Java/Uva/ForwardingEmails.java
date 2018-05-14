package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ForwardingEmails {
	static int[] ady;
	static boolean visited[];
	static int sum[];

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer st;

		int casos = Integer.parseInt(in.readLine().trim());
		for (int caso = 1; caso <= casos; caso++) {
			int nodos = Integer.parseInt(in.readLine().trim());
			ady = new int[nodos];
			sum = new int[nodos];
			visited = new boolean[nodos];
			Arrays.fill(ady, -1);
			Arrays.fill(sum, -1);
			for (int i = 0; i < nodos; i++) {
				st = new StringTokenizer(in.readLine());
				ady[Integer.parseInt(st.nextToken()) - 1] = Integer.parseInt(st.nextToken()) - 1;
			}
			for (int i = 0; i < nodos; i++) {
				if (sum[i] == -1) {
					dfs(i);
				}
			}
			int max = -1, index = -1;
			for (int i = 0; i < nodos; i++) {
				if (sum[i] > max) {
					max = sum[i];
					index = i;
				}
			}
			out.printf("Case %d: %d%n", caso, index + 1);
		}

		out.close();
		in.close();
	}

	private static int dfs(int i) {
		visited[i] = true;
		int tot = 0;
		if (!visited[ady[i]] && ady[i] != -1) {
			tot += 1 + dfs(ady[i]);
		}
		visited[i] = false;
		return sum[i] = tot;
	}
}
