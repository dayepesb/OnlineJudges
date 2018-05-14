package ProblemsIn_Java.Notebook_Camus.Mathematics;

public int FibonacciPow(long f, long lim){
	lim=(1<<lim)-1;
	String bin=Long.toBinaryString(f-1);
	long [][]M={{1,1},{1,0}};
	long[][]pot=M; long[][]res={{1,0},{0,1}};
	for (int i = bin.length()-1; i >=0; i--) {
		if(bin.charAt(i)=='1') res=mult(res, pot,lim);			
		pot=mult(pot, pot,lim);					
	}
	return (int) (f==0?0:res[0][0]&lim);
}