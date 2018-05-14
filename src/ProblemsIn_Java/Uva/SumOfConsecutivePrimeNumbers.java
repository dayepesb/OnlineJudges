package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

public class SumOfConsecutivePrimeNumbers {

	static int[] temp = new int[10001];

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		preCal();
		while (true) {
			int n = Integer.parseInt(in.readLine().trim());
			if (n == 0) {
				break;
			}
			out.println(temp[n]);
		}
		out.close();
	}

	static void preCal() {
		ArrayList<Integer> prime = new ArrayList<Integer>();
		prime.add(2);
		prime.add(3);
		for (int i = 4; i <= 10000; i++) {
			boolean p = true;
			for (int j = 2; j * j <= i; j++) {
				if (i % j == 0) {
					p = false;
					break;
				}
			}
			if (p) {
				prime.add(i);
			}
		}
		for (int i = 0; i < prime.size(); i++) {
			int tot = 0;
			for (int j = i; j < prime.size(); j++) {
				tot += prime.get(j);
				if (tot > 10000) {
					break;
				}
				temp[tot]++;
			}
		}
	}
}