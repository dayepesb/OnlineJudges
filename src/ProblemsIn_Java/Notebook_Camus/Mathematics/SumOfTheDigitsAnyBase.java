package ProblemsIn_Java.Notebook_Camus.Mathematics;//la respuesta es rec(n�mero,1,1);
//la base aca es 10
private static long rec(long n, long dep, long lef) {
	if(n==0)return 0;
	long m=n%10;		
	long var=n/10*45*dep+m*lef+m*(m-1)/2*dep;
	return var+rec(n/10,dep*10,lef+m*dep);
}
