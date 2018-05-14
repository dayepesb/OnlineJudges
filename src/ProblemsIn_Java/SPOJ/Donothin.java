package ProblemsIn_Java.SPOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Donothin{

	public static void main(String[] args) throws IOException {
		BufferedReader tec = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		while(true){
			StringTokenizer st=new StringTokenizer(tec.readLine());
			int n=Integer.parseInt(st.nextToken());
			BigInteger min=new BigInteger(st.nextToken());
			if(n==-1&&min.equals(BigInteger.valueOf(-1)))
				break;
			BigInteger[]arr=new BigInteger[n];
			st=new StringTokenizer(tec.readLine());			
			BigInteger[]arreglo=new BigInteger[n];
			for (int i = 0; i < arr.length; i++){ 
				arreglo[i]=arr[i]=new BigInteger(st.nextToken());
				if(i==0)
					arr[i]=arr[i].multiply(min);
				if(i>0)
					arr[i]=arr[i].multiply(min).add(arr[i-1]);
			}
			BigInteger cont=BigInteger.ZERO;
			for (int i = 0; i < arreglo.length; i++) {
				cont=cont.add(arr[i]);
			}
			out.println(cont);			
		}
		
		out.close();
	}

}