package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class BurgerTime {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		Ciclo: while (true) {
			int L = Integer.parseInt(in.readLine());
			if (L == 0)
				break Ciclo;
			char[] road = in.readLine().toCharArray();
			int lastDrugStore = -1;
			int lastRestaurant = -1;
			int min = Integer.MAX_VALUE;
			for (int i = 0; i < road.length; i++) {
				if (road[i] == 'R') {
					lastRestaurant = i;
				} else if (road[i] == 'D') {
					lastDrugStore = i;
				} else if (road[i] == 'Z') {
					min = 0;
					break;
				}
				if (lastDrugStore != -1 && lastRestaurant != -1) {
					min = Math.min(Math.abs(lastDrugStore - lastRestaurant), min);
				}
			}
			out.println(min);
		}

		out.close();
		in.close();
	}

}