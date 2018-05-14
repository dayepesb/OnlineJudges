package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Subsequence{
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
		for(String line;(line=in.readLine())!=null;){
			StringTokenizer st=new StringTokenizer(line);
			int numeros=Integer.parseInt(st.nextToken());
			long s=Long.parseLong(st.nextToken());
			line=in.readLine();
			st=new StringTokenizer(line);
			long[]arr=new long[numeros];
			if(st.hasMoreTokens())arr[0]=Long.parseLong(st.nextToken());
			for (int i = 1; i < numeros; i++) 
				arr[i]=arr[i-1]+Long.parseLong(st.nextToken());
			if(arr[arr.length-1]<s)
				out.println(0);
			else{
				int cont=0;
				int a=0;
				int b=arr.length-1;	
				int pos=0;
				while(b-a>0){
					if(b-a==1)						
						break;					
					if(arr[(a+b)/2]>s)
						b=(a+b)/2;
					else
						a=(a+b)/2;					
				}
				if(arr[a]>s)
					pos=a;
				else
					pos=b;			
				cont=pos;
				for (int i = pos; i < arr.length; i++) {
					int var=i-cont;
					for (int j = var; j < i; j++) {
						if(arr[i]-arr[j]>=s){
							cont--;
						}else{
							break;
						}
					}
				}
				out.println(cont+1);
			}
		}
		out.close();
		in.close();
	}
}
//10 15
//5 1 3 5 10 7 4 9 2 8
//5 11
//1 2 3 4 5