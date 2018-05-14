package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * @author	david yepes buitrago
 * @date	23-08-2017
 * @time	0.000 ms
 */
public class DifferentsDigist {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		StringTokenizer st;
		int n, m;
		for (String line; (line = in.readLine()) != null;) {
			st = new StringTokenizer(line);
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			int count = 0;
			for (int i = n; i <= m; i++) {
				String num = i+"";
//				System.out.println(n+" " + m +" " +num);
				int repetidos [] = new int [10];
				for (int j = 0; j < num.length(); j++) {
					int a = num.charAt(j)-48;
//					System.out.println(a);
					repetidos[a]=repetidos[a]+1;
				}
				boolean b = true;
				for (int j = 0; j < repetidos.length; j++) {
					if(repetidos[j]>1) {
						b = false;
						break;
					}
				}
				if(b)count++;
			}
			out.println(count);
		}

		in.close();
		out.close();
	}
}
