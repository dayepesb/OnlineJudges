package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

public class RotatingSetences {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		ArrayList<String> list = new ArrayList<String>();
		StringBuffer sb = new StringBuffer();
		String line;
		int max = 0;
		while ((line = in.readLine()) != null) {
			list.add(line);
			if (line.length() > max)
				max = line.length();
		}

		for (int m = 0; m < max; m++) {
			for (int i = list.size()-1; i >= 0 ; i--) {
				line = list.get(i);
				if(line.length()>m){
					sb.append(line.charAt(m));
				}else{
					sb.append(" ");
				}
			}
			out.println(sb.toString());
			sb.delete(0, sb.length());
		}

		out.close();
		in.close();
	}
}
