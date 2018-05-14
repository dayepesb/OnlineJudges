package ProblemsIn_Java.Uva;

import java.util.Scanner;

public class BussinesCenter {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			long boton = in.nextLong();
			long asensor = in.nextLong();
			long minimo = Long.MAX_VALUE;
			for (int i = 0; i < asensor; i++) {
				long sube = in.nextLong();
				long baja = in.nextLong();
				minimo = Math.min(formula(sube,baja,boton), minimo);
			}
			System.out.println(minimo);			
		}
		in.close();
	}
	public static long formula(long sube,long baja,long boton){
		return ((boton*baja)/(sube+baja)+1)*(sube+baja)-(boton*baja);
	}
}
