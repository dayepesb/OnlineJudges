package ProblemsIn_Java.Uri;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TheRaceOfSlugs {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int a, b, c, max = 0;
		for (String line; (line = in.readLine()) != null;) {

			a = Integer.parseInt(line.trim());
			StringTokenizer st = new StringTokenizer(in.readLine());
			for (b = 1, max = 0; b <= a; b++) {
				c = Integer.parseInt(st.nextToken());
				if (c > max)
					max = c;
			}
			if (max < 10)
				System.out.printf("1\n");
			else if (max < 20)
				System.out.printf("2\n");
			else
				System.out.printf("3\n");
		}
		in.close();
	}
}
