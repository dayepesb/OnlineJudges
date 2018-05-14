package ProblemsIn_Java.Notebook_Camus.Annexes;

public static void haversine(String args[]) { // distancia entre 2 puntos en la tierra
	final int R = 6371; // or 6378 Radious of the earth
	double lat1 = Double.parseDouble(args[0]);
	double lon1 = Double.parseDouble(args[1]);
	double lat2 = Double.parseDouble(args[2]);
	double lon2 = Double.parseDouble(args[3]);
	double latDistance = (lat2 - lat1) * Math.PI / 180;
	double lonDistance = (lon2 - lon1) * Math.PI / 180;
	double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2) + Math.cos((lat1) * Math.PI / 180)
			* Math.cos((lat2) * Math.PI / 180) * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
	double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
	double distance = R * c;
}