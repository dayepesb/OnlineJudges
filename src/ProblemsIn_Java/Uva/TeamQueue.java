package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class TeamQueue {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
		
		int k = 1;
		while (true) {
			int t = Integer.parseInt(in.readLine());
			if (t == 0)
				break;

			HashMap<Integer, Integer> member = new HashMap<Integer, Integer>();
			for (int i = 0; i < t; ++i) {
				String[] parts = in.readLine().split("[ ]+");
				for (int j = 1; j < parts.length; ++j) {
					int m = Integer.parseInt(parts[j]);
					member.put(m, i);
				}
			}

			out.println("Scenario #" + k);

			ArrayList<Queue<Integer>> queues = new ArrayList<Queue<Integer>>();
			Queue<Integer> teams = new LinkedList<Integer>();

			for (int i = 0; i < t; ++i)
				queues.add(new LinkedList<Integer>());

			String command;
			while (!(command = in.readLine()).equals("STOP")) {
				String[] parts = command.split("[ ]+");
				if (parts[0].equals("ENQUEUE")) {
					int val = Integer.parseInt(parts[1]);
					int team = member.get(val);

					if (queues.get(team).isEmpty()) {
						teams.offer(team);
					}
					queues.get(team).offer(val);
				} else {
					if (!teams.isEmpty()) {
						int team = teams.peek();
						int val = queues.get(team).poll();
						out.println(val);

						if (queues.get(team).isEmpty())
							teams.poll();
					}
				}
			}
			out.println();
			++k;
		}

		in.close();
		out.close();
	}
}