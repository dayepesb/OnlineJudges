package ProblemsIn_Java.CodeForces;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class InterestingDrink {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		int n = Integer.parseInt(in.readLine().trim());
		int arr[] = new int[n];
		StringTokenizer st = new StringTokenizer(in.readLine());
		for (int i = 0; st.hasMoreTokens(); i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int cons = Integer.parseInt(in.readLine().trim());
		int[] bottle = new int[cons];
		for (int i = 0; i < cons; i++) {
			bottle[i] = Integer.parseInt(in.readLine().trim());
		}
		int[] answer = new int[100001];
		for (int i = 0; i < n - 1; ++i) {
			for (int j = arr[i]; j <= arr[i + 1]; ++j)
				answer[j] = i + 1;
		}
		for (int j = arr[n - 1]; j < answer.length; ++j)
			answer[j] = n;

		// Display the result
		for (int i = 0; i < cons; ++i) {
			if (bottle[i] >= 100000)
				out.println(n);
			else
				out.println(answer[bottle[i]]);
		}

		out.close();
		in.close();
	}

	static int busquedaBinaria(long[] arr, int a, int b, long v) {
		while (a <= b) {
			int m = (a + b) >> 1;
			long p = arr[m];
			if (p < v) {
				a = m + 1;
			} else if (p > v) {
				b = m - 1;
			} else
				return m;
		}
		return -(a + 1);
	}
}
