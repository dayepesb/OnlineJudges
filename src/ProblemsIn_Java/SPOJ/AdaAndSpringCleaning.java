package ProblemsIn_Java.SPOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.StringTokenizer;

public class AdaAndSpringCleaning {

	static final long PRIME = 1000000007;
	static long RM;
	static final long R = 256;
	static int N, M;

	/*
	 * HASH MODULAR
	 */
	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		PrintWriter out = new PrintWriter(System.out);

		StringTokenizer st;
		int casos = in.nextInt();
		for (int i = 0; i < casos; i++) {
			// tam txt
			N = in.nextInt();
			// tama�o del patron
			M = in.nextInt();
			RM = 1;
			for (int j = 1; j <= M - 1; j++) {
				RM = (R * RM) % PRIME;
			}

			StringBuilder sb = new StringBuilder();
			st = new StringTokenizer(in.next());
			while (st.hasMoreTokens()) {
				sb.append(st.nextToken());
			}
			out.println(tamHash(sb.toString()));
		}
		out.close();
		in.close();
	}

	static long tamHash(String txt) {
		HashSet<Long> ts = new HashSet<>();

		long txtHash = hash(txt);
		ts.add(txtHash);

		for (int i = 1; i <= N - M; i++) {
			txtHash = (txtHash + PRIME - RM * txt.charAt(i - 1) % PRIME) % PRIME;
			txtHash = (txtHash * R + txt.charAt(i + M - 1)) % PRIME;
			ts.add(txtHash);
		}

		return ts.size();
	}

	static long hash(String key) {
		long h = 0;
		for (int j = 0; j < M; j++)
			h = (R * h + key.charAt(j)) % PRIME;
		return h;
	}
}
