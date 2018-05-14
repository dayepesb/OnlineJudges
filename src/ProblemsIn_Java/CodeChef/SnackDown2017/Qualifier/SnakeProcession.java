package ProblemsIn_Java.CodeChef.SnackDown2017.Qualifier;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class SnakeProcession {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner in = new Scanner(br);
		PrintWriter out = new PrintWriter(System.out);

		int casos = in.nextInt();
		for (int i = 0; i < casos; i++) {
			int tam = in.nextInt();
			char s[] = in.next().toUpperCase().toCharArray();
			boolean cabeza = true, valido = true;
			Ciclo: for (int j = 0; j < s.length; j++) {
				if (s[j] == 'H') {
					if (cabeza) {
						valido = false;
						cabeza = false;
					} else {
						valido = false;
						break Ciclo;
					}
				}else if(s[j]=='T'){
					if(!cabeza){
						cabeza = true;
						valido = true;
					}else{
						valido = false;
						break Ciclo;
					}
				}
			}
			out.println(valido?"Valid":"Invalid");
		}

		out.close();
		in.close();
	}
}