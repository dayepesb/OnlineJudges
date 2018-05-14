package ProblemsIn_Java.NoteBook;

import java.util.StringTokenizer;

public class Matematicas {

	public static void haversine(String args[]) { // distancia entre 2 puntos en
													// la tierra
		final int R = 6371; // or 6378 Radious of the earth

		double lat1 = Double.parseDouble(args[0]);
		double lon1 = Double.parseDouble(args[1]);
		double lat2 = Double.parseDouble(args[2]);
		double lon2 = Double.parseDouble(args[3]);
		double latDistance = (lat2 - lat1) * Math.PI / 180;
		double lonDistance = (lon2 - lon1) * Math.PI / 180;
		double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2) + Math.cos((lat1) * Math.PI / 180)
				* Math.cos((lat2) * Math.PI / 180) * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
		double distance = R * c;
	}

	public static long[] extendsEuclides(int a, int b) {
		long[] res = new long[3];
		if ((b == 0)) {
			res[0] = a;
			res[1] = 1;
			res[2] = 0;
			return res;
		}
		int q = a / b;
		int r = a - b * q;

		long arr[] = extendsEuclides(b, r);
		long x = arr[1];
		long y = arr[2];
		long d = arr[0];

		res[0] = arr[0];
		res[1] = y;
		res[2] = x - q * y;

		return res;
	}

	public static long[][] productoMatriz(long[][] s, long[][] l, int modulo) {
		long r[][] = new long[s.length][l.length];
		for (int i = 0; i < r.length; i++) {
			for (int j = 0; j < r.length; j++) {
				for (int k = 0; k < r.length; k++) {
					r[i][j] += ((s[i][k] * l[k][j]) & modulo);
				}
			}
		}
		return r;
	}

	public static long decimalToBinary(long numero) {
		long dijito;
		long binario = 0;
		long exp = 0L;
		while (numero != 0) {
			dijito = numero & 1;
			binario += dijito * Math.pow(10, exp);
			exp++;
			numero = numero >> 1;
		}
		return binario;
	}

	public static long kadane(long[] arr) { // mayor suma en un arreglo
		long act = 0, r = Long.MIN_VALUE;
		for (long v : arr) {
			act += v;
			if (act > r)
				r = act;
			if (act < 0)
				act = 0;
		}
		return r;
	}

	public static long kadane2D(long[][] mat) { // mayor suma en una matriz
		int m = mat.length, n = m == 0 ? 0 : mat[0].length;
		long r = Long.MIN_VALUE, sumas[][] = new long[m][n], arr[] = new long[n];
		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++)
				sumas[i][j] = mat[i][j] + (i > 0 ? sumas[i - 1][j] : 0);
		for (int i1 = 0; i1 < m; i1++)
			for (int i2 = i1; i2 < m; i2++) {
				for (int j = 0; j < n; j++)
					arr[j] = sumas[i2][j] - (i1 > 0 ? sumas[i1 - 1][j] : 0);
				r = Math.max(r, kadane(arr));
			}
		return r;
	}

	static int[] representacion(int base, long numero) { // de base 10 a
															// cualquier base
		int[] vec = new int[4];
		int basecub = base * base * base;
		int basecuad = base * base;
		vec[0] = (int) (numero / (long) (basecub));
		numero -= vec[0] * basecub;
		vec[1] = (int) (numero / (long) (basecuad));
		numero -= vec[1] * basecuad;
		vec[2] = (int) (numero / (long) (base));
		numero -= vec[2] * base;
		vec[3] = (int) numero;
		return vec;
	}

	public static boolean esPrimo(long n) {
		if (n == 0 || n == 1) {
			return false;
		}
		int multiplos = 0;
		for (int i = 1; i < n + 1; i++) {
			if (n % i == 0) {
				multiplos++;
			}
		}
		if (multiplos != 2) {
			return false;
		}
		return true;
	}

	public static void modularFibonacci(String line) {
		StringTokenizer st = new StringTokenizer(line);
		long f = Long.parseLong(st.nextToken());
		long lim = (1 << Integer. parseInt(st.nextToken())) - 1;
		String bin = Long.toBinaryString(f - 1);
		long[][] M = { { 1, 1 }, { 1, 0 } };
		long[][] pot = M;
		long[][] res = { { 1, 0 }, { 0, 1 } };
		for (int i = bin.length() - 1; i >= 0; i--) {
			if (bin.charAt(i) == '1') {
				res = mult(res, pot, lim);
			}
			pot = mult(pot, pot, lim);
		}
	}
	
	public static int FibonacciPow(long f, long lim){
		lim=(1<<lim)-1;
		String bin=Long.toBinaryString(f-1);
		long [][]M={{1,1},{1,0}};
		long[][]pot=M;
		long[][]res={{1,0},{0,1}};
		for (int i = bin.length()-1; i >=0; i--) {
			if(bin.charAt(i)=='1')					
				res=mult(res, pot,lim);			
			pot=mult(pot, pot,lim);					
		}
		return (int) (f==0?0:res[0][0]&lim);
	}

	public static long[][] mult(long[][] a, long[][] b, long lim) {
		long[][]mult=new long[a.length][a.length];
		for (int i = 0; i < mult.length; i++) {
			for (int j = 0; j < mult.length; j++) {
				for (int k = 0; k < mult.length; k++) {
					mult[i][j]+=a[i][k]*b[k][j];
				}
				mult[i][j]=mult[i][j]&lim;
			}
		}
		return mult;
	}

	public static double cuadratica(double a, double b, double c) {
		if ((b * b) + (-4 * a * c) >= 0) {
			double d = (-b + Math.sqrt((b * b) + (-4 * a * c))) / (2 * a);
			if (d >= 0) {
				return d;
			} else {
				d = (-b - Math.sqrt((b * b) + (-4 * a * c))) / (2 * a);
				return d;
			}
		}
		return -1;
	}

	public static long potenciasRapidasExactas(long a, long n, long mod) {
		String bin = Long.toBinaryString(n);
		long res = 1;
		long pot = a;
		for (int i = bin.length() - 1; i >= 0; i--) {
			if (bin.charAt(i) == '1')
				res = (res * pot) % mod;
			pot = (pot * pot) % mod;
		}
		return res;
	}

	class TeoremaChinoDelResiduo {
		public long teoremaChino(long a, long b, long c, long dias) {
			long[] arr = { 23, 28, 33 };
			long M = 21252;
			long[] f = extendedMCD(arr[1] * arr[2], arr[0]);
			long[] s = extendedMCD(arr[0] * arr[2], arr[1]);
			long[] t = extendedMCD(arr[0] * arr[1], arr[2]);
			long num = ((a * f[1] * M / arr[0]) + (b * s[1] * M / arr[1]) + (c * t[1] * M / arr[2])) % M;
			num -= dias;
			while (num <= 0)
				num += M;
			while (num > M)
				num -= M;
			return num;
		}//Puto el que lo lea

		public long[] extendedMCD(long a, long b) {
			if (b == 0)
				return new long[] { a, 1, 0 };
			// x=A
			long d, x, y;
			long q = a / b;
			long r = a - b * q;
			long[] ant = extendedMCD(b, r);
			d = ant[0];
			x = ant[1];
			y = ant[2];
			return new long[] { d, y, x - y * q };
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
}
