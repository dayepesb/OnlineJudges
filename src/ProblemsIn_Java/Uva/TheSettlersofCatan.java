package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class TheSettlersofCatan {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

		int mAdy[][];
		boolean visit[][];
		StringTokenizer st;

		Ciclo: while (true) {
			st = new StringTokenizer(in.readLine().trim(), " ");
			int nodos = Integer.parseInt(st.nextToken());
			int arcos = Integer.parseInt(st.nextToken());
			if (nodos == 0 && arcos == 0) {
				break Ciclo;
			} else {
				mAdy = new int[nodos][nodos];
				visit = new boolean[nodos][nodos];
				for (int i = 0; i < arcos; i++) {
					st = new StringTokenizer(in.readLine());
					int nodo1 = Integer.parseInt(st.nextToken());
					int nodo2 = Integer.parseInt(st.nextToken());
					mAdy[nodo1][nodo2] = mAdy[nodo2][nodo1] = 1;
				}
				int res = 0;
				for (int i = 0; i < nodos; i++) {
					res = Math.max(res, dfs(mAdy, visit, i));
				}

				out.println(res);
			}
		}
		out.close();
		in.close();
	}

	public static int dfs(int mAdy[][], boolean visit[][], int nodo) {
		int max = 0;
		for (int i = 0; i < visit.length; i++) {
			if (mAdy[nodo][i] > 0 && !visit[nodo][i]) {
				visit[nodo][i] = visit[i][nodo] = true;
				max = Math.max(max, dfs(mAdy, visit, i) + 1);
				visit[nodo][i] = visit[i][nodo] = false;
			}
		}
		return max;
	}
}
