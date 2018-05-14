package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class DivisionOfNlogonia {

	public static void main(String args[]) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

		StringTokenizer st;
		String line;
		int n;

		while ((line = in.readLine()) != null) {
			n = Integer.parseInt(line);
			
			if (n == 0) {
				break;
			}
			
			int cx, cy, x, y;
			st = new StringTokenizer(in.readLine());
			cx = Integer.parseInt(st.nextToken());
			cy = Integer.parseInt(st.nextToken());
			
			for (int i=0; i<n; ++i) {
				st = new StringTokenizer(in.readLine());
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				out.println(getRegion(cx, cy, x, y));
			}
		}
		in.close();
		out.close();
	}
	
	public static String getRegion(int cx, int cy, int x, int y) {
		
		// on border
		if (x == cx || y == cy) {
			return "divisa";
		}
		
		// on right
		if (x > cx) {
			if (y > cy) {
				return "NE";
			}
			else {
				return "SE";
			}
		} else {
			
			//on left
			if (y > cy) {
				return "NO";
			}
			else
				return "SO";
		}
	}
}