package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.TreeSet;

/**
 * @author david yepes buitrago
 * @date 23-08-2017
 * @time 0.050 ms
 */
public class MutantFlatworldExplorers {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		StringTokenizer st = new StringTokenizer(in.readLine());
		int maxX = Integer.parseInt(st.nextToken());
		int maxY = Integer.parseInt(st.nextToken());
		TreeSet<String> ts = new TreeSet<>();
		for (String line; (line = in.readLine()) != null;) {
			st = new StringTokenizer(line);
			int posX = Integer.parseInt(st.nextToken());
			int posY = Integer.parseInt(st.nextToken());
			int dir = Integer
					.parseInt(st.nextToken().replace('N', '0').replace('E', '1').replace('S', '2').replace('W', '3'));
//			System.out.println(posX + "----" + posY + "----" + dir);
			String instructions = in.readLine().trim();
			boolean salio = false;
//			System.out.println(ts);
			Loop: for (int i = 0; i < instructions.length(); i++) {
				char a = instructions.charAt(i);
				switch (a) {
				case 'R':
					dir = Math.abs(dir + 1) % 4;
					break;
				case 'L':
					dir = Math.abs(dir == 0 ? 3 : dir - 1) % 4;
					break;
				case 'F':
					switch (dir) {
					case 0:
						if ((posY + 1) > maxY) {
							if (!ts.contains(posX + "," + posY))
								posY++;
						} else
							posY++;
						if (posY > maxY) {
							posY--;
							ts.add(posX + "," + posY);
							salio = true;
							break Loop;
						}
						break;
					case 1:
						if ((posX + 1) > maxX) {
							if (!ts.contains(posX + "," + posY))
								posX++;
						} else
							posX++;

						if (posX > maxX) {
							posX--;
							ts.add(posX + "," + posY);
							salio = true;
							break Loop;
						}
						break;
					case 2:
						if ((posY - 1) < 0) {
							if (!ts.contains(posX + "," + posY))
								posY--;}else posY--;
						if (posY < 0) {
							posY++;
							ts.add(posX + "," + posY);
							salio = true;
							break Loop;
						}
						break;
					case 3:
						if ((posX - 1) < 0) {
							if (!ts.contains(posX + "," + posY)) {
								posX--;
							}
						}else
							posX--;
						if (posX < 0) {
							posX++;
							ts.add(posX + "," + posY);
							salio = true;
							break Loop;
						}
						break;
					}
				}
//				System.out.println(posX + "***" + posY + "***" + dir);
			}
			out.printf("%d %d %s%s%n", posX, posY,
					(dir + "").replace('0', 'N').replace('1', 'E').replace('2', 'S').replace('3', 'W'),
					(salio ? " LOST" : ""));
		}

		in.close();
		out.close();
	}
}
