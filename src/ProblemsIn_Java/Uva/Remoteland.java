package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * @author david yepes buitrago
 * @date 20-10-2017
 * @time 0.000 ms
 */
public class Remoteland {
	static long perfect[];

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		StringTokenizer st;
		long n;
		initializer();
		while ((n = Integer.parseInt(in.readLine().trim())) != 0) {
			
		}

		in.close();
		out.close();
	}

	static void initializer() {
		int max = 10000005;
		perfect = new long[max];
		for (int i = 3; i < max; i += 2) {
			perfect[i] = 0;
		}
		perfect[0] = perfect[1] = -1;
		for (int i = 2; i * i < max; i++) {
			if (perfect[i] <= 0) {
				for (int j = i * i; j < max; j += i) {
					perfect[j] = i;
				}
			}
		}

		for (int i = 2; i < max; i++) {
			if (perfect[i] <= 0)
				perfect[i] = i;
		}

		

	}
}
