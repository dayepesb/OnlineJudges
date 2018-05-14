package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class AContestToMeet {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		StringTokenizer st;
		String line;
		while ((line = in.readLine()) != null) {
			st = new StringTokenizer(line);
			int nodes = Integer.parseInt(st.nextToken());
			int edges = Integer.parseInt(st.nextToken());
			double mAdy[][] = new double[nodes][nodes];
			for (int i = 0; i < nodes; i++) {
				Arrays.fill(mAdy[i], Double.MAX_VALUE / 4);
				mAdy[i][i] = 0;
			}
			for (int i = 0; i < edges; i++) {
				st = new StringTokenizer(in.readLine());
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				double d = Double.parseDouble(st.nextToken());
				mAdy[u][v] = mAdy[v][u] = d;
			}
			st = new StringTokenizer(in.readLine());
			double a1 = Double.parseDouble(st.nextToken());
			double a2 = Double.parseDouble(st.nextToken());
			double a3 = Double.parseDouble(st.nextToken());
			double torpe = Math.min(a1, Math.min(a2, a3));
			for (int k = 0; k < nodes; k++) {
				for (int i = 0; i < nodes; i++) {
					for (int j = 0; j < nodes; j++) {
						mAdy[i][j] = Math.min(mAdy[i][j], mAdy[i][k] + mAdy[k][j]);
					}
				}
			}
			int i = 0, j = 0;
			double max = 0;
			for (int k = 0; k < nodes; k++) {
				for (int k2 = 0; k2 < nodes; k2++) {
					if (mAdy[k][k2] > max &&mAdy[k][k2]!=Double.MAX_VALUE/4) {
						max = mAdy[k][k2];
						i = k;
						j=k2;
					}
				}
			}
			out.println((int)Math.ceil(max/torpe));
		}

		out.close();
		in.close();
	}
}
