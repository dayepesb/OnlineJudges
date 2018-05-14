package ProblemsIn_Java.Notebook_Camus.SortAndSearch;void mergeSort(long[] arr, long[] arrTmp, int pi, int pf) {
	if (pf&lt;=pi) return;
	int m=(pi+pf)/2+1,i,j,k; mergeSort(arr,arrTmp,pi,m-1); 
	mergeSort(arr,arrTmp,m,pf); for (i=pi,j=m,k=pi; i&lt;=m-
	1&amp;&amp;j&lt;=pf; k++) arrTmp[k]=arr[i]&lt;=arr[j]?arr[i++]:arr[j++];
	for (; i&lt;=m-1; k++,i++) arrTmp[k]=arr[i];
	for (k=pi; k&lt;j; k++) arr[k]=arrTmp[k];
}
