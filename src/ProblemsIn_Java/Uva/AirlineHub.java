package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Locale;
import java.util.StringTokenizer;

/**
 * @author david yepes buitrago
 * @date 23-08-2017
 * @time 0.300 ms
 */
public class AirlineHub {
	public static void main(String[] args) throws IOException {
		Locale.setDefault(new Locale("en", "US"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		StringTokenizer st;
		for (String line; (line = in.readLine()) != null;) {
			int nodes = Integer.parseInt(line.trim());
			ArrayList<point> p = new ArrayList<>();
			for (int i = 0; i < nodes; i++) {
				st = new StringTokenizer(in.readLine());
				p.add(new point(Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken())));
			}
			double mAdy[][] = new double[nodes][nodes];
			for (int i = 0; i < nodes; i++) {
				for (int j = i + 1; j < nodes; j++) {
					mAdy[i][j] = mAdy[j][i] = haversine(
							new double[] { p.get(i).lat, p.get(i).lon, p.get(j).lat, p.get(j).lon });
				}
			}

			double sum[] = new double[nodes];
			int i = 0;
			for (double ds[] : mAdy) {
				double sumM = 0.;
				for (double d : ds) {
					sumM = Math.max(d, sumM);
				}
				sum[i] = sumM;
				i++;
			}

			double min = Double.MAX_VALUE;
			int index = 0;
			for (i = 0; i < sum.length; i++) {
				if (min >= sum[i]) {
					index = i;
					min = sum[i];
				}
			}

			out.printf("%.2f %.2f%n", p.get(index).lat, p.get(index).lon);
		}

		in.close();
		out.close();
	}

	static class point {
		double lat, lon;

		public point(double lat, double lon) {
			this.lat = lat;
			this.lon = lon;
		}

		public boolean equalsP(point p) {
			if (this.lat == p.lat && this.lon == p.lon)
				return true;
			return false;
		}
	}

	static double haversine(double args[]) { // distancia entre 2 puntos en la tierra
		final double R = 6378; // or 6378 Radious of the earth
		double lat1 = (args[0]);
		double lon1 = (args[1]);
		double lat2 = (args[2]);
		double lon2 = (args[3]);
		double latDistance = (lat2 - lat1) * Math.PI / 180;
		double lonDistance = (lon2 - lon1) * Math.PI / 180;
		double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2) + Math.cos((lat1) * Math.PI / 180)
				* Math.cos((lat2) * Math.PI / 180) * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
		double distance = R * c;
		return distance;
	}
}
