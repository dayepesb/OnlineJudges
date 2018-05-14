package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class HanoiTowerTroubles {
	static long[] preCal;

	public static void main(String[] args) throws Exception {
		preCal = cal();
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int casos = Integer.parseInt(in.readLine().trim());
		for (int i = 0; i < casos; i++) {
			out.println(preCal[Integer.parseInt(in.readLine().trim())]);
		}

		out.close();
		in.close();
	}

	private static long[] cal() {
		long[] c = new long[51];

		int towerN = 0, num = 1, temp = 0;
		boolean find = false;
		for (int i = 1; i < c.length; i++) {
			towerN = i;
			num = 1;
			int[] t = new int[towerN];
			int z = 0;
			while (z < towerN) {
				temp = t[z] + num;
				find = false;
				for (int j = 1; j * j <= temp; j++) {
					if (j * j == temp || t[z] == 0) {
						t[z] = num;
						num++;
						z = 0;
						find = true;
						break;
					}
				}
				if (find != true) {
					z++;
				}
			}
			c[i] = num - 1;
		}

		return c;
	}
}
