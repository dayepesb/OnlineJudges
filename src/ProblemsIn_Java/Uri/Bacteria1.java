package ProblemsIn_Java.Uri;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Bacteria1 {
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		for(String line;(line=in.readLine())!=null;){
			String a = line.trim(),b=in.readLine().trim();
			out.println(fuerzaBruta(a, b)?"Resistente":"Nao resistente");
		}		
		in.close();
		out.close();
	}
	static boolean fuerzaBruta(String cadena,String patron) { // �ndice donde ocurre S en W.
		int count = 0;
		for (int i = 0,j=0; i < cadena.length(); i++) {
			if(cadena.charAt(i)==patron.charAt(j)){
				j++;
				count++;
			}else{
				i = i-j;
				count=0;
				j=0;
			}
			
			if (count==patron.length()) {
				return true;
			}
		}
		return false;
	}
}
