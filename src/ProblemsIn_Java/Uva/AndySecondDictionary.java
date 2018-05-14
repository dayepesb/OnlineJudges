package ProblemsIn_Java.Uva;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

public class AndySecondDictionary {

	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
		
//		Scanner in = new Scanner(System.in);

		ArrayList<String> dict = new ArrayList<String>();
		String tmp = "";
		while (true) {
			String line = in.readLine();
			
			if(line==null)break;
			
			int i = 0;
			while (i < line.length()) {
				String word = "";
				while (i < line.length() && !Character.isLetter(line.charAt(i)) && line.charAt(i) != '-')
					++i;
				while (i < line.length() && (Character.isLetter(line.charAt(i)) || line.charAt(i) == '-')) {
					word += line.charAt(i);
					++i;
				}
				word = tmp + word.toLowerCase();
				if (word.isEmpty())
					continue;
				if (!tmp.isEmpty())
					tmp = "";
				if (i >= line.length()) {
					if (word.charAt(word.length() - 1) == '-')
						tmp = word.substring(0, word.length() - 1);
					else {
						if (!dict.contains(word))
							dict.add(word);
					}
				} else {
					if (!dict.contains(word))
						dict.add(word);
				}
				++i;
			} 
		}
		Collections.sort(dict);
		for (String word : dict)
			out.println(word);

		out.close();
		in.close();
	}

}
