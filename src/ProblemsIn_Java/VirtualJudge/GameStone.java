package ProblemsIn_Java.VirtualJudge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;

/**
 * @author david yepes buitrago
 * @date 01-08-2017
 * @time 0.109 ms
 */
public class GameStone {
	public static void main(String[] args) throws IOException {
		BufferedReader tec = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		for (String line; (line = tec.readLine()) != null;) {
			BigInteger b = new BigInteger(line.trim());
			if (b.mod(BigInteger.valueOf(3)).equals(BigInteger.ZERO)) {
				out.println(2);
			}
			if (b.mod(BigInteger.valueOf(3)).equals(BigInteger.ONE)) {
				out.println(1);
				out.println(1);
			}
			if (b.mod(BigInteger.valueOf(3)).equals(BigInteger.valueOf(2))) {
				out.println(1);
				out.println(2);
			}
		}
		out.close();
	}
}
