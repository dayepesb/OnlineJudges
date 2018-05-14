package ProblemsIn_Java.VirtualJudge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * @author David Yepes Buitrago
 *
 * @Date 28-07-2017
 */
public class FeedWithCandy {
	static ArrayList<Candy> tipo1, tipo2;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		StringTokenizer st;
		int n, x;
		for (String line; (line = in.readLine()) != null;) {
			st = new StringTokenizer(line);
			n = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken());
			tipo1 = new ArrayList<>();
			tipo2 = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(in.readLine());
				String type = st.nextToken();
				int h = Integer.parseInt(st.nextToken());
				int m = Integer.parseInt(st.nextToken());
				switch (type) {
				case "0":
					tipo1.add(new Candy(h, m));
					break;
				case "1":
					tipo2.add(new Candy(h, m));
					break;
				}
			}
			Collections.sort(tipo1);
			Collections.sort(tipo2);
			int ans1 = gredy(1, x);
			for (int i = 0; i < tipo1.size(); tipo1.get(i).used = false, i++);
			for (int i = 0; i < tipo2.size(); tipo2.get(i).used = false, i++);
			int ans2 = gredy(2, x);

			out.println(Math.max(ans1, ans2));
		}

		in.close();
		out.close();
	}

	static int gredy(int indexList, int x) {
		int ans1 = 0;
		while (true) {
			if (indexList == 1) {
				int indexPosible = -1;
				int mass = 0;
				for (int i = 0; i < tipo1.size(); i++) {
					if (!tipo1.get(i).used && x >= tipo1.get(i).altura && tipo1.get(i).masa > mass) {
						indexPosible = i;
						mass = tipo1.get(i).masa;
					}
					if(tipo1.get(i).altura>x) {
						break;
					}
				}
				if (indexPosible != -1) {
					tipo1.get(indexPosible).used = true;
					indexList = 2;
					x += tipo1.get(indexPosible).masa;
					ans1++;
				} else {
					break;
				}
			} else {
				int indexPosible = -1;
				int mass = 0;
				for (int i = 0; i < tipo2.size(); i++) {
					if (!tipo2.get(i).used && x >= tipo2.get(i).altura && tipo2.get(i).masa > mass) {
						indexPosible = i;
						mass = tipo2.get(i).masa;
					}
					if(tipo2.get(i).altura>x) {
						break;
					}
				}
				if (indexPosible != -1) {
					tipo2.get(indexPosible).used = true;
					indexList = 1;
					x += tipo2.get(indexPosible).masa;
					ans1++;
				} else {
					break;
				}
			}
		}
		return ans1;
	}

	static class Candy implements Comparable<Candy> {
		int altura, masa;
		boolean used;

		public Candy(int altura, int masa) {
			this.altura = altura;
			this.masa = masa;
			used = false;
		}

		@Override
		public int compareTo(Candy o) {
			if (this.altura == o.altura) {
				return Integer.compare(this.masa, o.masa);
			}
			return Integer.compare(this.altura, o.altura);
		}

		@Override
		public String toString() {
			return altura + " " + masa;
		}
	}
}
