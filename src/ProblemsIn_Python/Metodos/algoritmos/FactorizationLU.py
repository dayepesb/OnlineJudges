'''
Created on 24/10/2017

@author: PC
'''
import numpy as np;
eps = np.finfo(np.float).eps
def factorizationLU(A):
    n = len(A);
    L = np.zeros((n, n));
    U = np.zeros((n, n));
    for j in range(n):
        L[j][j]=1;
        if(abs(A[j][j])<eps):
            return ["Error","Verificar pivote A"+"["+str(j)+","+str(j)+"]"]
        for i in range(j + 1, n):
            L[i][j]=A[i][j]/A[j][j];
            for k in range(j+1,n):
                A[i][k]=A[i][k]-(L[i][j]*A[j][k]);
        for k in range(j,n):
            U[j][k]=A[j][k]
            

    return [L,U]
'''
A = [[1, 2,-1], [2,1,-2],[-3,1,1]];
A = np.array(A);
FLU = factorizationLU(A);
print(FLU[0])
print(FLU[1])
'''