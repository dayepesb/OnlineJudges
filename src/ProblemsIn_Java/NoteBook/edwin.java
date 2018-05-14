package ProblemsIn_Java.NoteBook;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

class Main {

	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {
		long p = Long.parseLong(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine());
		while (st.countTokens() > 1) {
			long a = Long.parseLong(st.nextToken());
			long b = Long.parseLong(st.nextToken());
			if (a == 1 && b == 1)
				System.out.println(1);
			else if (a == 1 && b != 1)
				System.out.println(0);
			else {
				long q = log(a, b, p);
				if (q < 0)
					System.out.println(0);
				else if (q == 0)
					System.out.println(p - 1);
				else
					System.out.println(q);
			}
			st = new StringTokenizer(in.readLine());
		}
	}

	static long computeTotient(int n) {

		long phi[] = new long[n + 1];
		for (int i = 1; i <= n; i++)
			phi[i] = i;
		for (int p = 2; p <= n; p++) {
			if (phi[p] == p) {
				phi[p] = p - 1;
				for (int i = 2 * p; i <= n; i += p) {
					phi[i] = (phi[i] / p) * (p - 1);
				}
			}
		}

		long s = 0;
		for (int i = 1; i <= n; i++)
			s += phi[i];
		return s;
	}

	static long log(long a, long b, long n) {
		long m = (long) (Math.ceil(Math.sqrt(tot(n, false)) + .1));
		long inv = mod_pow(mod_inv(a, n), m, n);
		HashMap<Long, Long> pots = new HashMap<Long, Long>();
		long aa = 1;
		for (long xb = 0; xb < m; xb++) {
			pots.put(aa, xb);
			aa = aa * a % n;
		}
		long q = b;
		for (long xg = 0; xg < m; xg++) {
			if (pots.containsKey(q))
				return xg * m + pots.get(q);
			q = (q * inv) % n;
		}
		return -1;
	}

	static long tot(long n, boolean prime) {
		return n - 1;
	}
	// ESTO EST� COMENTADO PORQUE EN EL PROBLEMA N SIEMPRE ES PRIMO
	// static long tot(long n, boolean prime){
	// if (prime) return n-1;
	// double phi = n;
	// for (long p=2; p*p<=n;p++){
	// if (n % p == 0){
	// while (n % p == 0) n/=p;
	// phi *= (1D-(1D/(double)p));
	// }
	// }
	// if (n>1)
	// phi *= (1D-(1D/(double)n));
	// return (long)phi;
	// }

	// potenciacion modular
	static long mod_pow(long a, long b, long n) {
		long p = 1;
		while (b > 0) {
			if ((b & 1L) == 1)
				p = p * a % n;
			a = a * a % n;
			b = b >> 1;
		}
		return p;
	}

	// pre: gcd(a, n) = 1
	static long mod_inv(long a, long n) {
		long q = gcd(a, n)[1];
		return (q + n) % n;
	}

	// returns [g, x, y]
	static long[] gcd(long a, long b) {
		if (b == 0)
			return new long[] { a, 1, 0 };
		long[] r = gcd(b, a % b);
		return new long[] { r[0], r[2], r[1] - (a / b) * r[2] };
	}
}