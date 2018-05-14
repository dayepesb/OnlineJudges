package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * @author david yepes buitrago
 *
 */
public class PowerStrings {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		for (String line; !(line = in.readLine().trim()).equals(".");) {
			int length = line.length();
			int power = 1;

			char ch[] = line.toCharArray();

			for (int i = 2; i <= length; i++) {
				if (length % i == 0) {
					int L = length / i;
					boolean flag = true;
					for (int j = L; j < length; j++) {
						if (ch[j] != ch[j % L]) {
							flag = false;
							break;
						}
					}

					if (flag) {
						power = Math.max(power, i);
					}
				}
			}

			out.printf("%d\n", power);

		}

		in.close();
		out.close();
	}
}
