package ProblemsIn_Java.Uva;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Huffman {

    public static void main(String[] args) throws Exception {
        Scanner sn = new Scanner(System.in);
		/*
				Datos[A,   B,   C,   D,     E]
		frecuencias [1/2, 1/4, 1/8, 1/16, 1/16]

		*/

        // son las frecuencias de las letras en decimales
        double [] Arrayfrequencies = {0.5,0.25,0.125,0.0625,0.0625};

        System.out.println("Frecuencias");
        print(Arrayfrequencies);
        System.out.println("TreeMap");
        // imprimo valores del TreeMap
        huffman(Arrayfrequencies);


    }

    static Node raiz = new Node();

    static Node huffman(double []  Arrayfrequencies) {

        if(Arrayfrequencies.length==1)  {
            raiz.val = Arrayfrequencies[0];
            return raiz;
        }

        //ordeno las frecuencias
        Arrays.sort(Arrayfrequencies);

        //Sumo los dos primeros valores
        double sum = Arrayfrequencies[0] + Arrayfrequencies[1];

        //creo el nuevo arreglo de frecuencias
        double [] parents = new double[Arrayfrequencies.length-1];
        for (int i  = 0 , j = 2 ; i < parents.length-1 ; i++, j++){
            parents[i] = Arrayfrequencies[j];
        }

        //Meto la suma
        parents[parents.length-1] = sum;

        //huffman
        Node result = huffman(parents);

        //Añadir arbol

        Node left = new Node(), rigth = new Node();



        result.left = left;
        result.rigth = rigth;

        return rigth;
    }

    static void print(double [] array) {
        for (Double frequencie : array) {
            System.out.print(frequencie + " ");
        }
        System.out.println();
    }


    static class Node {
        double val;
        Node left;
        Node rigth;
    }
}
