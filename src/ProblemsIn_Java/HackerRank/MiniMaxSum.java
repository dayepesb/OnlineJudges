package ProblemsIn_Java.HackerRank;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MiniMaxSum {

	public static void main(String[] args)  throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		StringTokenizer st = new StringTokenizer(in.readLine());
		long array [] = new long [5];
		for (int i = 0; i < array.length; i++) {
			array[i] = Long.parseLong(st.nextToken());
		}
		long sum = 0;
		for (int i = 0; i < array.length; i++) {
			sum+=array[i];
		}
		Arrays.sort(array);
		System.out.printf("%d %d",sum-array[4],sum-array[0]);

		out.close();
		in.close();
	}

}
