package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class HistoryGrading {

	static int a[], b[], num,memo[][];

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		// if(i==a.length||j==b.length)return 0;
		// if(a[i]==b[j])return f(i+1,j+1)+1
		// max(f(i,j+1),f(i+1,j))

		num = Integer.parseInt(in.readLine().trim());
		b = new int[num];
		a = new int[num];
		memo=new int[num+1][num+1];
		
		StringTokenizer st = new StringTokenizer(in.readLine());

		int i = 0;
		while (st.hasMoreTokens()) {
			b[i++] = Integer.parseInt(st.nextToken());
		}
		for (String line; (line = in.readLine()) != null;) {
			for (int j = 0; j < memo.length; j++) 
				Arrays.fill(memo[j], -1);
			i = 0;
			st = new StringTokenizer(line);
			while (st.hasMoreTokens()) {
				a[i++] = Integer.parseInt(st.nextToken());
			}
			out.println(funcion(0, 0));
		}
		out.close();
		in.close();
	}
	static int funcion(int i, int j) {
		if(memo[i][j]!=-1)
			return memo[i][j];
		if (i == a.length || j == b.length)
			return 0;
		if (a[i] == b[j]){
			return memo[i][j]=funcion(i + 1, j + 1) + 1;
		}
		return (memo[i][j]=(Math.max(funcion(i, j + 1), funcion(i + 1, j))));
	}
}