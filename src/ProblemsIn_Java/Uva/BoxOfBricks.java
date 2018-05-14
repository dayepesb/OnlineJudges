package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class BoxOfBricks {

	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
		
		int cont = 1;
		
		Ciclo:
			while(true){
				int pilas = Integer.parseInt(in.readLine());
				if(pilas==0){
					break Ciclo;
				}else{
					StringTokenizer st = new StringTokenizer(in.readLine().trim()," ");
					int sum = 0;
					int array[]=new int [pilas];
					for (int i = 0; i < array.length; i++) {
						int a = Integer.parseInt(st.nextToken());
						sum+=a;
						array[i]=a;
					}
					sum/=pilas;
					int res=0;
					for (int i = 0; i < array.length; i++) {
						if((array[i]-sum)>0){
							res+=(array[i]-sum);
						}
					}
					
					out.println("Set #"+cont+"\n"+
							"The minimum number of moves is "+res+"."+"\n");
					
					cont+=1;
				}
			}
		
		out.close();
		in.close();
	}

}
