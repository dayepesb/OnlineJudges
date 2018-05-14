package ProblemsIn_Java.CodeForces;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * @author david yepes buitrago
 * @date 04-08-2017
 * @time 0.109 ms
 */

public class TextVolume {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

//		System.out.println((int)'A'+" - "+(int)'Z');

		StringTokenizer st ;
		int n;
		for(String line;(line=in.readLine())!=null;) {
			n = Integer.parseInt(line.trim());
			st = new StringTokenizer(in.readLine());
			int max = -1;
			while(st.hasMoreTokens()) {
				String word = st.nextToken();
				int m = 0;
				for (int i = 0; i < word.length(); i++) {
					if(word.charAt(i)>64 && word.charAt(i)<91) {
						m++;
					}
				}
				max=Math.max(max, m);
			}
			out.println(max);
		}
		out.close();
		in.close();
	}
}
