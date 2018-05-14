package ProblemsIn_Java.VirtualJudge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author david yepes buitrago
 * @date 02-08-2017
 * @time 0.288 ms
 */
public class BoxAndBall {
	public static void main(String[] args) throws IOException {
		BufferedReader tec = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		for (String line; (line = tec.readLine()) != null;) {
			StringTokenizer st = new StringTokenizer(line);
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int[] arr = new int[n];
			Arrays.fill(arr, 1);
			int cont = 1;
			boolean[] pos = new boolean[n];
			pos[0] = true;
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(tec.readLine());
				int a = Integer.parseInt(st.nextToken()) - 1;
				int b = Integer.parseInt(st.nextToken()) - 1;
				arr[a]--;
				arr[b]++;
				if (pos[a]) {
					if (!pos[b])
						cont++;
					pos[b] = true;
				}
				if (arr[a] == 0) {
					if (pos[a])
						cont--;
					pos[a] = false;
				}
			}
			out.println(cont);
		}
		out.close();
	}
}
