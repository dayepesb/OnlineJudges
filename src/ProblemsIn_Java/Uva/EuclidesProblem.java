package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class EuclidesProblem {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

		StringTokenizer st;
		Ciclo: while (true) {
			String line = in.readLine();
			if (line == null) {
				break Ciclo;
			}
			st = new StringTokenizer(line.trim());
			int m = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
//			int r = Integer.MAX_VALUE;
//			while (r != 0) {
//				r = m % n;
//				m = n;
//				n = r;
//			}
//			out.println(m);
			long res [] = extendsMCD(m, n);
			out.printf("%d %d %d%n",res[1],res[2],res[0]);
		}

		out.close();
		in.close();
	}

	public static long[] extendsMCD(int a, int b) {
		long[] res = new long[3];
		if ((b == 0)) {
			res[0] = a;
			res[1] = 1;
			res[2] = 0;
			return res;
		}
		int q = a / b;
		int r = a - b * q;

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
