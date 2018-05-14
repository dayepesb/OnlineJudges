package ProblemsIn_Java.Uri;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class CoordenadasDeUnPunto {
	public static void main(String[] args) throws IOException {
		float X, Y;
		Scanner in = new Scanner(System.in);
		StringTokenizer st = new StringTokenizer(in.nextLine());
		X = Float.parseFloat(st.nextToken());
		Y = Float.parseFloat(st.nextToken());
		if (X == 0.0 && Y == 0.0) {
			System.out.print("Origem\n");
		} else if (X == 0.0 && Y != 0.0) {
			System.out.print("Eixo Y\n");
		} else if (Y == 0.0 && X != 0.0) {
			System.out.print("Eixo X\n");
		} else if (X > 0.0 && Y > 0.0) {
			System.out.print("Q1\n");
		} else if (X < 0.0 && Y < 0.0) {
			System.out.print("Q3\n");
		} else if (X < 0.0 && Y > 0.0) {
			System.out.print("Q2\n");
		} else {
			System.out.print("Q4\n");
		}
	}
}