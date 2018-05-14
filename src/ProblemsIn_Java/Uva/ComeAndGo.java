package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class ComeAndGo {
	
	public static int aristas,nodos;
	public static int[] low;
	public static boolean[] visited;
	public static ArrayList<Integer>[] ady;
	public static List<List<Integer>> sccComp;
	public static Stack<Integer> stack;
	public static int preCount;
	
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		int nodo1,nodo2;

		while(true){
			nodos = Integer.parseInt(st.nextToken());
			aristas = Integer.parseInt(st.nextToken());
			if(nodos==aristas && aristas==0) break;
			ady = new ArrayList[nodos];
			for (int i = 0; i < ady.length; i++) ady[i]= new ArrayList<>();
			
			for (int i = 0; i < aristas; i++) {
				st = new StringTokenizer(in.readLine());
				nodo1 = Integer.parseInt(st.nextToken())-1;
				nodo2 = Integer.parseInt(st.nextToken())-1;
				ady[nodo1].add(nodo2);
				if(Integer.parseInt(st.nextToken())==2){
					ady[nodo2].add(nodo1);
				}
			}
			
			out.println(Tarjan(ady).get(0).size()==nodos?"1":"0");
			
			st = new StringTokenizer(in.readLine());
		}
		
		out.close();
		in.close();
	}
	

	public static List<List<Integer>> Tarjan(ArrayList<Integer>[] graph) {
		aristas = graph.length;
		ady = graph;
		low = new int[aristas];
		visited = new boolean[aristas];
		stack = new Stack<Integer>();
		sccComp = new ArrayList<>();

		for (int v = 0; v < aristas; v++){
			if (!visited[v]){
				dfs(v);
			}
		}
		return sccComp;
	}

	public static void dfs(int v) {
		low[v] = preCount++;
		visited[v] = true;
		stack.push(v);
		int min = low[v];
		for (int w : ady[v]) {
			if (!visited[w]){
				dfs(w);
			}
			if (low[w] < min){
				min = low[w];
			}
		}
		if (min < low[v]) {
			low[v] = min;
			return;
		}
		List<Integer> component = new ArrayList<Integer>();
		int w;
		do {
			w = stack.pop();
			component.add(w);
			low[w] = aristas;
		} while (w != v);
		sccComp.add(component);
	}
}
