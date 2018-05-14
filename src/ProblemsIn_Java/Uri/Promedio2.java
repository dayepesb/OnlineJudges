package ProblemsIn_Java.Uri;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Promedio2 {
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		for(String line;(line=in.readLine())!=(null);){
			double a = Double.parseDouble(line);
			double b = Double.parseDouble(in.readLine());
			double c= Double.parseDouble(in.readLine());
			out.printf("MEDIA = %.1f%n",a*0.2+b*0.3+c*0.5);
		}		
		in.close();
		out.close();
	}
}
