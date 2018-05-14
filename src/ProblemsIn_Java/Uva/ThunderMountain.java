package ProblemsIn_Java.Uva;

import java.awt.geom.Point2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Locale;
import java.util.StringTokenizer;

/**
 * @author david yepes buitrago
 *
 */
public class ThunderMountain {

	static final double INF = 1024 * 101, MaxSquaredDistance = 10 * 10, POSSIBLE_MARGIN = INF - 1;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		Locale.setDefault(new Locale("en"));

		StringTokenizer st;
		ArrayList<Point2D> points;
		double mAdy[][];
		int cases = Integer.parseInt(in.readLine().trim()), nodos;
		for (int c = 1; c <= cases; c++) {
			nodos = Integer.parseInt(in.readLine().trim());
			points = new ArrayList<>();
			mAdy = new double[nodos][nodos];
			for (int i = 0; i < nodos; i++) {
				st = new StringTokenizer(in.readLine());
				points.add(new Point2D.Double(Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken())));
			}

			for (int i = 0; i < points.size(); i++) {
				for (int j = i + 1; j < points.size(); j++) {
					Point2D a = points.get(i);
					Point2D b = points.get(j);
					double dist = (a.getX() - b.getX()) * (a.getX() - b.getX())
							+ (a.getY() - b.getY()) * (a.getY() - b.getY());
					if (dist <= MaxSquaredDistance) {
						dist = Math.sqrt(dist);
						mAdy[i][j] = mAdy[j][i] = dist;
					} else {
						mAdy[i][j] = mAdy[j][i] = INF;
					}
				}
			}

			for (int i = 0; i < nodos; i++) {
				for (int j = 0; j < nodos; j++) {
					for (int k = 0; k < nodos; k++) {
						mAdy[i][j] = Math.min(mAdy[i][j], mAdy[i][k] + mAdy[k][j]);
					}
				}
			}

			double max = 0;

			for (int i = 0; i < nodos; i++) {
				for (int j = i+1; j < nodos; j++) {
					max = Math.max(max, mAdy[i][j]);
				}
			}

			out.printf("Case #%d:%n", c);
			if (max > POSSIBLE_MARGIN)
				out.println("Send Kurdy\n");
			else
				out.printf("%.4f\n\n", max);

		}

		in.close();
		out.close();
	}
}
