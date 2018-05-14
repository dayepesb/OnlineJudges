package ProblemsIn_Java.Uva;

import java.util.Scanner;

public class PackingForHoliday {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int caso = in.nextInt();
		for (int i = 1; i <= caso; i++) {
			if(in.nextInt()>20||in.nextInt()>20||in.nextInt()>20){
				System.out.println("Case "+i+": bad");
			}else{
				System.out.println("Case "+i+": good");
			}
		}

		in.close();
	}
}
