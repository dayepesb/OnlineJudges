package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
	import java.io.InputStreamReader;
	import java.io.PrintWriter;
	import java.util.Arrays;
	import java.util.StringTokenizer;
	
	public class TheBusDriverProblem {
	
		public static void main(String[] args) throws Exception {
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			PrintWriter out = new PrintWriter(System.out);
	
			for (String line; !(line = in.readLine()).equals("0 0 0");) {
				StringTokenizer st = new StringTokenizer(line);
				int rutas = Integer.parseInt(st.nextToken());
				int horas = Integer.parseInt(st.nextToken());
				int extra = Integer.parseInt(st.nextToken());
				int array[] = new int[rutas];
				int array2[] = new int[rutas];
				int i = 0;
				st = new StringTokenizer(in.readLine());
				while (st.hasMoreTokens()) {
					array[i] = Integer.parseInt(st.nextToken());
					i++;
				}
				i = 0;
				st = new StringTokenizer(in.readLine());
				while (st.hasMoreTokens()) {
					array2[i] = Integer.parseInt(st.nextToken());
					i++;
				}
				Arrays.sort(array);
				Arrays.sort(array2);
				int sum = 0;
				i = 0;
				for (int j = array2.length - 1; i < array.length; i++, j--) {
					int r = array[i] + array2[j];
					if (r > horas) {
						sum += (r - horas) * extra;
					}
				}
				out.println(sum);
			}
	
			out.close();
			in.close();
		}
	
	}
