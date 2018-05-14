package ProblemsIn_Java.VirtualJudge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * @author david yepes buitrago
 * @date 01-08-2017
 * @time 0.050 ms
 */
public class HelpingGrandpaLaino {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		StringTokenizer st;
		String line;
		while ((line = in.readLine()) != null) {
			boolean b = true;
			for (int i = 0; i < line.length(); i++) {
				if (line.charAt(i) == 'i') {
					b = false;
					break;
				}
			}
			out.println(b ? "S" : "N");
		}

		in.close();
		out.close();
	}
}
