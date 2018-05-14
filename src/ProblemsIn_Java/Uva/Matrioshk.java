package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Matrioshk {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		Stack<Long> pila = new Stack<Long>();
		String ma = in.readLine();
		StringTokenizer st = new StringTokenizer(ma);
		long a;
		boolean fallo = false;

		while (ma != null) {
			String val = ma;
			fallo = false;
			st = new StringTokenizer(ma);
			pila.clear();
			while (st.hasMoreTokens()) {
				a = Long.parseLong(st.nextToken());
				if (a < 0) {
					if (!pila.isEmpty() && pila.peek() > a) {
						fallo = true;
						break;
					}
					pila.push(a);
				} else {
					if (!pila.isEmpty() && pila.peek() == a * -1) {
						pila.pop();
					} else {
						fallo = true;
						break;
					}
				}

			}
			if (!fallo && pila.isEmpty()) {
				fallo = !valido(val);
			}
			if (fallo || !pila.isEmpty()) {
				System.out.println(":-( Try again.");
			} else {
				System.out.println(":-) Matrioshka!");
			}
			ma = in.readLine();
		}
	}

	static boolean valido(String val) {
		Stack<Long> pila = new Stack<Long>();
		Stack<Long> pila2 = new Stack<Long>();
		StringTokenizer st = new StringTokenizer(val);
		long tok = Long.parseLong(st.nextToken());
		if (st.hasMoreTokens()) {
			pila.push(-tok);
			pila2.push((long) 0);
		} else {
			return true;
		}
		while (st.hasMoreTokens()) {
			tok = Long.parseLong(st.nextToken());
			if (tok < 0) {
				pila.push(tok * -1);
				pila2.push(pila2.pop() + tok * -1);
				pila2.push((long) 0);
			} else {
				if (pila2.peek() >= pila.peek()) {
					return false;
				} else {
					pila.pop();
					pila2.pop();
				}
			}
		}
		return true;
	}
}
