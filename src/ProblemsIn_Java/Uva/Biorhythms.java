package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Biorhythms {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

		long arr[] = { 23L, 28L, 33L };
		long M = 21252L;
		StringTokenizer st = new StringTokenizer(in.readLine());
		long p = Long.parseLong(st.nextToken());
		long e = Long.parseLong(st.nextToken());
		long i = Long.parseLong(st.nextToken());
		long d = Long.parseLong(st.nextToken());
		long[] a = extendsMCD(arr[2] * arr[1], arr[0]);
		long[] b = extendsMCD(arr[0] * arr[2], arr[1]);
		long[] c = extendsMCD(arr[1] * arr[0], arr[2]);

		Ciclo: for (int k = 1;; k++) {
			if (p == e && e == i && i == d && d == -1) {
				break Ciclo;
			}

			// System.out.println("a " +Arrays.toString(a));
			// System.out.println("b " +Arrays.toString(b));
			// System.out.println("c " +Arrays.toString(c));

			long res = (((p * a[1] * (M / 23)) + (e * b[1] * (M / 28)) + (i * c[1] * (M / 33))) % M) - d;

			while (res <= 0) {
				res += M;
			}
			while (res > M) {
				res -= M;
			}

			out.printf("Case %d: the next triple peak occurs in %d days.%n", k, res);

			st = new StringTokenizer(in.readLine());
			p = Long.parseLong(st.nextToken());
			e = Long.parseLong(st.nextToken());
			i = Long.parseLong(st.nextToken());
			d = Long.parseLong(st.nextToken());
		}

		out.close();
		in.close();
	}

	public static long[] extendsMCD(long a, long b) {
		long[] res = new long[3];
		if ((b == 0)) {
			res[0] = a;
			res[1] = 1;
			res[2] = 0;
			return res;
		}
		long q = a / b;
		long r = a - b * q;

		long arr[] = extendsMCD(b, r);
		long x = arr[1];
		long y = arr[2];
		long d = arr[0];

		res[0] = arr[0];
		res[1] = y;
		res[2] = x - q * y;

		return res;
	}
}
