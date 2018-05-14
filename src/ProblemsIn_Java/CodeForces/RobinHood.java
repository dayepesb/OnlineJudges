package ProblemsIn_Java.CodeForces;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class RobinHood {

	static long ll;
	static long sum;
	static int a[];
	static int n, k, pre;

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		a = new int[n];
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
			sum += a[i];
		}
		Arrays.sort(a);
		int l1 = (int) (sum / n), r1 = (int) ((sum + n - 1) / n);
		int l = 0, r = l1, ansl = 0;
		while (l <= r) {
			int mid = (l + r) / 2;
			long need = 0;
			for (int i = 0; i < n; i++)
				if (a[i] <= mid)
					need += mid - a[i];
			if (need <= k) {
				ansl = mid;
				l = mid + 1;
			} else
				r = mid - 1;
		}
		l = r1;
		r = (int) 1e9;
		int ansr = 0;
		while (l <= r) {
			int mid = (l + r) / 2;
			long need = 0;
			for (int i = 0; i < n; i++)
				if (a[i] > mid)
					need += a[i] - mid;
			if (need <= k) {
				ansr = mid;
				r = mid - 1;
			} else
				l = mid + 1;
		}
		System.out.println(ansr - ansl);

		in.close();
	}
}
