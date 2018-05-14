package ProblemsIn_Java.Notebook_Camus.Annexes;

static TreeSet<String> t = new TreeSet<>();
private static void rec(boolean[] b, StringBuffer sb) {
	if (sb.length() == 8) {
		StringBuffer s=new StringBuffer();
		for (int i = 0; i < sb.length(); i++) 
			s.append(sb.charAt(i)+" ");			
		t.add(s.toString().trim());
		return;
	}
	for (int i = 0; i < b.length; i++)
		if (!b[i]) {
			boolean val = true;
			int filay = i;
			int coly = sb.length();
			for (int j = 0; j < sb.length(); j++) {
				int filax = Integer.parseInt("" + sb.charAt(j)) - 1;// col=j+1
				int colx = j;
				if (filax + colx == filay + coly || (filax - colx) == (filay - coly)) {
					val = false;
					break;
				}
			}
			if (val) {
				sb.append((i + 1));
				b[i] = true;
				rec(b, sb);
				b[i] = false;
				sb.deleteCharAt(sb.length() - 1);
			}
		}
}
