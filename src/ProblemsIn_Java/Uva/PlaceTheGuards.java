package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class PlaceTheGuards {

	static boolean[][] mAdy;
	static int visit[];

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		int casos = Integer.parseInt(in.readLine().trim()), nodos, aristas;
		StringTokenizer st;
		for (int i = 0; i < casos; i++) {
			st = new StringTokenizer(in.readLine());
			nodos = Integer.parseInt(st.nextToken());
			aristas = Integer.parseInt(st.nextToken());
			mAdy = new boolean[nodos][nodos];
			visit = new int[mAdy.length];
			for (int j = 0; j < aristas; j++) {
				st = new StringTokenizer(in.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				mAdy[x][y] = mAdy[y][x] = true;
			}

			int guardias = 0,res=0;
			for (int j = 0; j < visit.length; j++) {
				if (visit[j] == 0) {
					res = bfs(j);
					if (res == -1) {
						break;
					}
					guardias+=res;
				}
			}
			out.println(res==-1?"-1":guardias);
		}

		out.close();
		in.close();
	}

	private static int bfs(int nodo) {
		int guardias1 = 0;
		int guardias2 = 0;
		
		Queue<Integer> q = new LinkedList<>();
		int color = 1;
		visit[nodo]=color;
		guardias1++;
		q.add(nodo);
		
		while(!q.isEmpty()){
			int v = q.poll();
			color = visit[v]==1?2:1;
			for (int w = 0; w < mAdy[v].length; w++) {
				if(mAdy[v][w]){
					if(visit[w]==0){
						visit[w]=color;
						if(color==1){
							guardias1++;
						}else if(color==2){
							guardias2++;
						}
						q.add(w);
					}else{
						if(visit[v]==visit[w]){
							return -1;
						}
					}
				}
			}
		}
		if(guardias2==0)return guardias1;
		return Math.min(guardias1, guardias2);
	}

}
