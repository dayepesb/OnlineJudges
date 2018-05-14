package ProblemsIn_Java.Uri;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Area {
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		for(String line;(line=in.readLine())!=null;){
			StringTokenizer st = new StringTokenizer(line.trim());
			double a = Double.parseDouble(st.nextToken());
			double b = Double.parseDouble(st.nextToken());
			double c = Double.parseDouble(st.nextToken());
			out.printf("TRIANGULO: %.3f%n",a*c/2);
			out.printf("CIRCULO: %.3f%n",3.14159*c*c);
			out.printf("TRAPEZIO: %.3f%n",(a+b)*c/2);
			out.printf("QUADRADO: %.3f%n",b*b);
			out.printf("RETANGULO: %.3f%n",a*b);
		}		
		in.close();
		out.close();
	}
}
