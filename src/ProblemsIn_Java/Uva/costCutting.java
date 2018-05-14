package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class costCutting {
	public static void main(String[] args)throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
		int casos = Integer.parseInt(in.readLine().trim());
		StringTokenizer st;
		int array [] = new int [3];
		for (int i = 0; i < casos; i++) {
			st = new StringTokenizer(in.readLine());
			array[0] =Integer.parseInt(st.nextToken());
			array[1] =Integer.parseInt(st.nextToken());
			array[2] =Integer.parseInt(st.nextToken());
			Arrays.sort(array);
			out.printf("Case %d: %d%n",i+1,array[1]);
		}
		out.close();
		in.close();
	}
}
