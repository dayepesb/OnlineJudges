package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class SplittingNumbers{
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
		for(String line;!(line=in.readLine().trim()).equals("0");){
			long num=Long.parseLong(line);
			long a=0;
			long b=0;
			String bin=Long.toBinaryString(num);
			boolean esA=true;
			for (int i = 0; i < bin.length(); i++) {
				boolean cambio=false;
				if(esA){
					if(((num>>i)&1)==1){
						esA=false;
						a+=1<<(i);
						cambio=true;
					}
				}else{
					if(((num>>i)&1)==1){
						esA=true;
						b+=1<<(i);
						cambio=true;
					}
				}
			}
			out.println(a+" "+b);
		}
		out.close();
		in.close();
	}
}
