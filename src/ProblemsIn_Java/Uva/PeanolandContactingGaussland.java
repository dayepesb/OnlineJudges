package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class PeanolandContactingGaussland {
	
	public static Complex potencias [] = new Complex[63]; 
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
		potencias();
		for (String line; (line = in.readLine()) != null;) {
			String bin = Long.toBinaryString(Long.parseLong(line.trim()));
			out.println(g(bin));
		}

		out.close();
		in.close();
	}
	public static void potencias (){
		potencias[0] = new Complex(1, 0);
		potencias[1] = new Complex(-1, 1);
		for (int i = 2; i < potencias.length; i++) {
			potencias[i] = potencias[i-1].mult(potencias[1]);
		}
	}
	public static Complex g (String bin){
		Complex res = new Complex(0, 0);
		int cont = 0;
		for (int i = bin.length()-1; i >= 0; i--,cont++) {
			if(bin.charAt(i)=='1'){
				res = res.sum(potencias[cont]);
			}
		}
		return res;
	}
	static class Complex {
		public long real, img;

		public Complex(long real, long img) {
			this.real = real;
			this.img = img;
		}

		public Complex sum(Complex c) {
			return new Complex(this.real + c.real, this.img + c.img);
		}

		public Complex mult(Complex c) {
			return new Complex((this.real * c.real) - (this.img * c.img), (this.real * c.img) + (this.img * c.real));
		}
		@Override
		public String toString() {
			return this.real+" "+this.img;
		}
	}

}
