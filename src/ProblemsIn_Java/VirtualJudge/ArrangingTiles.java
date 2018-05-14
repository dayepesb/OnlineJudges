package ProblemsIn_Java.VirtualJudge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * @author david yepes buitrago
 * @date 21-01-2017
 * @time 0.000 ms
 */

public class ArrangingTiles {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		StringTokenizer st;
		for (String line; (line = in.readLine()) != null;) {
			st = new StringTokenizer(line);
			int N = Integer.parseInt(st.nextToken());
			int H = Integer.parseInt(st.nextToken());
			ArrayList<Work> works = new ArrayList<>();

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine());
				works.add(new Work(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
			}
			Collections.sort(works);
			Work[] hourswork = new Work[H + 1];
			int loss = 0;
			for (int i = 0; i < works.size(); i++) {
				int j = works.get(i).time - 1;
				while (j >= 0 && hourswork[j] != null)
					j--;
				if (j >= 0)
					hourswork[j] = works.get(i);
				else
					loss += works.get(i).value;
			}
			out.printf("%d\n", loss);
		}
		in.close();
		out.close();
	}

	static class Work implements Comparable<Work> {
		int value, time;

		public Work(int v, int t) {
			this.value = v;
			this.time = t;
		}

		@Override
		public int compareTo(Work o) {
			if (this.value != o.value) {
				return Integer.signum(o.value - this.value);
			}
			return Integer.signum(this.time - o.time);
		}
	}

}
