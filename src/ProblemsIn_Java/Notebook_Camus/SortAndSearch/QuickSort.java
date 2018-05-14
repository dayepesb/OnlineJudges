package ProblemsIn_Java.Notebook_Camus.SortAndSearch;void quickSort(long[] arr, int pi, int pf) {
	if (pi&gt;=pf) return;
	long piv=arr[(pi+pf)/2]; int i=pi,j=pf;
	for ( ; i&lt;=j; i++,j-- ){
	while (arr[i]&lt;piv) i++; 
	while(arr[j]&gt;piv) j-- ;
	if (i&gt;j) break; if (i!=j) {
		long tmp=arr[i]; arr[i]=arr[j]; arr[j]=tmp;}
	}
	quickSort(arr,pi,j); quickSort(arr,i,pf);
}