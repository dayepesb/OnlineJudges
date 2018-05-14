package ProblemsIn_Java.CodeForces;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NextRound {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;
		int k, n, arr[];
		for (String line; (line = in.readLine()) != null;) {
			st = new StringTokenizer(line);
			k = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			arr = new int[k];
			st = new StringTokenizer(in.readLine());
			for (int i = 0; i < arr.length; arr[i] = Integer.parseInt(st.nextToken()), i++)
				;
			int count = 0;
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] >= arr[n - 1] && arr[i] != 0)
					count++;
			}
			System.out.println(count);
		}

		in.close();
	}
}
