package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class f91 {

	public static void main(String[] args)throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
		for (String line; !((line = in.readLine()).equals("0"));) {
			long n = Long.parseLong(line.trim());
			out.println("f91("+n+") = " + recursion(n));
		}
		
		
		out.close();
		in.close();	
	}
	public static long recursion (long n){
		if(n<=100){
			return recursion(recursion(n+11));
		}else{
			return n-10;
		}
	}

}
