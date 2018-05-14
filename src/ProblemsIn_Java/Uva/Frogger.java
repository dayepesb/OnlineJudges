package ProblemsIn_Java.Uva;

import java.awt.geom.Point2D;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.StringTokenizer;

public class Frogger {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		Locale.setDefault(new Locale("en"));
		int nodos;
		int caso = 1;
		while ((nodos = Integer.parseInt(in.readLine().trim())) != 0) {

			Point2D ariastas[] = new Point2D[nodos];
			for (int i = 0; i < nodos; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine());
				ariastas[i] = new Point2D.Double(Double.parseDouble(st.nextToken()),
						Double.parseDouble(st.nextToken()));
			}

			double mAdy[][] = new double[nodos][nodos];
			for (int i = 0; i < nodos; i++) {
				for (int j = i + 1; j < nodos; j++) {
					mAdy[i][j] = mAdy[j][i] = ariastas[i].distance(ariastas[j]);
				}
			}
			for (int k = 0; k < nodos; k++) {
				for (int i = 0; i < nodos; i++) {
					for (int j = 0; j < nodos; j++) {
						mAdy[i][j] = Math.min(mAdy[i][j], Math.max(mAdy[i][k], mAdy[k][j]));
					}
				}
			}
			out.printf("Scenario #%d%nFrog Distance = %.3f%n%n", caso, mAdy[0][1]);
			caso++;

			in.readLine();
		}

		out.close();
		in.close();
	}
}
