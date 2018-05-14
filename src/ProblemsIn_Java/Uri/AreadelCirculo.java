package ProblemsIn_Java.Uri;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class AreadelCirculo {
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		for(String line;(line=in.readLine())!=null;){
			double d = Double.parseDouble(line.trim());
			out.printf("A=%.4f%n",((double)Math.round(3.14159*d*d*10000))/10000);
		}		
		in.close();
		out.close();
	}
}
