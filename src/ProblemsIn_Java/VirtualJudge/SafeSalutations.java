package ProblemsIn_Java.VirtualJudge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author david yepes buitrago
 * @date 18-02-2018
 * @time 0.000 ms
 */
public class SafeSalutations {
	public static void main(String[] args) throws IOException {
		// BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		int array[] = new int[11];
		array[0] = 1;
		array[1] = 1;
		for (int i = 2; i <= 10; i++)
			for (int j = 0; j < i; j++)
				array[i] += array[j] * array[i - j - 1];

		int index = 0;
		while (in.hasNext()) {
			int n = in.nextInt();
			if (index > 0)
				out.println();
			out.println(array[n]);
			index++;
		}

		in.close();
		out.close();
	}
}
