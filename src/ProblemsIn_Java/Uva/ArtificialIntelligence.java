package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class ArtificialIntelligence {
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
		String line;
		int tests = Integer.parseInt(in.readLine());
		int pos1, pos2;
		boolean p, u, i;
		double pp, ii, uu;
		pp = uu = ii = 0;
		for (int test=1; test<=tests; test++){
			out.println("Problem #" + test);

			line = in.readLine();
			
			p = u = i = false;

			if((pos1=line.indexOf("P="))>=0){
				p = true;
				pos2 = line.indexOf('W',pos1);
				pp = getResult(pos1, pos2, line);
			}
			if((pos1=line.indexOf("U="))>=0){
				u=true;
				pos2 = line.indexOf('V',pos1);
				uu = getResult(pos1, pos2, line);
			}
			if((pos1=line.indexOf("I="))>=0){
				i=true;
				pos2 = line.indexOf('A',pos1);
				ii = getResult(pos1, pos2, line);
			}
			
			if(!p){
				pp=uu*ii;
				out.printf("P=%.2fW\n\n",pp);
			}
			else if(!i){
				ii=pp/uu;
				out.printf("I=%.2fA\n\n",ii);
			}
			else if(!u){
				uu=pp/ii;
				out.printf("U=%.2fV\n\n",uu);
			}
		}
		out.close();
		in.close();
	}
	
	public static double getResult(int pos1, int pos2, String line){
		char prefix = line.charAt(pos2-1);
		if ((prefix == 'm') || (prefix == 'k') || (prefix == 'M')){
			pos2--;
		}
		String num = line.substring(pos1+2, pos2);
		double number = Double.parseDouble(num); 
		if (prefix == 'm') number /= 1000;
		if (prefix == 'k') number *= 1000;
		if (prefix == 'M') number *= 1000000;
		return number;
	}
}