package ProblemsIn_Java.Uri;

import java.util.Scanner;

public class PositivesAndAverage {

	public static void main(String[] args) {

		float n1, total = 0, average = 0;
		int totalNumber = 0;
		Scanner sc = new Scanner(System.in);
		for (int i = 1; i <= 6; i++) {
			n1 = sc.nextFloat();
			if (n1 > 0) {
				totalNumber += 1;
				total += n1;
			}
		}
		average = total / totalNumber;

		System.out.print(totalNumber + " valores positivos\n");
		System.out.printf("%.1f\n", average);
	}

}