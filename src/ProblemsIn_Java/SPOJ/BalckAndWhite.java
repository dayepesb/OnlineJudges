package ProblemsIn_Java.SPOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class BalckAndWhite{

	public static void main(String[] args) throws IOException {
		BufferedReader tec = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		while(true){
			StringTokenizer st=new StringTokenizer(tec.readLine());
			String a=st.nextToken();
			String b=st.nextToken();
			if(a.equals("*")&&b.equals("*"))
				break;
			int cont=0;
			for (int i = 0; i < a.length(); i++) {				
				if(a.charAt(i)!=b.charAt(i)){
					for (int j = i; j< a.length(); j++) {
						if(a.charAt(j)==b.charAt(j)||j==a.length()-1){
							i=j;
							cont++;
							break;
						}						
							
					}
				}
			}
			out.println(cont);
		}	
		out.close();
	}
}