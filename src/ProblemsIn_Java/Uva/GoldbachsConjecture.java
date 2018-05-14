package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

public class GoldbachsConjecture {

	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

		String line;
		int n;
		ArrayList<Integer> primos = new ArrayList<>();
		boolean criba [] = new boolean [1000000];

		criba[2]=true;
		for (int i = 3; i < 1000000; i+=2) {
			criba[i]=true;
		}
		int I = 1001;
		for (int i = 3; i <= I; i+=2) {
			if(criba[i]==true){
				for (int j = i*i,bi=2*i; j < 1000000; j+=bi) {
					criba[j]=false;
				}
			}
		}
		for (int i = 3; i < criba.length; i++) {
			if(criba[i]){
				primos.add(i);
			}
		}
		
		for (;!((line = in.readLine().trim()).equals("0"));) {
			n = Integer.parseInt(line);
			for (int a = 0; a < n; a++) {
				if(criba[a]){
					if(criba[n-a]){
						out.printf("%d = %d + %d%n", n ,a , n-a);
						break;
					}
				}
			}
		}
		
		out.close();
		in.close();
	}

}
