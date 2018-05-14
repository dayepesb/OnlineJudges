package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.Vector;

public class Arbitrage{
	public static void main(String args[])throws Exception{
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st;
		double d[][][];
		int p[][][];
		boolean flag;
		int n;
		
		for (String line; (line = in.readLine())!= null; ) {
			n = Integer.parseInt(line.trim());
			d = new double[n][n][n];
			for(int i = 0; i < n; i ++){
				st = new StringTokenizer(in.readLine());
				for(int j = 0; j < n; j ++){
					if(i == j){
						d[i][j][0] = 1;
					}else{
						d[i][j][0] = Double.parseDouble(st.nextToken());
					}
				}
			}
			p = new int[n][n][n];
			for(int i = 0; i < n; i ++){
				for(int j = 0; j < n; j ++){
					p[i][j][0] = i;
				}
			}
			flag = false;
			int i = 0;
			int l = 0;
			int j = 0;
			for(l = 1; l < n; l ++){
				for(int k = 0; k < n; k ++){
					for(i = 0; i < n; i ++){
						for(j = 0; j < n; j ++){
							double temp = d[i][k][l - 1] * d[k][j][0];
							if(temp > d[i][j][l]){
								d[i][j][l] = temp;
								p[i][j][l] = p[k][j][0];
							}
							if (i == j && d[i][i][l] > 1.01){
								flag = true;
								break;
							}
						}
						if(flag == true){
							break;
						}
					}
					if(flag == true){
						break;
					}
				}
				if(flag == true){
					break;
				}
			}
			if(flag == false){
				out.println("no arbitrage sequence exists");
			}
			else{
				int f = l;
				Vector<Integer> v = new Vector<Integer>();
				out.print((i + 1) + " ");
				for(int x = 1; x <= f; x ++){
					v.add(p[i][j][l]);
					j = p[i][j][l];
					l = l - 1;
				}
				for(int g = (v.size() - 1); g >= 0; g --){
					out.print((v.elementAt(g) + 1) + " ");
				}
				out.println((i + 1));
			}
		}
		out.close();
		in.close();
	}
}	