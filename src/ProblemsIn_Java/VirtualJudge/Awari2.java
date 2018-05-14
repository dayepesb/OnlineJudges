package ProblemsIn_Java.VirtualJudge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Awari2 {

	public static void main(String[] args) throws IOException {
		BufferedReader tec = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
		while (true) {
			int n = Integer.parseInt(tec.readLine().trim());
			if (n == -1)
				break;
			StringTokenizer st = new StringTokenizer(tec.readLine());
			int[] arr = new int[n];			
			for (int i = 0; i < arr.length; i++)
				arr[i] = Integer.parseInt(st.nextToken());
			boolean hecho = true;						
			while(true){
				boolean enc=false;
				int cont=0;
				for (int i = 0; i < arr.length; i++) {
					if(arr[i]==i+1){
						enc=true;						
						for (int j = 0; j < i; j++) 
							arr[j]++;						
						arr[i]=0;
						break;
					}
					if(arr[i]==0)
						cont++;
				}				
				if(!enc){
					if(cont!=arr.length){
						hecho=false;
						break;
					}else
						break;
				}
			}
			out.println(hecho ? "S" : "N");
		}
		out.close();
	}
}
