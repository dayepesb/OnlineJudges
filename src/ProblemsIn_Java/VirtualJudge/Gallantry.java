package ProblemsIn_Java.VirtualJudge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * @author david yepes buitrago
 * @date 21-01-2017
 * @time 1.380 ms
 */
public class Gallantry {
	public static void main(String[] args) throws IOException {
		BufferedReader tec = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		for (String line; (line = tec.readLine()) != null;) {
			int n = Integer.parseInt(line.trim());
			Integer[] arr = new Integer[n];
			StringTokenizer st = new StringTokenizer(tec.readLine());
			for (int i = 0; i < arr.length; i++)
				arr[i] = Integer.parseInt(st.nextToken());
			Comparator<Integer> c = new Comparator<Integer>() {
				@Override
				public int compare(Integer a, Integer b) {
					return b.compareTo(a);
				}
			};

			Arrays.sort(arr, c);
			Integer[] difs = new Integer[n >> 1];
			for (int i = 0; i < difs.length; i++)
				difs[i] = arr[i * 2] - arr[(i * 2) + 1];
			Arrays.sort(difs, c);

			int j = difs.length - 1;
			int num = difs[0];
			int cont = 0;
			for (int i = 1; i < difs.length; i++) {
				while (num - difs[j] > 0 && i <= j) {
					cont++;
					num -= difs[j--];
				}
				if (i == j)
					break;
				num += difs[i];
			}
			out.println(difs[0] == 0 ? -1 : cont);
		}
		out.close();
	}

}
