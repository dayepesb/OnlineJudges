package ProblemsIn_Java.Uva;

import java.util.Scanner;
import java.util.StringTokenizer;

public class AllinAll {

	public static void main(String[] args)  {
		Scanner in = new Scanner(System.in);
		Ciclo: while (true) {
			if (in.hasNextLine()) {
				String line = in.nextLine();
				StringTokenizer st = new StringTokenizer(line);
				String uno = st.nextToken();
				String dos = st.nextToken();
				char[] s = uno.toCharArray();
				char[] t = dos.toCharArray();
				boolean[] array = new boolean[s.length];
				long index = 0;
				for (long i = 0; i < s.length; i++) {
					for (long j = index; j < t.length; j++) {
						if (s[(int) i] == (t[(int) j])) {
							array[(int) i] = true;
							index = j + 1;
							j = t.length;
						}
					}
				}
				boolean esta = true;
				for (int i = 0; i < array.length; i++) {
					if (array[(int) i] == false) {
						esta = false;
						i = array.length;
					}
				}
				if (esta) {
					System.out.println("Yes");
				} else {
					System.out.println("No");
				}
			} else {
				break Ciclo;
			}
		}
		in.close();
	}

}
