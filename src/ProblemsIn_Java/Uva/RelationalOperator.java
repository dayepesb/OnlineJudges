package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class RelationalOperator {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
		
		int casos = Integer.parseInt(in.readLine().trim());
		StringTokenizer st;
		for (int i = 0; i < casos; i++) {
			st = new StringTokenizer(in.readLine());
			int a  = Integer.parseInt(st.nextToken());
			int b  = Integer.parseInt(st.nextToken());
			
			if(a>b){
				out.println(">");
			}else if(a<b){
				out.println("<");
			}else{
				out.println("=");
			}
		}
		
		out.close();
		in.close(); 
	}
}
