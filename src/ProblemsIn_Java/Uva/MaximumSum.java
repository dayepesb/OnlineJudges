package ProblemsIn_Java.Uva;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class MaximumSum {

	public static void main(String[] args) throws Exception{
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

		int n;
		long [][] matriz;
		
		while(in.hasNext()){
			n = in.nextInt();
			matriz = new long [n][n];
			for (int i = 0; i < matriz.length; i++) {
				for (int j = 0; j < matriz.length; j++) {
					matriz[i][j]=in.nextLong();
				}
			}
			out.println(kadane2D(matriz));
		}
		
		
		out.close();
		in.close();
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
}
