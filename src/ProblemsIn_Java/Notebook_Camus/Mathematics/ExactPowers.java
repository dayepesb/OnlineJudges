package ProblemsIn_Java.Notebook_Camus.Mathematics;

public long potenciasRapidasExactas(long a, long n, long mod) {
	String bin = Long.toBinaryString(n);
	long res = 1; long pot = a;
	for (int i = bin.length() - 1; i >= 0; i--) {
		if (bin.charAt(i) == '1')
			res = (res * pot) % mod;
		pot = (pot * pot) % mod;
	}
	return res;
}