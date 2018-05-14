package ProblemsIn_Java.Uri;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class DistanciaEntreDosPuntos {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		for (String line; (line = in.readLine()) != null;) {
			StringTokenizer st = new StringTokenizer(line);
			double ux = Double.parseDouble(st.nextToken());
			double uy = Double.parseDouble(st.nextToken());
			st = new StringTokenizer(in.readLine());
			double vx = Double.parseDouble(st.nextToken());
			double vy = Double.parseDouble(st.nextToken());
			out.printf("%.4f%n", Math.hypot((vx - ux), (vy - uy)));
		}

		out.close();
		in.close();
	}
}
