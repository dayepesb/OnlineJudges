package ProblemsIn_Java.VirtualJudge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * @author david yepes buitrago
 * @date 21-01-2017
 * @time 0.075 ms
 */
public class Feynman {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		long dp[] = new long[101];
		dp[0] = dp[1] = 1;
		for (int i = 2; i < 101; dp[i] = dp[i - 1] + (i * i), i++)
			;
		while (true) {
			int a = Integer.parseInt(in.readLine().trim());
			if (a == 0)
				break;
			out.println(dp[a]);
		}
		in.close();
		out.close();
	}
}
