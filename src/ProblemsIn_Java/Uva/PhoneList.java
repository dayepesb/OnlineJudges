package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

/**
 * @author david yepes buitrago
 *
 */
public class PhoneList {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		int casos = Integer.parseInt(in.readLine().trim());
		for (int i = 0; i < casos; i++) {
			int n = Integer.parseInt(in.readLine().trim());
			String nums[] = new String[n];
			for (int j = 0; j < nums.length; j++) {
				nums[j] = in.readLine().trim();
			}
			Arrays.sort(nums);
			boolean flag = true;
			for (int j = 0; j < n - 1; j++) {
				if (prefix_check(nums[j], nums[j + 1])) {
					flag = false;
					break;
				}
			}

			if (flag)
				out.printf("YES\n");
			else
				out.printf("NO\n");
		}

		in.close();
		out.close();
	}

	static boolean prefix_check(String a, String b) {

		if (b.length() < a.length())
			return false;

		for (int i = 0; i < a.length(); i++) {
			if (a.charAt(i) != b.charAt(i))
				return false;
		}

		return true;
	}
}
