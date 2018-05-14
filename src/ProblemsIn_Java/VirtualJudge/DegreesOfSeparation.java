package ProblemsIn_Java.VirtualJudge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author david yepes buitrago
 * @date 10-01-2018
 * @time 0.000 ms
 */
public class DegreesOfSeparation {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner in = new Scanner(br);
		PrintWriter out = new PrintWriter(System.out);
		int mAdy[][];
		HashMap<String, Integer> map;
		int node, p, r, tc = 1;
		while (true) {
			p = in.nextInt();
			r = in.nextInt();
			if (p + r == 0)
				break;
			map = new HashMap<>();
			mAdy = new int[p][p];
			node = 0;
			for (int i = 0; i < p; Arrays.fill(mAdy[i], Integer.MAX_VALUE / 3), mAdy[i][i] = 0, i++)
				;
			for (int i = 0; i < r; i++) {
				String a = in.next();
				String b = in.next();
				if (!map.containsKey(a))
					map.put(a, node++);
				if (!map.containsKey(b))
					map.put(b, node++);
				mAdy[map.get(a)][map.get(b)] = mAdy[map.get(b)][map.get(a)] = 1;
			}
			for (int k = 0; k < p; k++) {
				for (int i = 0; i < p; i++) {
					for (int j = 0; j < p; j++) {
						mAdy[i][j] = Math.min(mAdy[i][j], mAdy[i][k] + mAdy[k][j]);
					}
				}
			}
			int max = Integer.MIN_VALUE;
			for (int[] is : mAdy) {
				for (int i : is) {
					max = Math.max(max, i);
				}
			}
			out.printf("Network %d: %s%n%n", tc++, (max == Integer.MAX_VALUE / 3 ? "DISCONNECTED" : max + ""));
		}
		in.close();
		out.close();
	}
}
