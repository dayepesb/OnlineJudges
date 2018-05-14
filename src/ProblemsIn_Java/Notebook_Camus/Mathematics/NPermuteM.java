package ProblemsIn_Java.Notebook_Camus.Mathematics;long n=Long.parseLong(st.nextToken());
long m=Long.parseLong(st.nextToken());
long res=1;
for (long i = n-m+1; i <= n; i++) 
	res*=i;
