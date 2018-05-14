package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class FriezePatterns {

	public static void main(String[] args) throws Exception{

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st;
		long mat[][];
		int N = Integer.parseInt(in.readLine().trim()),r1,r2;
		while(N!=0){
			
			mat = new long[N][N+1];
			Arrays.fill(mat[0], 1);
			Arrays.fill(mat[N-1], 1);
			
			st = new StringTokenizer(in.readLine());
			r1 = Integer.parseInt(st.nextToken());
			r2 = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(in.readLine());
			for (int i = 0; i < N; i++) {
				mat[i][0]=Integer.parseInt(st.nextToken());
			}
			
			for (int j = 1; j <= N; j++) {
				for (int i = 1; i < N-1; i++) {
					mat[i][j]=((mat[i-1][j]*mat[i+1][j-1])+1)/mat[i][j-1];
				}
			}

			r2 = r2%(N+1)==0?N+1:(r2%(N+1));
			out.println(mat[r1-1][r2-1]);
			
			N = Integer.parseInt(in.readLine().trim());
		}


		out.close();
		in.close();
	}

}
