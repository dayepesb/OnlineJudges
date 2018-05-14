package ProblemsIn_Java.Uva;

import java.io.PrintWriter;
import java.util.Scanner;

public class WhatsTheFrequencyKenneth {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		while (in.hasNextLine()) {
			String s = in.nextLine().trim();
			if (s.equals(""))
				continue;

			int[] letters = new int[53];

			for (int i = 0; i < s.length(); i++) {
				int c = (int) s.charAt(i);
				if (c > 64 && c < 91)
					letters[c - 65]++;
				else if (c > 96 && c < 123)
					letters[26 + (c - 97)]++;
			}

			int max = 0;
			for (int i = 0; i < letters.length; i++)
				max = max > letters[i] ? max : letters[i];

			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < 26; i++)
				if (max == letters[i])
					sb.append((char) (i + 65));

			for (int i = 26; i < letters.length; i++)
				if (max == letters[i])
					sb.append((char) (i + 71));

			out.printf("%s %d\n", sb.toString(), max);
		}
		out.close();
	}
}
