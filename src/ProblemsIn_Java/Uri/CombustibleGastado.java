package ProblemsIn_Java.Uri;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class CombustibleGastado {

	public static void main(String[] args)  throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		for(String line;(line=in.readLine())!=(null);){
			out.printf("%.3f%n",Double.parseDouble(line)*Double.parseDouble(in.readLine())/((double)12));
		}		
		in.close();
		out.close();
	}
}
