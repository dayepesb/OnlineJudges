package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class EcologicalPremium {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int noOfCases = in.nextInt();
		int noOfFarmers;
		long size;
		long degree;
		long sum;
		while ((noOfCases--) > 0) {
			sum = 0;
			noOfFarmers = in.nextInt();
			while ((noOfFarmers--) > 0) {
				size = in.nextInt();
				in.nextInt();
				degree = in.nextInt();
				sum += size * degree;
			}
			System.out.println(sum);
		}
	}
}
