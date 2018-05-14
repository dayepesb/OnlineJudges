package ProblemsIn_Java.VirtualJudge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * @author david yepes buitrago
 * @date 12-03-2018
 * @time 0.000 ms
 */
public class Squares {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		StringTokenizer st;
		int array[] = new int[10001];
		for (int i = 1; i < array.length; i++) {
			int sqrt = (int) (Math.sqrt(i));
			if (sqrt * sqrt == i)
				array[i] = 1;
			else
				array[i] = i;
		}
		for (int i = 1; i < array.length; i++) {
			if (array[i] > 1) {
				for (int j = 1; j * j < i; j++) {
					array[i] = Math.min(array[i], 1 + array[i - j * j]);
				}
			}
		}
		int tc = Integer.parseInt(in.readLine().trim());
		for (String line; (line = in.readLine()) != null;) {
			System.out.println(array[Integer.parseInt(line.trim())]);
		}
		in.close();
		out.close();
	}
}
