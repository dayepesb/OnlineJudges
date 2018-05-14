package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Audiophobia {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer st;
		int[][] mAdy;
		int casos = 0;
		for (String line; !(line = in.readLine().trim()).equals("0 0 0");) {
			casos++;
			st = new StringTokenizer(line);
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			mAdy = new int[c][c];
			for (int[] is : mAdy) {
				Arrays.fill(is, Integer.MAX_VALUE);
			}
			for (int i = 0; i < mAdy.length; mAdy[i][i] = 0, i++)
				;
			for (int i = 0; i < s; i++) {
				st = new StringTokenizer(in.readLine());
				int x = Integer.parseInt(st.nextToken())-1;
				int y = Integer.parseInt(st.nextToken())-1;
				int weith = Integer.parseInt(st.nextToken());
				mAdy[y][x]=mAdy[x][y]=weith;
			}
			
			for (int k = 0; k < mAdy.length; k++) {
				for (int i = 0; i < mAdy.length; i++) {
					for (int j = 0; j < mAdy.length; j++) {
						mAdy[i][j]=mAdy[j][i]=Math.min(mAdy[i][j], Math.max(mAdy[i][k], mAdy[k][j]));
					}
				}
			}


			if(casos>1)out.println();
			out.printf("Case #%d%n", casos);

			for (int i = 0; i < q; i++) {
				st = new StringTokenizer(in.readLine());
				int x = Integer.parseInt(st.nextToken())-1;
				int y = Integer.parseInt(st.nextToken())-1;
				if(mAdy[x][y]==Integer.MAX_VALUE){
					out.println("no path");
				}else{
					out.println(mAdy[x][y]);
				}
			}

		}

		out.close();
		in.close();
	}

}
