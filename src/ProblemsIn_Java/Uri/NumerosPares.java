package ProblemsIn_Java.Uri;

import java.io.PrintWriter;

public class NumerosPares {
public static void main(String[] args) {
	PrintWriter out = new PrintWriter(System.out);
	for (int i = 2; i <= 100; i+=2) {
		out.println(i);
	}
	out.close();
}
}
