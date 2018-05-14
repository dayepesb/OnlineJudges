package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class TexQuotes {

	public static void main(String[] args)throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
		boolean b = false;
		for (String line;!((line=in.readLine())==null);) {
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < line.length(); i++) {
				if(line.charAt(i)=='"'){
					if(b){
						sb.append("''");
						b=!b;
					}else{
						sb.append("``");
						b=!b;
					}
				}else{
					sb.append(line.charAt(i));
				}
			}
			out.println(sb);
		}
		
		out.close();
		in.close();
	}

}
