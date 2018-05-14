package ProblemsIn_Java.HackerRank;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ANDProduct {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		int casos = Integer.parseInt(in.readLine().trim());
		while (casos-- > 0) {
			StringTokenizer st = new StringTokenizer(in.readLine());

			long a = Long.parseLong(st.nextToken());
			long b = Long.parseLong(st.nextToken());
			long res = a;
			out.println(solution(a, b));
		}

		out.close();
		in.close();
	}

	static long solution(long a, long b) {
		long x = a ^ b;
		x |= (x >> 1);
		x |= (x >> 2);
		x |= (x >> 4);
		x |= (x >> 8);
		x |= (x >> 16);
		return a & ~x;

	}
}
