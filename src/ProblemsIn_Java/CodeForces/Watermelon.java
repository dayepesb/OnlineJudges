package ProblemsIn_Java.CodeForces;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Watermelon {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for (String line; (line=in.readLine())!=null;) {
			int s = Integer.parseInt(line);
			System.out.println(s>3&&s%2==0?"YES":"NO");
		}
		in.close();
	}
}
