package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author david yepes buitrago
 * @date 11-09-2017
 * @time 0.400 ms
 */
public class TwinPrimes {
	static ArrayList<Integer> primeList;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		sieve();
		ArrayList<Integer> twinPrime = new ArrayList<>();
		for (int i = 1; i < primeList.size(); i++) {
			if (primeList.get(i) - primeList.get(i - 1) == 2)
				twinPrime.add(primeList.get(i - 1));
		}
		for (String line; (line = in.readLine()) != null;) {
			int s = Integer.parseInt(line.trim());
			out.printf("(%d, %d)\n", twinPrime.get(s - 1), twinPrime.get(s - 1) + 2);
		}

		in.close();
		out.close();
	}

	static void sieve() {
		int N = 20000000;
		boolean mark[] = new boolean[N];
		Arrays.fill(mark, true);
		for (int i = 4; i < N; i += 2)
			mark[i] = false;

		for (int i = 3; i * i <= N; i++) {
			if (mark[i]) {
				for (int j = i * i; j < N; j += 2 * i)
					mark[j] = false;
			}
		}
		primeList = new ArrayList<>();
		primeList.add(2);
		for (int i = 3; i < N; i += 2) {
			if (mark[i])
				primeList.add(i);
		}
	}
}
