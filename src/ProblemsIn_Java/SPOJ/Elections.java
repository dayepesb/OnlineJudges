package ProblemsIn_Java.SPOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author david yepes buitrago
 * @date 01-08-2017
 * @time 0.830 ms
 */
public class Elections {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		for (String line; (line = in.readLine()) != null;) {
			int n = Integer.parseInt(line);
			int[] arr = new int[n];
			StringTokenizer st = new StringTokenizer(in.readLine());
			long suma = 0;
			for (int i = 0; i < arr.length; i++)
				suma += arr[i] = Integer.parseInt(st.nextToken());
			Arrays.sort(arr);
			if (arr.length == 1) {
				out.println(1);
				continue;
			} else {
				if (arr[arr.length - 1] == arr[arr.length - 2]) {
					out.println(2);
					continue;
				}
				if ((double) arr[arr.length - 1] / suma >= .45) {
					out.println(1);
					continue;
				}
				if ((double) arr[arr.length - 1] / suma >= .40
						&& ((double) arr[arr.length - 1] / suma) - ((double) arr[arr.length - 2] / suma) >= .10) {
					out.println(1);
				} else {
					out.println(2);
				}
			}
		}
		out.close();
	}
}
