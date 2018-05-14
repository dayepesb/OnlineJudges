package ProblemsIn_Java.Notebook_Camus.Mathematics;

public teoremaChino(long a, long b, long c, long dias) {
	long[] arr = { 23, 28, 33 };
	long M = 21252;
	long[] f = extendedMCD(arr[1] * arr[2], arr[0]);
	long[] s = extendedMCD(arr[0] * arr[2], arr[1]);
	long[] t = extendedMCD(arr[0] * arr[1], arr[2]);
	long num = ((a * f[1] * M / arr[0]) + (b * s[1] * M / arr[1]) + (c * t[1] * M / arr[2])) % M;
	num -= dias;
	while (num <= 0) num += M;
	while (num > M) num -= M;
	return num;
}
