package ProblemsIn_Java.LiveArchive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class KeepingYourBalance {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		while (true) {
			StringTokenizer st = new StringTokenizer(in.readLine());

			if (st.countTokens() == 1)
				break;
			long a = Long.parseLong(st.nextToken());
			long b = Long.parseLong(st.nextToken());
			long c = a - b;
			long[] arr = new long[(int) b + 1];
			arr[arr.length - 1] = a;
			for (int i = 0; i < arr.length - 1; i++) {
				arr[i] = c++;
			}
			long min = arr[0];
			for (int i = 1; i < arr.length; i++) {
				min = lcm(min, arr[i]);
			}
			out.println(min);
		}
		out.close();
	}

	public static long lcm(long a, long b) {
		return a * (b / gcd(a, b));
	}

	public static long gcd(long a, long b) {
		long t;
		while (b != 0) {
			t = b;
			b = a % b;
			a = t;
		}
		return a;
	}
}
