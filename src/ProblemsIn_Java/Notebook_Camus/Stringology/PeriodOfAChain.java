package ProblemsIn_Java.Notebook_Camus.Stringology;int periodo(char[] W) {
	int t=W.length,k=t-getBorderArray(W)[t];
	return t%k==0?t/k:1;}