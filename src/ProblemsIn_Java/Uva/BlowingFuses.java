package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class BlowingFuses {

	public static void main(String[] args) throws IOException {
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out=new PrintWriter(new OutputStreamWriter(System.out));
		long caso=1;
		while(true){
			StringTokenizer st=new StringTokenizer(in.readLine());
			int n=Integer.parseInt(st.nextToken());
			long m=Long.parseLong(st.nextToken());
			long c=Long.parseLong(st.nextToken());
			if(n==0&&m==0&&c==0)
				break;
			long act=0,max=0;
			boolean[]vis=new boolean[n];
			long[]arr=new long[n];
			for (int i = 0; i < arr.length; i++) 
				arr[i]=Long.parseLong(in.readLine().trim());
			boolean estallado=false;
			for (long i = 0; i < m; i++) {
				int a=Integer.parseInt(in.readLine().trim())-1;				
				if(vis[a]){
					vis[a]=false;
					act-=arr[a];
				}else{
					vis[a]=true;
					act+=arr[a];
					max=Math.max(max, act);
					if(max>c){
						estallado=true;
					}
				}
			}
			out.println("Sequence "+caso);
			if(estallado){
				out.println("Fuse was blown.");
			}else{
				out.println("Fuse was not blown.");
				out.println("Maximal power consumption was "+max+" amperes.");
			}		
			out.println();
			caso++;
		}
		out.close();
	}
}