package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class PowerEtAl {

	public static void main(String[] args) throws Exception {
		BufferedReader tec = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		while (true) {
			StringTokenizer st = new StringTokenizer(tec.readLine());
			String a = st.nextToken();
			String b = st.nextToken();
			if (a.equals(b) && a.equals("0"))
				break;
			int m = Integer.parseInt(a.charAt(a.length() - 1) + "");
			int n = Integer.parseInt(b.substring(Math.max(0, b.length() - 4)));
			int mod = n % 4;
			int[] arr = { m, m * m, m * m * m, m * m * m * m };
			if (b.equals("0"))
				out.println(1);
			else {
				mod--;
				if (mod < 0)
					mod = 3;
				out.println(arr[mod] % 10);
			}
		}
		out.close();
	}
}