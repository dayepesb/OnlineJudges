package ProblemsIn_Java.VirtualJudge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * @author david yepes buitrago
 * @date 21-01-2017
 * @time 0.081 ms
 */
public class WannaGoBackHome {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		for (String line; (line = in.readLine()) != null;) {
			boolean[] arr = new boolean[4];
			line = line.toUpperCase();
			for (int i = 0; i < line.length(); i++) {
				switch (line.charAt(i)) {
				case 'S':
					arr[0] = true;
					break;
				case 'N':
					arr[1] = true;
					break;
				case 'W':
					arr[2] = true;
					break;
				case 'E':
					arr[3] = true;
					break;
				}
			}
			if (arr[0] == arr[1] && arr[2] == arr[3]) {
				out.println("Yes");
			} else {
				out.println("No");
			}

		}
		out.close();
	}

}
