package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class NumberingRoads {

	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		long caso=1;
		while(true){
			StringTokenizer st=new StringTokenizer(in.readLine());
			long a=Long.parseLong(st.nextToken());
			long b=Long.parseLong(st.nextToken());
			if(a==0&&b==0)
				break;
			long c=(long)Math.ceil((double)a/b)-1;
			String cad=(c<=26)?""+c:"impossible";
			out.println("Case "+caso+": "+cad);
			caso++;
		}
		out.close();
		in.close();
	}
}