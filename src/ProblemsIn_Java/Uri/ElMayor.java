package ProblemsIn_Java.Uri;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ElMayor {
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		for(String line;(line=in.readLine())!=(null);){
			StringTokenizer tk = new StringTokenizer(line);
			int a [] = new int [3];
			for (int i = 0; i < a.length;a[i]=Integer.parseInt(tk.nextToken()), i++);
			Arrays.sort(a);
			out.println(a[a.length-1]+" eh o maior");
		}		
		in.close();
		out.close();
	}
}
