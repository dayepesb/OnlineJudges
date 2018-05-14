package ProblemsIn_Java.Uri;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class EdadEnDias {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		for (String line; (line = in.readLine())!=null;) {
			int dias = Integer.parseInt(line);
			int anosRes = dias/365;
			dias-=(365*anosRes);
			int mesRes = dias/30;
			dias-=(30*mesRes);
			out.printf("%d ano(s)%n%d mes(es)%n%d dia(s)%n",anosRes,mesRes,dias);

		}
		in.close();
		out.close();
	}
}
