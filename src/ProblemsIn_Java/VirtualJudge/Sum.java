package ProblemsIn_Java.VirtualJudge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * @author david yepes buitrago
 * @date 02-08-2017
 * @time 0.109 ms
 */
public class Sum {
	public static void main (String[] args) throws IOException {
		BufferedReader tec=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out=new PrintWriter(System.out);
		for(String line;(line=tec.readLine())!=null;){
			int n=Integer.parseInt(line.trim());
			boolean neg=n<0;
			n=Math.abs(n);
			n=(n*(n+1))/2;
			if(n==0){
				out.println(1);
				continue;
			}
			out.println(neg?-n+1:n);	
		}
		out.close();
	}
}
