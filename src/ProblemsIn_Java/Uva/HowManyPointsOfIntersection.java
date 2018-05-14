package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class HowManyPointsOfIntersection {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		StringTokenizer st;
		int caso = 0;
		while (true) {
			caso++;
			st = new StringTokenizer(in.readLine());
			long a = Long.parseLong(st.nextToken()), b = Long.parseLong(st.nextToken());
			if (a == b && b == 0) {
				break;
			}
			out.printf("Case %d: %d%n", caso, (a * (a - 1) / 2) * (b * (b - 1) / 2));
		}

		out.close();
		in.close();
	}
}
