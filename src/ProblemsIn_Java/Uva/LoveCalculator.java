package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Locale;

/**
 * @author david yepes buitrago
 * @date 10-09-2017
 * @time 0.060 ms
 */
public class LoveCalculator {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		Locale.setDefault(new Locale("en"));

		String name1, name2;
		while (true) {
			name1 = in.readLine();
			if (name1 == null)
				break;
			name1 = name1.trim();

			name2 = in.readLine().trim();
			int sum1 = 0, sum2 = 0;
			for (int i = 0; i < name1.length(); i++) {
				if (Character.isAlphabetic(name1.charAt(i))) {
					if (Character.isUpperCase(name1.charAt(i)))
						sum1 += name1.charAt(i) - 'A' + 1;
					else
						sum1 += name1.charAt(i) - 'a' + 1;
				}
			}
			for (int i = 0; i < name2.length(); i++) {
				if (Character.isAlphabetic(name2.charAt(i))) {
					if (Character.isUpperCase(name2.charAt(i)))
						sum2 += name2.charAt(i) - 'A' + 1;
					else
						sum2 += name2.charAt(i) - 'a' + 1;
				}
			}
			sum1 = recurseSum(sum1);
			sum2 = recurseSum(sum2);
			if (sum1 >= sum2)
				out.printf("%.2f %c%n", sum2 * 100.0 / sum1, '%');
			else
				out.printf("%.2f %c%n", sum1 * 100.0 / sum2, '%');

		}

		in.close();
		out.close();
	}

	static int recurseSum(int i) {
		if (i < 10) {
			return i;
		} else {
			int sum = 0;
			while (i > 0) {
				sum += i % 10;
				i /= 10;
			}
			return recurseSum(sum);
		}
	}
}
