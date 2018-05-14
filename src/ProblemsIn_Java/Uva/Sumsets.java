package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Sumsets {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		String m = "";
		while (true) {
			int n = Integer.parseInt(br.readLine());
			if (n == 0) {
				break;
			}
			long[] arr = new long[n];
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(br.readLine().trim());
			}
			Arrays.sort(arr);
			boolean flag = false;
			long max = Integer.MIN_VALUE;
			for (int i = n - 1; i > -1; i--) {
				for (int j = 0; j < n; j++) {
					if (arr[i] == arr[j]) {
						continue;
					}
					for (int z = j + 1; z < n; z++) {
						if (arr[z] == arr[i]) {
							continue;
						}
						for (int k = z + 1; k < n; k++) {
							if (arr[k] == arr[i]) {
								continue;
							}
							if (arr[i] == (arr[j] + arr[k] + arr[z])) {
								sb.append(arr[i]).append("\n");
								flag = true;
								break;
							}
						}
						if (flag) {
							break;
						}
					}
					if (flag) {
						break;
					}
				}
				if (flag) {
					break;
				}
			}
			if (!flag) {
				sb.append("no solution\n");
			}
		}
		System.out.print(sb);
	}
}