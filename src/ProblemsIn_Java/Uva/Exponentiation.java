package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.StringTokenizer;

public class Exponentiation {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
		for (String line; (line = in.readLine())!=null; ) {
			StringTokenizer st = new StringTokenizer(line);
			BigDecimal bd = new BigDecimal(st.nextToken());
			String res = bd.pow(Integer.parseInt(st.nextToken())).stripTrailingZeros().toPlainString();
			out.println(res.charAt(0)=='0'?res.substring(1):res);
		}
		out.close();
		in.close();
	}

}
