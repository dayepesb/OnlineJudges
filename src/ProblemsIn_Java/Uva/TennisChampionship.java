package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class TennisChampionship {

	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		for (String line;!((line=in.readLine())== null);) {
			
			long i = Long.parseLong(line.trim());
			out.write(i-1+"\n");
		
		}
		
		
		out.close();
		in.close();
	}

}
