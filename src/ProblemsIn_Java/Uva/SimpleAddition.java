package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class SimpleAddition {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		String line;
		while (true) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			long p = Long.parseLong(st.nextToken());
			long q = Long.parseLong(st.nextToken());
			if (p < 0 && q < 0)
				break;
			long sum = 0;
			for (long i = p; i < q; i++) {
				sum += F(i);
			}
			System.out.println(sum);
		}

		out.close();
		in.close();
	}

	static long F(long i) {
		if (i % 10 > 0) {
			return (i % 10);
		} else if (i == 0) {
			return 0;
		} else {
			return F(i / 10);
		}
	}
}
