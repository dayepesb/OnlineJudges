package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class DecodeTheTape {

	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader( new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
		for (String line; (line=in.readLine())!=null;) {
			if(line.equals("___________"))continue;
			int b = 1;
			int c = 0;
			line = line.replaceAll("[|^.]","");
			for (int i = 7; i>=0;i--) {
				if(line.charAt(i)=='o'){
					c+=b;
				}
				b*=2;
			}
			out.print((char)c);
		}
		out.close();
		in.close();
	}

}
