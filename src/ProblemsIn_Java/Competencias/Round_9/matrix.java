package ProblemsIn_Java.Competencias.Round_9;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class matrix {
	public static void main(String[] args) throws IOException {
		BufferedReader tec = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int casos = Integer.parseInt(tec.readLine().trim());
		for (int caso = 0; caso < casos; caso++) {
			StringTokenizer st=new StringTokenizer(tec.readLine());
			int n=Integer.parseInt(st.nextToken());
			int m=Integer.parseInt(st.nextToken());
			long[][]mat=new long[n][m];
			for (int i = 0; i < mat.length; i++) {
				st=new StringTokenizer(tec.readLine());
				for (int j = 0; j < mat[0].length; j++) 
					mat[i][j]=Long.parseLong(st.nextToken());				
			}
			for (int i = 0; i < mat.length-1; i++) {
				for (int j = 0; j < mat[0].length; j++) {
					mat[i+1][j]-=mat[i][j];
					mat[i][j]=0;
				}
			}
			for (int i = 0; i < mat[0].length-1; i++) {
				mat[mat.length-1][i+1]-=mat[mat.length-1][i];
				mat[mat.length-1][i]=0;
			}
			out.println("Case #"+(caso+1)+": "+(mat[mat.length-1][mat[0].length-1]==0?"YES":"NO"));
			out.println();
		}
		out.close();
	}
}