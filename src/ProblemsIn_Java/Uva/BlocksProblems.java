package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BlocksProblems {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(lector.readLine());
		ArrayList<Integer>[] arr = agregarLista(n);
		SalirDelCiclo: while (true) {
			String movimiento = lector.readLine();
			String[] b = movimiento.split(" +");
			if (b.length == 1) {
				if (b[0].equalsIgnoreCase("quit")) {
					break SalirDelCiclo;
				}
			} else {

				String mov = b[0];
				int num1 = Integer.parseInt(b[1]);
				String mov2 = b[2];
				int num2 = Integer.parseInt(b[3]);
				if (mov.equals("move")) {
					if (mov2.equalsIgnoreCase("onto")) {
						onto(arr, num1, num2);
					} else if (mov2.equalsIgnoreCase("over")) {
						over(arr, num1, num2);
					} else {
						throw new IllegalArgumentException("Argumento no valido");
					}
				} else if (mov.equalsIgnoreCase("pile")) {
					if (mov2.equalsIgnoreCase("onto")) {
						pileOnto(arr, num1, num2);
					} else if (mov2.equalsIgnoreCase("over")) {
						pileOver(arr, num1, num2);
					} else {
						throw new IllegalArgumentException("Argumento no valido");
					}
				}
			}
		}
		estadoList(arr);
	}

	public static ArrayList<Integer>[] agregarLista(int n) {
		ArrayList<Integer>[] arr = new ArrayList[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = new ArrayList<Integer>();
			arr[i].add(i);
		}
		return arr;
	}

	public static void estadoList(ArrayList<Integer>[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(i + ":");
			for (int j = 0; j < arr[i].size(); j++) {
				System.out.print(" " + arr[i].get(j));
			}
			System.out.println();
		}
	}

	public static void onto(ArrayList<Integer>[] arr, int a, int b) {
		int posicionDea = buscar(arr, a);
		int posicionDeb = buscar(arr, b);
		if ((posicionDea != posicionDeb) && (posicionDea > -1) && (posicionDeb > -1)) {
			desapilar(arr, a, posicionDea);
			desapilar(arr, b, posicionDeb);
			int auxiliar = arr[posicionDea].size() - 1;
			arr[posicionDeb].add(a);
			arr[posicionDea].remove(auxiliar);
		}
	}

	public static void over(ArrayList<Integer>[] arr, int a, int b) {
		int posicionDea = buscar(arr, a);
		int posicionDeb = buscar(arr, b);
		if ((posicionDea != posicionDeb) && (posicionDea > -1) && (posicionDeb > -1)) {
			desapilar(arr, a, posicionDea);
			int auxiliar = arr[posicionDea].size() - 1;
			arr[posicionDeb].add(a);
			arr[posicionDea].remove(auxiliar);
		}
	}

	public static void pileOnto(ArrayList<Integer>[] arr, int a, int b) {
		int posicionDea = buscar(arr, a);
		int posicionDeb = buscar(arr, b);
		ArrayList<Integer> list = new ArrayList<Integer>();
		if ((posicionDea != posicionDeb) && (posicionDea > -1) && (posicionDeb > -1)) {
			desapilar(arr, b, posicionDeb);
			ciclo: while (true) {
				int tam = arr[posicionDea].size() - 1;
				int ultimaElem = arr[posicionDea].get(tam);
				if (ultimaElem == (a)) {
					list.add(ultimaElem);
					arr[posicionDea].remove(tam);
					break ciclo;
				} else {
					list.add(ultimaElem);
					arr[posicionDea].remove(tam);
				}
			}
			while (!(list.isEmpty())) {
				int ultimaPosicion = list.size()-1;
				int s = list.remove(ultimaPosicion);
				arr[posicionDeb].add(s);
			}
		}
	}

	public static void pileOver(ArrayList<Integer>[] arr, int a, int b) {
		int posicionDea = buscar(arr, a);
		int posicionDeb = buscar(arr, b);
		ArrayList<Integer> list = new ArrayList<Integer>();
		if ((posicionDea != posicionDeb) && (posicionDea > -1) && (posicionDeb > -1)) {
			ciclo: while (true) {
				int tam = arr[posicionDea].size() - 1;
				int ultimaElem = arr[posicionDea].get(tam);
				if (ultimaElem == (a)) {
					list.add(ultimaElem);
					arr[posicionDea].remove(tam);
					break ciclo;
				} else {
					list.add(ultimaElem);
					arr[posicionDea].remove(tam);
				}
			}
			while (!(list.isEmpty())) {
				int ultimaPosicion = list.size()-1;
				int s = list.remove(ultimaPosicion);
				arr[posicionDeb].add(s);
			}
		}
	}

	public static int buscar(ArrayList<Integer>[] arr, int a) {
		for (int i = 0; i < arr.length; i++) {
			ArrayList<Integer> List = arr[i];
			for (int j = 0; j < arr[i].size(); j++) {
				if (List.get(j) == a) {
					return i;
				}
			}
		}
		return -1;
	}

	public static void desapilar(ArrayList<Integer>[] arr, int a, int b) {
		int posicion = b;
		boolean despejado = false;
		for (int i = arr[posicion].size() - 1; i >= 0; i--) {
			if (arr[posicion].get(i) == a) {
				despejado = true;
			}
			if (despejado == false) {
				int s = arr[posicion].get(i);
				int orden = arr[posicion].remove(i);
				arr[s].add(0, orden);
			}

		}
	}
}