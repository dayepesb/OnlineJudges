package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ClawDecomposition {

	static int visit[];
	static boolean[][] mAdy;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

		int nodos, nodo1, nodo2;
		StringTokenizer st;

		nodos = Integer.parseInt(in.readLine().trim());
		for (; nodos != 0;) {
			mAdy = new boolean[nodos][nodos];
			visit = new int[nodos];
			while(true){
				st = new StringTokenizer(in.readLine());
				nodo1 = Integer.parseInt(st.nextToken())-1;
				nodo2 = Integer.parseInt(st.nextToken())-1;
				if(nodo1==-1)break;
				mAdy[nodo1][nodo2]=mAdy[nodo2][nodo1]=true;
			}
			
			boolean res = true;
			for (int i = 0; i < visit.length; i++) {
				if(visit[i]==0){
					res &= dfs(i,-1);
				}
			}
			out.println(res?"YES":"NO");
			nodos = Integer.parseInt(in.readLine().trim());
		}
		out.close();
		in.close();
	}

	private static boolean dfs(int nodo, int color) {
		visit[nodo]=color;
		boolean o = true;
		for (int i = 0; i < mAdy[nodo].length; i++) {
			if(mAdy[nodo][i]){
				if(visit[i]==0){
					o &= dfs(i, 1-color);
				}else if(visit[i]==visit[nodo]){
					return false;
				}
			}
		}
		return o;
	}

}
