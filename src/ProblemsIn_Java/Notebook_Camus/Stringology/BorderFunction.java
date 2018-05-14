package ProblemsIn_Java.Notebook_Camus.Stringology;int[] getBorderArray(char[] W) {
	int[] T=new int[W.length+1]; T[0]=-1; T[1]=0;
	for (int i=2,j=0; i<=W.length; ){
		if (W[i-1]==W[j]) T[i++]=++j; 
		else if (j>0) j=T[j];
		else T[i++]=0;}
	return T;
}