package ProblemsIn_Java.Uri;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class PruebaDeSeleccion1 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		for (String line;(line = in.readLine())!=null;) {
			StringTokenizer st = new StringTokenizer(line);
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			if((b>c)&&(d>a)&&((c+d)>(a+b))&&(c>=0&&d>=0)&&a%2==0){
				out.println("Valores aceitos");
			}else{
				out.println("Valores nao aceitos");
			}
		}

		out.close();
		in.close();
	}
}
