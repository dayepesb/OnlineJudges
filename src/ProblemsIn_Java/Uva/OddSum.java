package ProblemsIn_Java.Uva;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class OddSum {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		long casos = in.nextLong();
		for (int i = 1; i <= casos; i++) {
			long base = in.nextLong();
			long max = in.nextLong();
			long suma = 0;
			for (long j = base; j <= max; j++) {
				if(j%2!=0){
					suma+=j;
				}
			}
			out.write("Case "+i+": "+suma+"\n");
		}
		in.close();
		out.close();
	}

}
