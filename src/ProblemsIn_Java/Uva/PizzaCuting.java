package ProblemsIn_Java.Uva;

import java.util.Scanner;

public class PizzaCuting {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		long n;
		n =in.nextLong();
		while(n>=0){
			System.out.println(n*(n+1)/2+1);
			n =in.nextLong();
		}
	}
}
