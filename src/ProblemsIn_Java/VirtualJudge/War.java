package ProblemsIn_Java.VirtualJudge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author david yepes buitrago
 * @date 01-08-2017
 * @time 0.110 ms
 */
public class War {
	public static void main(String[] args) throws IOException {
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out=new PrintWriter(System.out);
		for(String line;(line=in.readLine())!=null;){
			int n=Integer.parseInt(line);
			int[]arr1=new int[n];
			StringTokenizer st=new StringTokenizer(in.readLine());
			for (int i = 0; i < arr1.length; i++) 
				arr1[i]=Integer.parseInt(st.nextToken());
			int[]arr2=new int[n];
			st=new StringTokenizer(in.readLine());
			for (int i = 0; i < arr2.length; i++) 
				arr2[i]=Integer.parseInt(st.nextToken());
			Arrays.sort(arr1);
			Arrays.sort(arr2);
			int i=arr1.length-1,j=arr1.length-1;
			int cont=0;
			while(i>=0&&j>=0){
				if(arr1[i]<arr2[j]){
					i--;
					j--;
					cont++;
				}else{
					i--;
				}
			}
			out.println(cont);
		}
		out.close();
	}
}
