package ProblemsIn_Java.HackerRank;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class FlippingBits {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		int t = Integer.parseInt(in.readLine().trim());
		StringBuffer sb;
		for (int i = 0; i < t; i++) {
			String a = Long.toBinaryString(Long.parseLong(in.readLine().trim()));
			sb = new StringBuffer();
			int b[]= new int[32];
			int s = 32;
			for (int j = a.length()-1; j >=0; j--) {
				b[--s]=Integer.parseInt(a.charAt(j)+"");
			}
			for (int j = 0; j < b.length; j++) {
				if(b[j]==1){
					b[j]=0;
				}else{
					b[j]=1;
				}
			}
			for (int j = 0; j < b.length; j++) {
				sb.append(b[j]+"");
			}
			out.println(Long.parseLong(sb.toString(),2));
		}

		out.close();
		in.close();
	}
}
