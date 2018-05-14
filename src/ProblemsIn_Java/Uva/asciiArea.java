package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class asciiArea {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		for (String line; (line = in.readLine()) != null;) {
			StringTokenizer st = new StringTokenizer(line);
			int fil = Integer.parseInt(st.nextToken());
			int col = Integer.parseInt(st.nextToken());
			long cont = 0;
			for (int i = 0; i < fil; i++) {
				line = in.readLine();
				boolean b = false;
				for (int j = 0; j < col; j++) {
					if (b) {
						if (line.charAt(j) == '.') {
							cont++;
						}
						if (line.charAt(j) == '/' || line.charAt(j) == '\\') {
							cont++;
							b = false;
						}
					} else {
						if (line.charAt(j) == '/' || line.charAt(j) == '\\') {
							b = true;
						}
					}
				}
			}
			System.out.println(cont);
		}
		in.close();
	}
}