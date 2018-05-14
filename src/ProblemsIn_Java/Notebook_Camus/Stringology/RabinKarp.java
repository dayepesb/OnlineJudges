package ProblemsIn_Java.Notebook_Camus.Stringology;// patron que se va a buscar
private String pat;
// hash del patron
private long patHash;
// tama�o del patron
private int M;
// primo muy grande
private final long PRIME = 1000000007;
// el tama�o del lenguaje sobre el que se trabaja en este caso ascii extendido
private int R = 256;
private long RM;
public RabinKarpModular(String pat) {
	this.pat = pat;
	// tama�o del patron
	M = pat.length(); RM = 1;
	for (int i = 1; i <= M - 1; i++) // calcula R^(M-1)%Q
		RM = (R * RM) % PRIME;
	patHash = hash(pat, M);
}
// saca el hash del patron que se le pasa
private long hash(String key, int M) {
	long h = 0;
	for (int j = 0; j < M; j++)
		h = (R * h + key.charAt(j)) % PRIME;
	return h;
}
// busca el patron en el txt
private int search(String txt) {
	int N = txt.length();
	long txtHash = hash(txt, M);
	if (patHash == txtHash && check(txt, 0)) // casamento
		return 0;
	for (int i = 1; i <= N - M; i++) {
		txtHash = (txtHash + PRIME - RM * txt.charAt(i - 1) % PRIME) % PRIME;
		txtHash = (txtHash * R + txt.charAt(i + M - 1)) % PRIME;
		if (patHash == txtHash)
			if (check(txt, i))
				return i;
	}
	return N;
}
public boolean check(String txt, int i) {
	return true; // Monte Carlo
}
