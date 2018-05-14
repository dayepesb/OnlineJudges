package ProblemsIn_Java.LiveArchive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * @author David Yepes Buitrago
 * que maricada
 * @Date 29-07-2017
 */
public class HoursAndMinutes {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		for (String line; (line = in.readLine()) != null;) {
			if (Integer.parseInt(line.trim()) % 6 == 0)
				out.println("Y");
			else
				out.println("N");
		}

		in.close();
		out.close();
	}
}
