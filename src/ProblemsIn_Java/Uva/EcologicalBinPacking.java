package ProblemsIn_Java.Uva;

import java.io.PrintWriter;
import java.util.Scanner;

public class EcologicalBinPacking {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out, true);

		char[] bottleType = { 'B', 'G', 'C' };
		int[][] permutations = { { 0, 1, 2 }, { 0, 2, 1 }, { 1, 0, 2 }, { 1, 2, 0 }, { 2, 0, 1 }, { 2, 1, 0 } };
		int[][] bottles = new int[3][3];
		while (in.hasNextInt()) {
			int minCount = -1;

			String minPerm = "";

			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					bottles[i][j] = in.nextInt();
				}
			}

			for (int i = 0; i < permutations.length; i++) {

				int curCount = 0;

				for (int j = 0; j < 3; j++) {
					for (int k = 0; k < 3; k++) {
						if (permutations[i][j] != k) {
							curCount += bottles[j][k];
						}
					}
				}

				String curPerm = "" + bottleType[permutations[i][0]] + bottleType[permutations[i][1]]
						+ bottleType[permutations[i][2]];
				if (minCount == -1 || curCount < minCount || (curCount == minCount && curPerm.compareTo(minPerm) < 0)) {
					minCount = curCount;
					minPerm = curPerm;
				}
			}

			out.println(minPerm + " " + minCount);
		}
		in.close();
		out.close();
	}
}
