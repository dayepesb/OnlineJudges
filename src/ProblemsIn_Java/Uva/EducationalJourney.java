package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * @author david yepes buitrago
 *
 */
public class EducationalJourney {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		double t1, t2, t3, t4, t5;
		StringTokenizer st;

		for (String line;! (line = in.readLine().trim()).equals("-1");) {
			st = new StringTokenizer(line);
			t1 = time(st.nextToken());
			t2 = time(st.nextToken());
			t3 = time(st.nextToken());
			t4 = time(st.nextToken());
			t5 = time(st.nextToken());

			double k = (t5 - t2) * (t3 - t1) / (t4 - t1) / (t3 - t2);
			int t = (int) ((t4 * k - t5) / (k - 1) + 1e-6 + 0.5);
			out.printf("%02d:%02d:%02d\n", t / 3600, t % 3600 / 60, t % 3600 % 60);
		}

		in.close();
		out.close();
	}

	static double time(String hms) {
		StringTokenizer st = new StringTokenizer(hms, ":");
		int h = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());

		return h * 3600 + m * 60 + s;
	}
}
