package ProblemsIn_Java.Uva;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class WhatIsTheMedian {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		ArrayList<Integer> nos = new ArrayList<Integer>();
		int n = 0;
		while (in.hasNext()) {
			n = in.nextInt();
			nos.add(n);
			Collections.sort(nos);
			int median = (nos.size() > 1 && nos.size() % 2 == 0
					? (nos.get((nos.size() - 1) / 2) + nos.get(nos.size() / 2)) / 2 : nos.get((nos.size() - 1) / 2));
			out.println(median);
		}
		out.close();
	}
}
