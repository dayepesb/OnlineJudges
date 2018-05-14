package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Alarm_clock {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		String line;
		final long horas24 = 1440;
		Ciclo:
			while(true){
				line = in.readLine();
				st = new StringTokenizer(line, " ");
				long hora1 = (Integer.parseInt(st.nextToken()));
				long min1 = (Integer.parseInt(st.nextToken()));
				long hora2 = (Integer.parseInt(st.nextToken()));
				long min2 = (Integer.parseInt(st.nextToken()));
				
				if(hora1==hora2 && hora2==min1 && min1==min2 && min2==0){
					break Ciclo;
				}else{
					long minto1=(60*hora1)+min1;
					long minto2=(60*hora2)+min2;
					
					if(minto1==minto2){
						out.write("0"+"\n");
					}else if(minto1>minto2){
						out.write(horas24-(minto1-minto2)+"\n");
					}else{
						out.write(minto2-minto1+"\n");
					}
				}
				
			}
		
		in.close();
		out.close();
	}
}
