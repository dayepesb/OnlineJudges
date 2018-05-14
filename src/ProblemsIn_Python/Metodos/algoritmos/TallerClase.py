'''
Created on 31/10/2017

@author: David Yepes
'''

import numpy as np;
eps = np.finfo(np.float).eps
def factorizationLU(A):
    n = len(A);
    L = np.zeros((n, n));
    U = np.zeros((n, n));
    for j in range(n):
        L[j][j] = 1;
        if(abs(A[j][j]) < eps):
            return ["Error", "Verificar pivote A" + "[" + str(j) + "," + str(j) + "]"]
        for i in range(j + 1, n):
            L[i][j] = A[i][j] / A[j][j];
            for k in range(j + 1, n):
                A[i][k] = A[i][k] - (L[i][j] * A[j][k]);
        for k in range(j, n):
            U[j][k] = A[j][k]
            

    return [L, U]
def solve_lu(mA, mB):
#    A = np.array(mA);
    B = np.array(mB);
    L, U = factorizationLU(mA);
    y = np.zeros(np.shape(B));
    x = np.zeros(np.shape(B));
    for i in range(np.shape(B)[0]):
        sum = B[i];
        for j in range(i):
            sum = sum - (L[i, j] * y[j]);
        sum = sum / L[i, i];
        y[i] = sum;
    for i in range(np.shape(B)[0] - 1, -1, -1):
        sum = y[i];
        for j in range(i + 1, np.shape(B)[0]):
            sum = sum - (U[i, j] * x[j]);
        sum = sum / U[i, i];
        x[i] = sum;
    return x;

n = input();
lista = [0] * n;
A = [lista] * n;
A = np.array(A);
B = np.zeros(n);

for i in range(n):
    A[i, i] = 2.0;
    B[i] = np.random.rand();
    if i < n - 1 :
        A[i , i + 1] = -1.0
        A[i + 1, i] = -1.0;
x = solve_lu(A, B);
print(A);
print(B);
print(x);
