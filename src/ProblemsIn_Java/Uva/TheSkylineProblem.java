package ProblemsIn_Java.Uva;

import java.util.*;

public class TheSkylineProblem {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		int[] line = new int[10001];

		while (s.hasNext()) {
			int xs = s.nextInt();
			int h = s.nextInt();
			int xf = s.nextInt();

			for (int i = xs; i < xf; ++i) {
				line[i] = Math.max(line[i], h);
			}
		}

		int cur = 0;
		int index;

		for (index = 0; index < 10001; ++index) {
			if (line[index] != cur) {
				cur = line[index];
				System.out.print(index + " " + line[index]);
				break;
			}
		}

		for (int i = index; i < 10000; ++i) {
			if (line[i] != cur) {
				System.out.print(" " + i + " " + line[i]);
				cur = line[i];
			}
		}

		System.out.println();
		s.close();
	}
}