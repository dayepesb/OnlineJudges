package ProblemsIn_Java.VirtualJudge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * @author david yepes buitrago
 * @date 01-08-2017
 * @time 0.227 ms
 */
public class SortedArrays {
	public static void main(String[] args) throws IOException {
		BufferedReader tec = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		for (String line; (line = tec.readLine()) != null;) {
			int n = Integer.parseInt(line.trim());
			int[] arr = new int[n];
			StringTokenizer st = new StringTokenizer(tec.readLine());
			for (int i = 0; i < arr.length; i++)
				arr[i] = Integer.parseInt(st.nextToken());
			if (n == 1) {
				out.println(1);
				break;
			}
			int cont = 1;

			for (int indice = 0; indice < arr.length; indice++) {

				boolean bool = true;
				boolean decidido = false;
				// true ascendente
				boolean cambio = false;
				for (int i = indice; i < arr.length - 1; i++) {
					if (arr[i] < arr[i + 1] && !decidido) {
						decidido = true;
						bool = true;
					}
					if (arr[i] > arr[i + 1] && !decidido) {
						decidido = true;
						bool = false;
					}
					if (arr[i] < arr[i + 1] && !bool && decidido) {
						cont++;
						bool = !bool;
						indice = i;
						cambio = true;
						break;
					}
					if (arr[i] > arr[i + 1] && bool && decidido) {
						cont++;
						bool = !bool;
						indice = i;
						cambio = true;
						break;
					}
				}
				if (!cambio) {
					break;
				}
			}
			out.println(cont);
		}
		out.close();
	}
}
