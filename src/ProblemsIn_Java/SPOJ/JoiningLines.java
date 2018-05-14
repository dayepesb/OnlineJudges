package ProblemsIn_Java.SPOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author david yepes buitrago
 * @date 1-08-2017
 * @time 0.240 ms
 */
public class JoiningLines {
	public static void main(String[] args) throws IOException {
		BufferedReader tec = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		for (String line; (line = tec.readLine()) != null;) {
			StringTokenizer st = new StringTokenizer(line);
			int n = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(tec.readLine());
			int[] arr = new int[n];
			for (int i = 0; i < arr.length; i++)
				arr[i] = Integer.parseInt(st.nextToken());
			Arrays.sort(arr);
			boolean hecho = true;
			int quedatot = c;
			for (int i = arr.length - 1; i >= 0; i--) {
				int cont = 0;
				quedatot -= arr[i];
				if (quedatot < 0) {
					hecho = false;
					break;
				}
				for (int linea = 1; linea < l; linea++) {
					int queda = arr[i];
					for (int j = i - 1 - cont; j >= 0; j--) {
						if (queda - arr[j] >= 0 && cont + 1 < l) {
							queda -= arr[j];
							cont++;
						}
					}
				}
				i -= cont;
			}
			out.println(hecho ? "S" : "N");
		}
		out.close();
	}
}
