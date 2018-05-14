package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TrainSwapping {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int casos = Integer.parseInt(in.readLine().trim());
		while (casos-- > 0) {

			int tam = Integer.parseInt(in.readLine().trim());
			int tren[] = new int[tam];
			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int i = 0; i < tam; tren[i] = Integer.parseInt(st.nextToken()), ++i)
				;

			int swaps = 0;
			for (int i = 0; i < tam; ++i) {
				for (int j = i - 1; (j >= 0 && tren[j + 1] < tren[j]); --j) {
					tren[j + 1] ^= tren[j];
					tren[j] ^= tren[j + 1];
					tren[j + 1] ^= tren[j];
					++swaps;
				}
			}
			System.out.println("Optimal train swapping takes " + swaps + " swaps.");
		}
		in.close();

	}
}
