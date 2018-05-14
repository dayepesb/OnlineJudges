package ProblemsIn_Java.Uva;

import java.awt.geom.Point2D;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Locale;
import java.util.StringTokenizer;

public class Freckles {
	static double mAdy[][];

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		Locale.setDefault(new Locale("en", "US"));
		int casos = Integer.parseInt(in.readLine().trim());
		StringTokenizer st;
		ArrayList<Point2D> list;
		ArrayList<Integer> lAdy[];
		for (int k = 0; k < casos; k++) {
			in.readLine();
			int nodos = Integer.parseInt(in.readLine().trim());
			list = new ArrayList<>();

			lAdy = new ArrayList[nodos];
			for (int i = 0; i < lAdy.length; lAdy[i] = new ArrayList<>(), i++)
				;

			mAdy = new double[nodos][nodos];
			for (int i = 0; i < nodos; i++) {
				st = new StringTokenizer(in.readLine());
				double x = Double.parseDouble(st.nextToken()), y = Double.parseDouble(st.nextToken());
				list.add(new Point2D.Double(x, y));
			}
			for (int i = 0; i < nodos; i++) {
				for (int j = i + 1; j < nodos; j++) {
					mAdy[i][j] = mAdy[j][i] = list.get(i).distance(list.get(j));
					if (mAdy[i][j] != 0) {
						lAdy[i].add(j);
						lAdy[j].add(i);
					}
				}
			}
			boolean[][] res = prim(lAdy);
			double suma = .0;
			for (int i = 0; i < res.length; i++) {
				for (int j = i + 1; j < res.length; j++) {
					if (res[i][j]) {
						suma += mAdy[i][j];
					}
				}
			}
			if (k == casos - 1) {
				out.printf("%.2f%n", suma);
			} else
				out.printf("%.2f%n%n", suma);
		}

		out.close();
		in.close();
	}

	static public boolean[][] prim(ArrayList<Integer> lAdy[]) { // parfa
		int n = mAdy.length, k, i, ie, je;
		boolean res[][] = new boolean[n][n], vis[] = new boolean[n];
		for (vis[0] = true, k = 1; k < n; k++) {
			double me = Double.POSITIVE_INFINITY;
			for (i = 0, ie = je = -1; i < n; i++)
				if (vis[i])
					for (int j : lAdy[i]) {
						if (!vis[j] && mAdy[i][j] < me) {
							ie = i;
							je = j;
							me = mAdy[i][j];
						}
					}
			res[ie][je] = res[je][ie] = vis[je] = true;
		}
		return res;
	}

}
