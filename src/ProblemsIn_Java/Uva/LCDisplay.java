package ProblemsIn_Java.Uva;
/**
 * @author david yepes buitrago
 * @date 12-12-2017
 * @time 0.260 ms
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class LCDisplay {
	static final char SPACE = ' ';
	static final char HOR_SEG = '-'; // horizontal segment
	static final char VER_SEG = '|'; // vertical segment

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		for (String line; (line = in.readLine()) != null;) {
			StringTokenizer st = new StringTokenizer(line);

			while (st.hasMoreTokens()) {
				StringTokenizer st2 = new StringTokenizer(st.nextToken(), ",");
				int size = Integer.parseInt(st2.nextToken().trim());
				String number = st2.nextToken().trim();

				if (size == 0 || (size == 0 && number.equals("0")))
					break;

				int rows = 2 * size + 3;

				char[][] lookupChar = { { '-', '|', '|', ' ', '|', '|', '-' }, { ' ', '|', ' ', ' ', '|', ' ', ' ' },
						{ '-', '|', ' ', '-', ' ', '|', '-' }, { '-', '|', ' ', '-', '|', ' ', '-' },
						{ ' ', '|', '|', '-', '|', ' ', ' ' }, { '-', ' ', '|', '-', '|', ' ', '-' },
						{ '-', ' ', '|', '-', '|', '|', '-' }, { '-', '|', ' ', ' ', '|', ' ', ' ' },
						{ '-', '|', '|', '-', '|', '|', '-' }, { '-', '|', '|', '-', '|', ' ', '-' } };

				StringBuilder sb = new StringBuilder();

				for (int row = 0; row < rows; row++) {
					int pos = (row / (size + 1)) * 3;
					int uml = row % (size + 1);
					int lower = 2 * size + 2;

					for (int d = 0; d < number.length(); d++) {
						int digit = number.charAt(d) - '0';
						if (uml == 0) {
							sb.append(SPACE);
							for (int k = 0; k < size; k++) {
								sb.append(lookupChar[digit][pos]);
							}
							sb.append(SPACE);
						} else if (row > 0 && row < (size + 1)) {
							sb.append(lookupChar[digit][2]);
							for (int k = 0; k < size; k++) {
								sb.append(SPACE);
							}
							sb.append(lookupChar[digit][1]);
						} else if (row > (size + 1) && row < lower) {
							sb.append(lookupChar[digit][5]);
							for (int k = 0; k < size; k++) {
								sb.append(SPACE);
							}
							sb.append(lookupChar[digit][4]);
						}
						if (d != number.length() - 1)
							sb.append(SPACE);
					}
					sb.append("\n");
				}
				out.print(sb.toString());
				out.println();
			}
		}
		in.close();
		out.close();
	}
}