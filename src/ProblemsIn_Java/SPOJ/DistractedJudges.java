package ProblemsIn_Java.SPOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * @author david yepes buitrago
 * @date 21-01-2017
 * @time 1.260 ms
 */
public class DistractedJudges {
	public static void main(String[] args) throws IOException {
		BufferedReader tec = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		for (String line; (line = tec.readLine()) != null;) {
			int n = Integer.parseInt(line.trim());
			int[] arr = new int[n];
			for (int i = 0; i < arr.length; i++)
				arr[i] = Integer.parseInt(tec.readLine().trim());
			boolean[] bool = new boolean[arr.length];
			for (int i = arr.length - 1; i >= 0; i--) {
				if (arr[i] + i + 1 == arr.length || ((arr[i] + i + 1) < arr.length && bool[arr[i] + i + 1])) {
					bool[i] = true;
				}
			}
			for (int i = 1; i < bool.length; i++) {
				if (bool[i]) {
					out.println(i);
				}
			}
			out.println(arr.length);
		}
		out.close();
	}
}
