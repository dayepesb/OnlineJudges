'''
Created on 21/11/2017

@author: DAVID YEPES BUITRAGO
'''
import numpy as np;
from numpy.core.fromnumeric import shape

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
    mA = np.array(mA);
    B = np.array(mB);
    L, U = factorizationLU(mA);
    y = np.zeros(np.shape(B));
    x = np.zeros(np.shape(B));
    '''sustitucion progresia '''
    for i in range(np.shape(B)[0]):
        sum = B[i];
        for j in range(i):
            sum = sum - (L[i, j] * y[j]);
        sum = sum / L[i, i];
        y[i] = sum;
    ''' sustitucion regresiva '''
    for i in range(np.shape(B)[0] - 1, -1, -1):
        sum = y[i];
        for j in range(i + 1, np.shape(B)[0]):
            sum = sum - (U[i, j] * x[j]);
        sum = sum / U[i, i];
        x[i] = sum;
    return x;

A = [[1, 0, -1, 1], [1, -1.5, 4, 1], [-2, -3, -1.5, 2], [0, 2.5, 1, -3]];
A = np.array(A);
B = [4, -2, 1, 3]
B = np.array(B);
x = solve_lu(A, B);
print(x);