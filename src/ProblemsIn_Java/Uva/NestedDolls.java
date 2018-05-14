package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author david yepes buitrago
 * @date 21-07-2017
 * @time 0.450 ms
 */
public class NestedDolls {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		StringTokenizer st;
		doll[] dolls;

		int cases = Integer.parseInt(in.readLine().trim());

		while (cases-- > 0) {
			int numberDolls = Integer.parseInt(in.readLine().trim());
			dolls = new doll[numberDolls];
			st = new StringTokenizer(in.readLine());
			for (int i = 0; i < numberDolls; i++) {
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				dolls[i] = new doll(u, v);
			}

			Arrays.sort(dolls);

			ArrayList<doll> current = new ArrayList<>();
			current.add(dolls[dolls.length - 1]);
			for (int i = dolls.length - 2; i >= 0; i--) {
				int hi = current.size() - 1, lo = 0, mid;
				int ant = -10;
				while (lo <= hi) {
					mid = (lo + hi) / 2;
					if (current.get(mid).height == dolls[i].height || current.get(mid).width < dolls[i].width) {
						lo = mid + 1;
					} else {
						hi = mid - 1;
					}
					if (ant == mid || hi < 0)
						break;
					ant = mid;
				}

				if (lo == current.size()) {
					current.add(dolls[i]);
				} else {
					current.get(lo).width = dolls[i].width;
					current.get(lo).height = dolls[i].height;
				}
			}

			out.println(current.size());

		}

		in.close();
		out.close();
	}

	static class doll implements Comparable<doll> {
		int height, width;

		public doll(int first, int second) {
			this.height = first;
			this.width = second;
		}

		@Override
		public int compareTo(doll o) {
			if (this.height == o.height) {
				if (this.width == o.width)
					return 0;
				return (this.width > o.width ? -1 : 1);
			} else {
				return (this.height < o.height ? -1 : 1);
			}
		}

		@Override
		public String toString() {
			return "height : " + height + " - width : " + width + "\n";
		}
	}
}
