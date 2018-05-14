package ProblemsIn_Java.Competencias.CodeJam2018;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Main {
	static long[] robot;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		int tc = Integer.parseInt(in.readLine().trim());
		for (int c = 1; c <= tc; c++) {
			out.printf("Case #%d: ", c);
			int n = Integer.parseInt(in.readLine().trim());
			StringTokenizer st = new StringTokenizer(in.readLine());
			robot = new long[n];
			for (int i = 0; i < robot.length; robot[i] = Long.parseLong(st.nextToken()), i++)
				;
			boolean flag = true;
			do {
				flag = flag && sort();
			} while (flag);
			flag = true;
			int index = 0;
			for (int i = 1; i < robot.length; i++) {
				if (robot[i - 1] > robot[i]) {
					flag = false;
					index = i - 1;
					break;
				}
			}
			out.println(flag ? "OK" : index);
		}

		out.close();
		in.close();
	}

	static boolean sort() {
		boolean flag = false;
		for (int i = 0, j = i + 2; j < robot.length; i++, j++) {
			if (robot[i] > robot[j]) {
				long var = robot[i];
				robot[i] = robot[j];
				robot[j] = var;
				flag = true;
			}
		}
		return flag;
	}
}
