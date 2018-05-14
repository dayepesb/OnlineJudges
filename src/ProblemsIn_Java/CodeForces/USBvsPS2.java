package ProblemsIn_Java.CodeForces;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class USBvsPS2 {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		StringTokenizer st = new StringTokenizer(in.readLine());
		long usb = Long.parseLong(st.nextToken());
		long ps = Long.parseLong(st.nextToken());
		long dos = Long.parseLong(st.nextToken());
		long mouses = Long.parseLong(in.readLine().trim());
		PriorityQueue<pareja> pq = new PriorityQueue<>();
		for (long i = 0; i < mouses; i++) {
			st = new StringTokenizer(in.readLine());
			pq.add(new pareja(Integer.parseInt(st.nextToken()), st.nextToken()));
		}
		long computadores = 0;
		long precio = 0;
		while (!pq.isEmpty()) {
			pareja p = pq.poll();
//			System.out.println(p.precio+"  "+p.tipo);
			if (p.tipo.equalsIgnoreCase("USB") && usb > 0) {
				usb--;
				computadores++;
				precio += p.precio;
			} else if (p.tipo.equalsIgnoreCase("PS/2") && ps > 0) {
				ps--;
				computadores++;
				precio += p.precio;
			} else if (dos > 0) {
				dos--;
				computadores++;
				precio += p.precio;
			}
//			System.out.println(computadores+" "+precio);
			if (usb == ps && ps == dos && dos == 0) {
				break;
			}
		}
		out.printf("%d %d%n",computadores,precio);

		out.close();
		in.close();
	}

	static class pareja implements Comparable<pareja> {
		String tipo;
		long precio;

		public pareja(long precio, String tipo) {
			this.tipo = tipo;
			this.precio = precio;
		}

		@Override
		public int compareTo(pareja o) {
			return Long.compare(this.precio, o.precio);
		}

	}
}
