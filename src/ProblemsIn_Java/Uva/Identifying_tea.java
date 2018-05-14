package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Identifying_tea {

	public static void main(String[] args)throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for (String te;(te = in.readLine())!= null;) {
			int acertos = 0;
			String [] pruevas = in.readLine().split("");
			for (int i = 0; i < pruevas.length; i++) {
				if(pruevas[i].equals(te)){
					acertos++;
				}
			}
			out.write(acertos+"\n");
		}

		in.close();
		out.close();
	}

}
