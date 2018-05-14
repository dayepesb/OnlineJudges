package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Vertex {
	static PrintWriter out = new PrintWriter(System.out);
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;
		boolean mAdy[][];
		while (true) {

			int nodos = Integer.parseInt(in.readLine().trim());
			if (nodos == 0)
				break;

			mAdy = new boolean[nodos][nodos];

			while (true) {
				st = new StringTokenizer(in.readLine());
				int i = Integer.parseInt(st.nextToken())-1;
				if (i == -1)
					break;
				while (true) {
					int j = Integer.parseInt(st.nextToken())-1;
					if (j == -1)
						break;
					mAdy[i][j]=true;
				}
			}

			st = new StringTokenizer(in.readLine());
			int lim = Integer.parseInt(st.nextToken());
			for (int i = 0; i < lim; i++) {
				int ini = Integer.parseInt(st.nextToken())-1;
				bfs(ini,mAdy);
			}

		}

		out.close();
		in.close();
	}
	private static void bfs(int ini, boolean[][] mAdy) {
		Queue<Integer> q = new LinkedList<Integer>();
		boolean [] visit = new boolean[mAdy.length];
		int noVisit=visit.length;

		q.add(ini);
		while(!q.isEmpty()){
			int v = q.poll();
			for (int w = 0; w < mAdy[v].length; w++) {
				if(mAdy[v][w] && !visit[w]){
					visit[w]=true;
					noVisit--;
					q.add(w);
				}
			}
		}

		String line ="";
		for (int i = 0; i < visit.length; i++) {
			if(!visit[i]){
				line+=(i+1)+" ";
			}
		}
		line = noVisit+" "+line.trim();
		out.println(line.trim());

	}
}
