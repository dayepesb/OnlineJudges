package ProblemsIn_Java.NoteBook;

import java.util.ArrayList;
import java.util.Arrays;

public class Ordenamiento {

	public static int[] SelectionSort(int array[]) {
		// indice posicion para interccambiar
		int index = 0;
		for (int i = 0; i < array.length; i++) {
			System.out.println(Arrays.toString(array));
			// escojer la primera posicion para comparar
			int numeroMenor = array[i];
			boolean encontroNumMenor = false;
			int index2 = 0;
			for (int j = index; j < array.length; j++) {
				// si se encuentra un numero menor en el arregloal guardado se
				// remplaza
				if (array[j] < numeroMenor) {
					numeroMenor = array[j];
					index2 = j;
					encontroNumMenor = true;
				}
			}
			// si se encontro numero menor se remplaza
			if (encontroNumMenor) {
				int aux = array[i];
				array[i] = array[index2];
				array[index2] = aux;
			}
			index++;
		}
		return array;
	}

	public static int[] QuickSort(int array[], int indexIn, int indexFin) {
		// inicio es 0 fin es el tama�o del arreglo menos 1 y el pivote es la
		// priemra posicion
		int indexPiv = array[indexIn];
		int i = 0, j = array.length - 1;
		while (i < j) {
			while (array[i] <= indexPiv && i < j) {
				i++;
			}
			while (array[j] > indexPiv) {
				j--;
			}
			if (i < j) {
				int aux = array[i];
				array[i] = array[j];
				array[j] = aux;
			}
		}
		array[indexIn] = array[j];
		array[j] = indexPiv;
		if (indexIn < j - 1) {
			QuickSort(array, indexIn, j - 1);
		}
		if (indexFin > j + 1) {
			QuickSort(array, j + 1, indexFin);
		}
		return array;
	}

	public static int[] radixSort(int[] array) {
		ArrayList<Integer> sort[] = new ArrayList[10];
		for (int i = 1; true; i++) {
			System.out.println(Arrays.toString(array));
			int dijistZero = 0;
			for (int j = 0; j < 10; j++)
				sort[j] = new ArrayList<>();
			for (int number : array) {
				int dijit = (int) (number % (Math.pow(10, i)) / Math.pow(10, i - 1));
				if (dijit == 0)
					dijistZero++;
				sort[dijit].add(number);
			}
			if (dijistZero == array.length)
				break;
			int index = 0;
			for (ArrayList<Integer> list : sort) {
				for (Integer number : list) {
					array[index] = number;
					index++;
				}
			}
		}
		return array;
	}

}
