package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class TrainTracks {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		int casos = Integer.parseInt(in.readLine().trim());
		for (int k = 0; k < casos; k++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			if(st.countTokens()==1){
				out.println("NO LOOP");
			}else{
				int m = 0,f=0;
				while(st.hasMoreTokens()){
					String s = st.nextToken();
					if(s.equalsIgnoreCase("MM")){
						m+=2;
					}else if(s.equalsIgnoreCase("FF")){
						f+=2;
					}else if (s.equalsIgnoreCase("MF") || s.equalsIgnoreCase("FM")){
						m++;
						f++;
					}
				}				
				out.println(f==m?"LOOP":"NO LOOP");
			}
		}

		out.close();
		in.close();
	}

}
//mm-0   mf
