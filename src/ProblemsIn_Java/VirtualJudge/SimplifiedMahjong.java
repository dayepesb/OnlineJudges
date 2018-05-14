package ProblemsIn_Java.VirtualJudge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * @author david yepes buitrago
 * @date 01-08-2017
 * @time 0.192 ms
 */
public class SimplifiedMahjong {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		for (String line; (line = in.readLine()) != null;) {
			int n = Integer.parseInt(line.trim());
			int[] arr = new int[n];
			for (int i = 0; i < arr.length; i++)
				arr[i] = Integer.parseInt(in.readLine().trim());
			if (n == 1) {
				out.println(arr[0] / 2);
				continue;
			}
			long x = arr[0], cont = 0;

			for (int i = 1; i < arr.length; i++) {
				x += arr[i];
				cont += x / 2;
				if ((x & 1) == 1 && arr[i] != 0) {
					x = 1;
				} else {
					x = 0;
				}
			}
			out.println(cont);
		}
		out.close();
	}
}
