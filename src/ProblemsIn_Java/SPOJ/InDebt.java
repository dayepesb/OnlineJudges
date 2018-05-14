package ProblemsIn_Java.SPOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * @author David Yepes Buitrago
 * @Date   25-07-2017
 */
public class InDebt {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		StringTokenizer st;
		for (String line;!(line=in.readLine().trim()).equals("-1");) {
			st = new StringTokenizer(in.readLine());
			int sum = 0;
			int resp =0;
			while(st.hasMoreTokens()) {
				sum+=Integer.parseInt(st.nextToken());
				if(sum%100==0) {
					sum=0;
					resp++;
				}
			}
			out.println(resp);
		}

		in.close();
		out.close();
	}
}
