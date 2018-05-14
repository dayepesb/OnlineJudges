package ProblemsIn_Java.VirtualJudge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * @author david yepes buitrago
 * @date 21-01-2017
 * @time 0.000 ms
 */
public class SillySort {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		StringTokenizer st;
		HashMap<Integer, Integer> map;
		int caso = 1;
		int[] a, b;
		int n;
		boolean vis[];
		for (; (n = Integer.parseInt(in.readLine().trim())) != 0; caso++) {
			st = new StringTokenizer(in.readLine());
			a = new int[n];
			b = new int[n];
			vis = new boolean[n];
			for (int i = 0; i < n; i++) {
				b[i] = a[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(b);
			map = new HashMap<>();
			for (int i = 0; i < n; i++) {
				map.put(b[i], i);
			}
			int resp = 0;
			for (int i = 0; i < n; i++) {
				if (!vis[i]) {
					if (map.get(a[i]) == i) {
						vis[i] = true;
						continue;
					}
					int min = a[i];
					int num = 0;
					int sum = 0;
					int index = i;

					while (vis[index] == false) {
						sum += a[index];
						num++;
						if (a[index] < min) {
							min = a[index];
						}
						vis[index] = true;
						index = map.get(a[index]);
					}
					sum -= min;
					resp += sum + min * (num - 1);

					if (2 * (b[0] + min) < (min - b[0]) * (num - 1)) {
						resp -= (min - b[0]) * (num - 1) - 2 * (b[0] + min);
					}
				}
			}
			out.printf("Case %d: %d%n%n", caso, resp);
		}
		in.close();
		out.close();
	}
}
