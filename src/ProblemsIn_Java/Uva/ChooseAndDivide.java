package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.StringTokenizer;

/**
 * @author david yepes buitrago
 * @date 24-08-2017
 * @time 0.000 ms
 */
public class ChooseAndDivide {
	public static void main(String[] args) throws IOException {
		Locale.setDefault(new Locale("en", "US"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		StringTokenizer st;
		int p, q, r, s;
		for (String line; (line = in.readLine()) != null;) {
			st = new StringTokenizer(line);
			p = Integer.parseInt(st.nextToken());
			q = Integer.parseInt(st.nextToken());
			r = Integer.parseInt(st.nextToken());
			s = Integer.parseInt(st.nextToken());
			out.printf("%.5f%n", solve(p, q, r, s));
		}

		in.close();
		out.close();
	}

	static double solve(int p, int q, int r, int s) {
		q = Math.min(q, p - q);
		s = Math.min(s, r - s);
		p = p - q + 1;
		r = r - s + 1;
		double ret = 1.00;
		int i = 1, j = 1;
		while (i <= q || j <= s) {
			if (i <= q) {
				ret *= (double) p;
				ret /= (double) i;
				p++;
				i++;
			}
			if (j <= s) {
				ret *= (double) j;
				ret /= (double) r;
				j++;
				r++;
			}
		}
		return ret;
	}

}
/**
import java.math.BigDecimal;
import java.util.Scanner;
 
public class Main {
  public static void main(String[] args) {
    Scanner cin = new Scanner(System.in);
    BigDecimal fac[] = new BigDecimal[10001];
    fac[0] = BigDecimal.valueOf(1);
    for (int i = 1; i <= 10000; i++)
      fac[i] = fac[i - 1].multiply(BigDecimal.valueOf(i));
    while (cin.hasNext()) {
      int p = cin.nextInt(), q = cin.nextInt(), r = cin.nextInt(), s = cin.nextInt();
      BigDecimal ans = BigDecimal.ONE;
      ans = ans.multiply(fac[p]);
      ans = ans.divide(fac[q], 1000, BigDecimal.ROUND_HALF_UP);
      ans = ans.multiply(fac[s]);
      ans = ans.divide(fac[p - q], 1000, BigDecimal.ROUND_HALF_UP);
      ans = ans.multiply(fac[r - s]);
      ans = ans.divide(fac[r], 1000, BigDecimal.ROUND_HALF_UP);
      System.out.println(ans.setScale(5, BigDecimal.ROUND_HALF_UP));
    }
  }
}
*/