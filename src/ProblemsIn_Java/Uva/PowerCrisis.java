package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PowerCrisis {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			int n = Integer.parseInt(in.readLine().trim());
			if (n == 0) {
				break;
			}

			int m = 1;

			while (true) {
				boolean[] city = new boolean[n];
				int index = 0;
				int count = 0;

				while (true) {
					city[index] = true;
					++count;

					if (count == n) {
						break;
					}

					for (int i = 0; i < m; ++i) {
						++index;
						index %= n;

						if (city[index]) {
							--i;
						}
					}
				}
				if (index == 12) {
					System.out.println(m);
					break;
				}
				++m;
			}
		}
		in.close();
	}
}