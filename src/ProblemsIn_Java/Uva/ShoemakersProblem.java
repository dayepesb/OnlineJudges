package ProblemsIn_Java.Uva;

import java.io.*;
import java.util.*;

public class ShoemakersProblem {
	static BufferedReader in;

	public static void main(String[] args) throws Exception {
		in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
		for (int test = 1, numTests = nextInt(); test <= numTests; test++) {
			int N = nextInt(), array[][] = new int[N][];
			for (int i = 0; i < N; i++)
				array[i] = new int[] { nextInt(), nextInt(), i + 1 };
			Arrays.sort(array, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					int a = o1[1] * o2[0], b = o1[0] * o2[1];
					if (a > b)
						return -1;
					else if (a < b)
						return 1;
					else if (o1[2] < o2[2])
						return -1;
					else if (o1[2] > o2[2])
						return 1;
					else
						return 0;
				}
			});
			StringBuilder sb = new StringBuilder(String.valueOf(array[0][2]));
			for (int i = 1; i < N; i++)
				sb.append(" " + array[i][2]);
			if (test > 1)
				out.println();
			out.println(sb);
		}
		out.close();

	}

	static StringTokenizer stk = new StringTokenizer("");

	static int nextInt() throws IOException {
		while (!stk.hasMoreTokens())
			stk = new StringTokenizer(in.readLine());
		return Integer.parseInt(stk.nextToken());
	}

}