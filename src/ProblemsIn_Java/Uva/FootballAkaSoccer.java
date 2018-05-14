package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class FootballAkaSoccer {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		int casos = Integer.parseInt(in.readLine());
		for (int i = 1; i <= casos; i++) {

			out.write(in.readLine() + "\n");

			int numEq = Integer.parseInt(in.readLine().trim());

			Equipo array[] = new Equipo[numEq];

			for (int j = 0; j < numEq; j++) {
				array[j] = new Equipo(in.readLine().trim());
			}

			int numPar = Integer.parseInt(in.readLine().trim());

			for (int j = 0; j < numPar; j++) {
				StringTokenizer st = new StringTokenizer(in.readLine(), "[^@#]");
				String eq1 = st.nextToken();
				int gol1 = Integer.parseInt(st.nextToken());
				int gol2 = Integer.parseInt(st.nextToken());
				String eq2 = st.nextToken();

				for (int k = 0; k < array.length; k++) {
					if (array[k].getNombre().equals(eq1)) {
						array[k].golFavor += gol1;
						array[k].golContra += gol2;
						if (gol1 > gol2) { // gano
							array[k].partidosGan += 1;
						} else if (gol1 < gol2) {// perdio
							array[k].partidosPer += 1;
						} else { // empato
							array[k].partidosEmp += 1;
						}
					}
					if (array[k].getNombre().equals(eq2)) {
						array[k].golFavor += gol2;
						array[k].golContra += gol1;
						if (gol2 > gol1) { // gano
							array[k].partidosGan += 1;
						} else if (gol2 < gol1) {// perdio
							array[k].partidosPer += 1;
						} else { // empato
							array[k].partidosEmp += 1;
						}
					}
				}

			}
			Arrays.sort(array);
			for (int k = 0; k < array.length; k++) {
				out.write(String.format("%d) %s %dp, %dg (%d-%d-%d), %dgd (%d-%d)%n", k + 1, array[k].getNombre(),
						array[k].getPuntos(), array[k].getPartidos(), array[k].partidosGan, array[k].partidosEmp,
						array[k].partidosPer, array[k].getDifGol(), array[k].golFavor, array[k].golContra));
			}

			if(i<casos){
				out.write("\n");
			}
		}

		in.close();
		out.close();
	}
}

class Equipo implements Comparable<Equipo> {

	private String nombre;
	public int golFavor;
	public int golContra;
	public int partidosGan;
	public int partidosPer;
	public int partidosEmp;

	public Equipo(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public int getPuntos() {
		return (partidosGan * 3) + (partidosEmp);
	}

	public int getDifGol() {
		return golFavor - golContra;
	}

	public int getPartidos() {
		return (this.partidosEmp + this.partidosGan + this.partidosPer);
	}

	@Override
	public int compareTo(Equipo otro) {
		if (this.getPuntos() > otro.getPuntos())
			return -1;

		if (this.getPuntos() < otro.getPuntos())
			return 1;

		if (this.partidosGan > otro.partidosGan)
			return -1;

		if (this.partidosGan < otro.partidosGan)
			return 1;

		if (this.getDifGol() > otro.getDifGol())
			return -1;

		if (this.getDifGol() < otro.getDifGol())
			return 1;

		if (this.golFavor > otro.golFavor)
			return -1;

		if (this.golFavor < otro.golFavor)
			return 1;

		if (this.getPartidos() > otro.getPartidos())
			return 1;

		if (this.getPartidos() < otro.getPartidos())
			return -1;

		return this.nombre.compareToIgnoreCase(otro.nombre);
	}
}