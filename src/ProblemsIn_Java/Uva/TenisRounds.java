package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class TenisRounds {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

		int n,x,y;
		StringTokenizer st;

		for (String line; (line =in.readLine())!=null; ) {
			st = new StringTokenizer(line);
			n = Integer.parseInt(st.nextToken());
			x= Integer.parseInt(st.nextToken());
			y= Integer.parseInt(st.nextToken());
			int ans = 0;
			for (int i = 0; i < n; i++) {
				x = (x+1)/2;
				y = (y+1)/2;
				ans++;
				if(x==y)break;
			}
			out.println(ans);
		}

		out.close();
		in.close();
	}
}
