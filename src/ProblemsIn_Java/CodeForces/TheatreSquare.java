package ProblemsIn_Java.CodeForces;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TheatreSquare {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (String line;(line=in.readLine())!=null;) {
			st = new StringTokenizer(line);
			double m = Double.parseDouble(st.nextToken()),n=Double.parseDouble(st.nextToken()),a = Double.parseDouble(st.nextToken());
			System.out.println((long)(Math.ceil(m/a)*Math.ceil(n/a)));
		}
	}

}
