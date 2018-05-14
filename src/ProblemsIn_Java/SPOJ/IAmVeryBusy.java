package ProblemsIn_Java.SPOJ;
/**
 * @author david
 * @time  Time Limit
 * 
 * no se sabe porque da time limit se hizo de la mejor manera  se realizo en c++ y paso
 * 
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class IAmVeryBusy {

	public static void main(String[] args) throws Exception {
		BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
		Scanner in = new Scanner(f);
		PrintWriter out = new PrintWriter(System.out);

		int t = in.nextInt();
		while (t-- > 0) {
			int n = in.nextInt();
			pareja array[] = new pareja[n];

			for (int i = 0; i < n; i++) {
				long l = in.nextLong();
				long r = in.nextLong();
				array[i] = new pareja(l, r);
			}

			Arrays.sort(array);

			long cont = 0;
			long time = -1;
			for (int i = 0; i < n; i++) {
				if (array[i].start >= time) {
					cont += 1;
					time = array[i].end;
				}
			}
			out.printf("%d\n", cont);
		}

		out.close();
		in.close();
	}

	static class pareja implements Comparable<pareja> {
		long start;
		long end;

		public pareja(long r, long l) {
			this.start = r;
			this.end = l;
		}

		@Override
		public int compareTo(pareja b) {
			if (this.end<b.end) {
				return -1;
			}
			if (this.end==b.end) {
				return Long.compare(this.start, b.start);
			}
			return 1;
		}
	}
}
