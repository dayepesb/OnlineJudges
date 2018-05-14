package ProblemsIn_Java.SPOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * @author david yepes buitrago
 * @date 21-01-2017
 * @time 0.120 ms
 */
public class AtRandom {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		StringTokenizer st;
		int t = Integer.parseInt(in.readLine().trim());
		for (int c = 0; c < t; c++) {
			int cards = Integer.parseInt(in.readLine().trim());
			int antNum = -1;
			char antCard = '\0';
			boolean b = true;
			for (int i = 0; i < cards; i++) {
				st = new StringTokenizer(in.readLine());
				int actNum = Integer.parseInt(st.nextToken());
				char actCard = st.nextToken().charAt(0);
				if (actNum == antNum || actCard == antCard)
					b = false;
				antNum = actNum;
				antCard = actCard;
			}
			out.println(b ? "B" : "M");
		}

		in.close();
		out.close();
	}
}
