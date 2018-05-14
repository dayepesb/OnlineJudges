package ProblemsIn_Java.VirtualJudge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * @author david yepes buitrago
 * @date 1-08-2017
 * @time 0.250 ms
 */
public class LeonardoDePisa {
	public static void main(String[] args) throws IOException {
		BufferedReader tec=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out=new PrintWriter(System.out);
		for(String line;(line=tec.readLine())!=null;){
			StringTokenizer st=new StringTokenizer(line);
			int n=Integer.parseInt(st.nextToken());
			int k=Integer.parseInt(st.nextToken());
			st=new StringTokenizer(tec.readLine());
			int[]arr=new int[k];
			for (int i = 0; i < arr.length; i++) {
				arr[i]=Integer.parseInt(st.nextToken());
			}
			if(k==2&&arr[0]+arr[1]==3){
				out.println("N");
				continue;
			}
			boolean hecho=true;
			boolean incrementando=true;
			if(arr[0]+arr[1]==3||arr[arr.length-1]+arr[arr.length-2]==3)
				hecho=false;
			for (int i = 1; i < arr.length; i++) {
				if(incrementando){
					if(arr[i]-arr[i-1]<0){
						if(arr[i]-arr[i-1]>=-2){
							incrementando=false;
							if(i>1){
								if(arr[i]==arr[i-2])
									hecho=false;
							}
						}else{
							hecho=false;
							break;
						}
					}else{
						if(arr[i]-arr[i-1]>0){
							if(arr[i]-arr[i-1]>2){
								hecho=false;
								break;
							}
						}else{
							hecho=false;
							break;
						}
					}					
				}else{
					if(arr[i]-arr[i-1]>0){
						hecho=false;
						break;
					}else{
						if(arr[i]-arr[i-1]<-2||arr[i]-arr[i-1]==0){
							hecho=false;
							break;
						}
					}					
				}
			}
						
			out.println(hecho?"S":"N");
		}
		out.close();
	}
}
