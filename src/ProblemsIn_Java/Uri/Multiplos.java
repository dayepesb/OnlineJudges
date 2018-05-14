package ProblemsIn_Java.Uri;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class Multiplos {
	public static void main(String[] args) throws Exception {
		BufferedReader inAux = new BufferedReader(new InputStreamReader(System.in));
		Scanner in = new Scanner(inAux);
		PrintWriter out = new PrintWriter(System.out);
		int a = in.nextInt(),b=in.nextInt();
		if(b%a==0||a%b==0){
			out.println("Sao Multiplos");
		}else{
			out.println("Nao sao Multiplos");
		}

		out.close();
		in.close();
	}
}
