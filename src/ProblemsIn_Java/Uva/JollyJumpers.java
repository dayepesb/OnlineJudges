package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class JollyJumpers {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String line;
		while ((line = in.readLine()) != null) {
			line = line.trim();

			if (!line.equals("")) {
				StringTokenizer tokenizer = new StringTokenizer(line);
				int length = Integer.parseInt(tokenizer.nextToken());
				int[] sequence = new int[length];
				int i = 0;
				while (tokenizer.hasMoreTokens()) {
					int val = Integer.parseInt(tokenizer.nextToken());
					if (i < length) {
						sequence[i++] = val;
					}
				}
				System.out.println(solve(sequence, length));
			}
		}
	}

	public static String solve(int[] sequence, int length) {
		if (length == 1) {
			return "JOLLY";
		}

		Set<Integer> diffs = new HashSet<Integer>();
		for (int i = 0; i < length - 1; i++) {
			int diff = Math.abs(sequence[i + 1] - sequence[i]);
			if (diff <= length - 1 && diff > 0)
				diffs.add(diff);
		}

		return (diffs.size() == length - 1) ? "JOLLY" : "NOT JOLLY";
	}
}