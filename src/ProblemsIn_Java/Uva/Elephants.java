package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Elephants {

	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		ArrayList<Integer> pesos;
		int casos = Integer.parseInt(in.readLine());
		for (int i = 0; i < casos; i++) {
			pesos = new ArrayList<>();
			StringTokenizer st = new StringTokenizer(in.readLine());
			int m = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(in.readLine());
			while(st.hasMoreTokens()){
				pesos.add(Integer.parseInt(st.nextToken()));
			}
			Collections.sort(pesos);
			int aux = 0;
			for (int j = 0; j < pesos.size(); j++) {
				int wi = pesos.get(j);
				if(w-wi>0){
					w-=wi;
					aux++;
				}else{
					break;
				}
			}
			out.println(aux);
		}
		out.close();
		in.close();
	}

}
