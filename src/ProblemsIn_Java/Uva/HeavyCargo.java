package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class HeavyCargo {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		HashMap<String, Integer> cities;
		int caso = 1;
		for (String line; !(line = in.readLine().trim()).equals("0 0");) {
			cities = new HashMap<>();
			StringTokenizer st = new StringTokenizer(line);
			int ciudades = Integer.parseInt(st.nextToken());
			int carreteras = Integer.parseInt(st.nextToken());
			int mAdy[][] = new int[ciudades][ciudades];
			int index = 0;
			for (int i = 0; i < carreteras; i++) {
				st = new StringTokenizer(in.readLine());
				String node1 = st.nextToken();
				String node2 = st.nextToken();
				int peso = Integer.parseInt(st.nextToken());
				if (!cities.containsKey(node1)) {
					cities.put(node1, index);
					index++;
				}
				if (!cities.containsKey(node2)) {
					cities.put(node2, index);
					index++;
				}
				int a = cities.get(node1);
				int b = cities.get(node2);
				mAdy[a][b] = mAdy[b][a] = Math.max(mAdy[a][b], peso);
			}
			for (int k = 0; k < mAdy.length; k++) {
				for (int i = 0; i < mAdy.length; i++) {
					for (int j = 0; j < mAdy.length; j++) {
						mAdy[i][j] = mAdy[j][i] = Math.max(mAdy[i][j], Math.min(mAdy[i][k], mAdy[k][j]));
					}
				}
			}
			st = new StringTokenizer(in.readLine());
			int a = cities.get(st.nextToken());
			int b = cities.get(st.nextToken());
			out.printf("Scenario #%d%n%d tons%n%n", caso, mAdy[a][b]);
			caso++;
		}

		out.close();
		in.close();
	}
}
