package ProblemsIn_Java.Notebook_Camus.SortAndSearch;void insertionSort(long[] arr, int pi, int pf) {
	for (int i=pi+1; i&lt;=pf; i++){int j=i; 
	long v=arr[i]; for ( ; j&gt;pi &amp;&amp; arr[j-1]&gt;v; j-- ) 
	arr[j]=arr[j-1]; arr[j]=v;}
}