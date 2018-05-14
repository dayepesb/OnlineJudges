package ProblemsIn_Java.Uri;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class FarmRobot {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		StringTokenizer st = new StringTokenizer(in.readLine());
		int ballas = Integer.parseInt(st.nextToken());
		int mov = Integer.parseInt(st.nextToken());
		int obj = Integer.parseInt(st.nextToken());
		int[] map = new int[ballas];
		for (int i = 1; i <= ballas; map[i - 1] = i, i++);
		st = new StringTokenizer(in.readLine());
		int index = 0;
		int count = 0;
		for (int i = 0; i < mov; i++) {
			int m = Integer.parseInt(st.nextToken());
			if (map[index] == obj) {
				count+=1;
			}
			if (index + m < 0) {
				index = map.length - 1;
			} else if (index + m > map.length - 1) {
				index = 0;
			} else {
				index += m;
			}
		}
		out.println(map[index]==obj?count+1:count);
		out.close();
		in.close();
	}

}
