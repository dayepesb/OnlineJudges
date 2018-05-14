package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.StringTokenizer;

public class Electricity {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		StringTokenizer st;
		while (true) {
			int num = Integer.parseInt(in.readLine());
			if (num==0)break;
			int n, cC = 0, lC,a,m,d,sum=0,cont=0;
			GregorianCalendar cDate,lDate;
			cDate = new GregorianCalendar(0, 0, 0);
			for (int i = 0; i < num; i++) {
				lDate = cDate;
				lC =cC;
				st = new StringTokenizer(in.readLine());
				d = Integer.parseInt(st.nextToken());
				m = Integer.parseInt(st.nextToken())-1;
				a = Integer.parseInt(st.nextToken());
				cC = Integer.parseInt(st.nextToken());
				cDate = new GregorianCalendar(a,m,d);
				lDate.add(Calendar.DATE, 1);
				if(cDate.equals(lDate)){
					sum+= cC-lC;
					cont++;
				}
			}
			out.println(cont+" "+sum);
		}

		out.close();
		in.close();
	}

}
