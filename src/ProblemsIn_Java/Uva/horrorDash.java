package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class horrorDash {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

		int casos = Integer.parseInt(in.readLine());
		StringTokenizer st;
		for (int i = 0; i < casos; i++) {
			st = new StringTokenizer(in.readLine());
			int mayor = Integer.MIN_VALUE;
			int s;
			while(st.hasMoreTokens()){
				s = Integer.parseInt(st.nextToken());
				if(s>mayor){
					mayor=s;
				}
			}
			
			out.printf("Case %d: %d%n", i + 1, mayor);
		}

		out.close();
		in.close();
	}

}
