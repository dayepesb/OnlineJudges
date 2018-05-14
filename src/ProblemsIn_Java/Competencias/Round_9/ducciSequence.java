package ProblemsIn_Java.Competencias.Round_9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ducciSequence {

	public static void main(String[] args) throws IOException {
		BufferedReader tec = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int casos = Integer.parseInt(tec.readLine().trim());
		for (int caso = 0; caso < casos; caso++) {
			int n = Integer.parseInt(tec.readLine().trim());
			StringTokenizer st = new StringTokenizer(tec.readLine());
			int[] arr = new int[n];
			for (int i = 0; i < arr.length; i++)
				arr[i] = Integer.parseInt(st.nextToken());
			for (int z = 0; z < 1000; z++) {		
				int[] nuevo = arr.clone();			
				for (int i = 0; i < nuevo.length-1; i++) 
					nuevo[i]=Math.abs(nuevo[i]-nuevo[i+1]);
				nuevo[nuevo.length-1]=Math.abs(arr[0]-arr[nuevo.length-1]);
				arr=nuevo.clone();
			}
			Arrays.sort(arr);			
			out.println(arr[0]==arr[arr.length-1]&&arr[0]==0?"ZERO":"LOOP");
		}
		out.close();
	}
}