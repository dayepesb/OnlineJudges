package ProblemsIn_Java.Competencias.GoogleGames2017;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

/**
 * @author david yepes buitrago
 * @date 00-00-0000
 * @time 0.000 ms
 */
public class RobotOperatives {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		// 1 hora contruyo un cc
		int[][] robots = new int[3][10];
		robots[0][0] = 1;
		int f = 9;
		for (int i = 1; i < f; i++) {
			robots[0][i] = robots[0][i - 1]+1;
			robots[1][i] = robots[0][i - 1] + robots[1][i - 1];
			robots[2][i] = robots[1][i - 1] + robots[2][i - 1];
		}
		for (int i = f; i < 9; i++) {
			robots[0][i] = robots[0][i - 1];
			robots[1][i] = robots[0][i - 1] + robots[1][i - 1] + 1;
			robots[2][i] = robots[1][i - 1] + robots[2][i - 1];
		}

//		robots[0][8] = robots[0][7];
//		robots[1][8] = robots[0][7]+robots[1][7]+1;
//		robots[2][8] = robots[2][7]+robots[1][7];
		
		robots[0][9] = robots[0][8];
		robots[1][9] = robots[1][8];
		robots[2][9] = robots[1][8]+robots[2][8] + 1;

		for (int[] is : robots) {
			System.out.println(Arrays.toString(is));
		}

		in.close();
		out.close();
	}
}