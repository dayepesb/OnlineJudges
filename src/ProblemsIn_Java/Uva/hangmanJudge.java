package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * @author david yepes buitrago
 * @date 10-09-2017
 * @time 0.300 ms
 */

public class hangmanJudge {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		while (true) {
			int n = Integer.parseInt(in.readLine().trim());
			if (n == -1)
				break;
			out.println("Round " + n);
			String target = in.readLine().trim().toLowerCase();
			String to = in.readLine().trim().toLowerCase();
			boolean b[] = new boolean[target.length()];
			boolean leters[] = new boolean[26];
			int errors = 0;
			boolean lose = false;
			Ciclo:
			for (int i = 0; i < to.length(); i++) {
				char a = to.charAt(i);
				if (!leters[a - 'a']) {
					leters[a - 'a'] = true;
					boolean pudo = false;
					for (int j = 0; j < b.length; j++) {
						if (a == target.charAt(j)) {
							b[j] = true;
							pudo = true;
						}
					}
					boolean win = true;
					for (boolean c : b) {
						win = win && c;
					}
					if (win)
						break Ciclo;
					if (!pudo)
						errors++;
					if (errors >= 7) {
						lose = true;
						break;
					}
				}
			}
			if (lose) {
				out.println("You lose.");
			} else {
				lose = true;
				for (boolean c : b) {
					lose = lose && c;
				}
				if (lose)
					out.println("You win.");
				else {
					out.println("You chickened out.");
				}
			}

		}

		out.close();
		in.close();
	}
}
