package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Dominator {

	static boolean[][] dominate;
	static boolean[] canReach;
	static boolean[] isVisited;
	static boolean mAdy[][], first;
	static int tam;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		StringTokenizer st;
		int cases = Integer.parseInt(in.readLine().trim());
		for (int k = 1; k <= cases; k++) {
			tam = Integer.parseInt(in.readLine().trim());
			mAdy = new boolean[tam][tam];
			for (int i = 0; i < tam; i++) {
				String line = in.readLine();
				st = new StringTokenizer(line);
				for (int j = 0; j < tam; j++) {
					mAdy[i][j] = Integer.parseInt(st.nextToken()) == 1;
				}
			}

			dominate = new boolean[tam][tam];
			canReach = new boolean[tam];
			isVisited = new boolean[tam];
			;

			String separador = "+";
			for (int i = 0; i < (2 * tam - 1); separador += "-", i++);
			separador += "+";
			separador += "\n";

			out.printf("Case %d:%n", k);
			out.print(separador);

			boolean[][] dominateRes = solve();

			for (int i = 0; i < tam; i++) {
				out.print("|");
				for (int j = 0; j < tam; j++) {
					out.print(dominateRes[i][j] ? "Y|" : "N|");
				}
				out.println();
				out.print(separador);
			}

		}
		out.flush();
	}

	static boolean[][] solve() {
		for (int i = 0; i < tam; i++)
			Arrays.fill(dominate[i], false);

		Arrays.fill(canReach, false);
		canReach[0] = true;
		reach(0);

		for (int cut = 0; cut < tam; cut++) {
			Arrays.fill(isVisited, false);
			visit(0, cut);
			for (int end = 0; end < tam; end++) {
				if (canReach[end] && !isVisited[end]) {
					dominate[cut][end] = true;
				}
			}
		}
		return dominate;
	}

	static void reach(int cur) {
		for (int next = 0; next < tam; next++) {
			if (mAdy[cur][next] && !canReach[next]) {
				canReach[next] = true;
				reach(next);
			}
		}
	}

	static void visit(int cur, int cut) {
		if (cur != cut) {
			isVisited[cur] = true;
			for (int next = 0; next < tam; next++) {
				if (mAdy[cur][next] && !isVisited[next]) {
					visit(next, cut);
				}
			}
		}
	}
}