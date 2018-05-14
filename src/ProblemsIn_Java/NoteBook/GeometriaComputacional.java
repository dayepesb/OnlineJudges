package ProblemsIn_Java.NoteBook;

import java.util.Arrays;

public class GeometriaComputacional {

	class SumasDeMinkosky {
		// n*2
		double[][] fuerzaBruta(double pt1[][], double pt2[][]) {
			double pt[][] = new double[pt1.length + pt2.length][2];
			int index = 0;
			for (int i = 0; i < pt1.length; i++) {
				for (int j = 0; j < pt2.length; j++) {
					pt[index][0] = pt1[i][0] + pt2[j][0];
					pt[index][1] = pt1[i][1] + pt2[j][1];
					index++;
				}
			}
			return pt;
		}

		//no se ha probado
		double[][] SumasDeMunkoskyMejorado(double pt1[][], double pt2[][]) {
			int n = pt1.length, m = pt2.length;
			double pt[][] = new double[n + m][2];
			int index = 0, i = 0, j = 0;
			do {
				pt[index][0] = pt1[i][0] + pt2[j][0];
				pt[index][1] = pt1[i][1] + pt2[j][1];
				System.out.println(Arrays.toString(pt[index]));
				index++;
				double anguloV = angule(pt1[i], pt1[(i + 1) >= n ? 0 : i + 1]);
				double anguloW = angule(pt2[j], pt2[(j + 1) >= m ? 0 : j + 1]);
				if (anguloV < anguloW)
					i++;
				else if (anguloV > anguloW)
					j++;
				else {
					i++;
					j++;
				}
				if (i > n)
					i = n;
				if (j > n)
					j = m;
			} while (i < n && j < m);
			return Arrays.copyOfRange(pt, 0, index);
		}

		double angule(double pt1[], double pt2[]) {
			double y = ((pt1[1] - pt2[1]));
			double x = ((pt1[0] - pt2[0]));
			return Math.atan2(y, x);
		}
	}

	class AreaPoligono {

		double area(double[][] pt) {
			double r = 0d;
			int t = pt.length;
			for (int i = 0, j = 1; i < t; i++, j = j + 1 == t ? 0 : j + 1)
				r += pt[i][0] * pt[j][1] - pt[i][1] * pt[j][0];
			return Math.abs(r) / 2;
		}
	}

	double distPuntoSegmento(double[] p1, double[] p2, double[] p) {
		double dP = distanciaAlCuadrado(p1, p2), d1 = distanciaAlCuadrado(p1, p), d2 = distanciaAlCuadrado(p2, p);
		return (d2 + dP < d1 || d1 + dP < d2) ? Math.sqrt(Math.min(d1, d2)) : distPuntoLinea(p1, p2, p);
	}

	double distanciaAlCuadrado(double[] a, double[] b) {
		return (b[0] - a[0]) * (b[0] - a[0]) + (b[1] - a[1]) * (b[1] - a[1]);
	}

	double distPuntoLinea(double[] p1, double[] p2, double[] p) {
		return Math.abs((p2[0] - p1[0]) * (p1[1] - p[1]) - (p2[1] - p1[1]) * (p1[0] - p[0]))
				/ Math.sqrt(distanciaAlCuadrado(p1, p2));
	}

	boolean puntoDentroDeUnPoligono(double[][] pt, double[] p, boolean borde) {
		boolean b = false;
		for (int i = 0, j = 1, t = pt.length; i < t; i++, j = j + 1 == t ? 0 : j + 1) {
			if (distPuntoSegmento(pt[i], pt[j], p) < 1e-11)
				return borde;
			if (((pt[j][1] <= p[1] && p[1] < pt[i][1]) || (pt[i][1] <= p[1] && p[1] < pt[j][1]))
					&& (p[0] - pt[j][0] < (p[1] - pt[j][1]) * (pt[i][0] - pt[j][0]) / (pt[i][1] - pt[j][1])))
				b = !b;
		}
		return b;
	}

}
