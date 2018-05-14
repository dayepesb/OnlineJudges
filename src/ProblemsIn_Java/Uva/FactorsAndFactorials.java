package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;

public class FactorsAndFactorials {

	static int[] Primes;
	static int Top;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
		
		
		solution(100000);

		while (true) {
			int n = Integer.parseInt(in.readLine());
			
			if (n == 0)	break;

			int[] coun = new int[Top];
			if (n == 1)
				out.println(" 1! = 0");
			else {
				int count = -1;
				for (int k = n; k >= 2; k--) {
					int temp = k;
					for (int i = Primes[k]; i >= 0; i--) {
						while (temp % Primes[i] == 0) {
							coun[i]++;
							temp /= Primes[i];

							if (i > count){
								count = i;
							}
						}
					}
				}

				out.printf("%3d! =", n);
				for (int i = 0; i < count + 1; i++) {
					out.printf("%3d", coun[i]);
					if (i % 14 == 0 && i > 0 && count > 14){
						out.print("\n      ");
					}
				}
				out.println();
			}
		}
		
		out.close();
		in.close();
	}
	
	public static void solution(int x) {
		int[] numbers = new int[x];
		boolean[] primes = new boolean[x];
		Arrays.fill(primes, true);
		Primes = new int[x];
		Top = 0;

		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = i;
		}
		primes[0] = false;
		primes[1] = false;

		int m = (int) Math.sqrt(numbers.length);
		for (int i = 2; i <= m; i++) {
			if (primes[i]) {
				Primes[Top++] = numbers[i];
				for (int j = i * i; j < numbers.length; j += i) {
					primes[j] = false;
				}
			}
		}

		for (int i = (int) Math.sqrt(numbers.length); i < numbers.length; i++) {
			if (primes[i]) {
				Primes[Top++] = numbers[i];
			}
		}
	}
}