package ProblemsIn_Java.VirtualJudge;

<<<<<<< HEAD
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.StringTokenizer;
=======
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;
>>>>>>> 81f1303ab769b8457f1bec4924a152732ffed497

/**
 * @author david yepes buitrago
 * @date 21-01-2017
 * @time 0.000 ms
 */
public class CakeyMcCakeFace {
	public static void main(String[] args) throws IOException {
<<<<<<< HEAD
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		StringTokenizer st;
		long[] A, B;
		int n, m;
		String line;
		while (true) {
			line = in.readLine();
			if (line == null)
				break;
			n = Integer.parseInt(line.trim());
			m = Integer.parseInt(in.readLine().trim());
			A = new long[n];
			B = new long[m];
			st = new StringTokenizer(in.readLine());
			for (int i = 0; i < n; A[i] = Integer.parseInt(st.nextToken()), i++);
			st = new StringTokenizer(in.readLine());
			for (int i = 0; i < m; B[i] = Integer.parseInt(st.nextToken()), i++);
			HashMap<Long, Long> R = new HashMap<>();
			for (int i = 0, ii = 0; i < n; i++) {
				while (ii < m && B[ii] <= A[i])
					ii++;
				long v = A[i];
				for (int j = ii; j < m; j++) {
					if (R.containsKey(B[j] - v))
						R.put(B[j] - v, R.get(B[j] - v) + 1);
					else
						R.put(B[j] - v, (long) 1);
				}
			}
			long mx = 0, ret = 0;
			for (Entry<Long, Long> e : R.entrySet()) {
				if (e.getValue() > mx) {
					mx = e.getValue();
					ret = 32767;
				}
				if (e.getValue() == mx)
					ret = Math.min(ret, e.getKey());
			}
			out.println(ret);
=======
//		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		int n, m;
		while (in.hasNext()) {
			n = in.nextInt();
			m=in.nextInt();
			int A[]=new int[n];
			int B[]=new int[n];
			for (int i = 0; i < n; i++)
				A[i]=in.nextInt();
			for (int i = 0; i < m; i++)
				B[i]=in.nextInt();
			
>>>>>>> 81f1303ab769b8457f1bec4924a152732ffed497
		}

		in.close();
		out.close();
	}
}
