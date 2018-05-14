package ProblemsIn_Java.Uva;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class theDecoder {
	public static void main(String[] args) throws IOException {
		DataInputStream in = new DataInputStream(System.in);
		DataOutputStream output = new DataOutputStream(System.out);
		int C;
		while ((C = in.read()) != -1)
			output.write((Character.isSpace((char) C) ? C : (C - 7)));
	}
}