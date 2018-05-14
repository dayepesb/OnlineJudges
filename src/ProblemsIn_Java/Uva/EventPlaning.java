package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * @author david yepes buitrago
 * @date 10-09-2017
 * @time 0.050 ms
 */
public class EventPlaning {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		StringTokenizer st;
		int participants, budget, hotels, weeks;
		for (String line; (line = in.readLine()) != null;) {
			st = new StringTokenizer(line);
			participants = Integer.parseInt(st.nextToken());
			budget = Integer.parseInt(st.nextToken());
			hotels = Integer.parseInt(st.nextToken());
			weeks = Integer.parseInt(st.nextToken());
			int mem[] = new int[hotels];
			for (int i = 0; i < hotels; i++) {
				int cost = Integer.parseInt(in.readLine().trim());
				st = new StringTokenizer(in.readLine());
				for (int j = 0; j < weeks; j++) {
					int beds = Integer.parseInt(st.nextToken());
					if (beds >= participants) {
						int costTotal = cost * participants;
						mem[i] = costTotal;
						break;
					}
				}
			}
			int min = Integer.MAX_VALUE;
			for (int i : mem) {
				if (i != 0)
					min = Math.min(i, min);
			}
			if (min <= budget) {
				out.println(min);
			} else {
				out.println("stay home");
			}

		}

		in.close();
		out.close();
	}
}
