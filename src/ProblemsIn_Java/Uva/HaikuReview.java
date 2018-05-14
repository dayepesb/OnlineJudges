package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * @author david yepes buitrago
 * @date 10-09-2017
 * @time 0.030 ms
 */
public class HaikuReview {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		StringTokenizer st;
		int cnt1, cnt2, cnt3;
		for (String line; !(line = in.readLine().trim()).equals("e/o/i");) {
			cnt1 = cnt2 = cnt3 = 0;
			if (isVocal(line.charAt(0))) {
				cnt1++;
			}
			int i = 0;
			for (i = 1;; i++) {
				if (line.charAt(i) == '/')
					break;
				if (isVocal(line.charAt(i)) && !isVocal(line.charAt(i - 1)))
					cnt1++;
			}

			if (isVocal(line.charAt(i + 1)))
				cnt2++;
			for (i = i + 2;; i++) {
				if (line.charAt(i) == '/')
					break;
				if (isVocal(line.charAt(i)) && !isVocal(line.charAt(i - 1)))
					cnt2++;
			}

			if (isVocal(line.charAt(i + 1)))
				cnt3++;
			for (i = i + 2; i < line.length(); i++) {
				if (isVocal(line.charAt(i)) && !isVocal(line.charAt(i - 1)))
					cnt3++;
			}
			if (cnt1 != 5)
				out.println("1");
			else if (cnt2 != 7)
				out.println("2");
			else if (cnt3 != 5)
				out.println("3");
			else
				out.println("Y");
		}

		in.close();
		out.close();
	}

	static boolean isVocal(char c) {
		return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'y';
	}
}
