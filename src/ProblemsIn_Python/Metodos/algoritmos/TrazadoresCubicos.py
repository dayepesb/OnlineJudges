'''
Created on 1/10/2017

@author: PC
'''

from math import *


def CubicSplines(datos):
    n = len(datos)-1
    # Inicializar vectores auxiliares
    A = [x[1] for x in datos]
    X = [x[0] for x in datos]
    H = [0.0 for x in range(n)]
    B = [0.0 for x in range(n+1)]
    C = [0.0 for x in range(n+1)]
    D = [0.0 for x in range(n+1)]
    alpha = [0.0 for x in range(n)]
    mu = [0.0 for x in range(n+1)]
    l = [1.0 for x in range(n+1)]
    z = [0.0 for x in range(n+1)]

    # Crear vector $H$
    for i in range(n):
        H[i] = X[i+1]-X[i]

    # Crear vector $\alpha$
    for i in range(1, n):
        alpha[i] = (3.0/H[i])*(A[i+1]-A[i])-(3.0/H[i-1])*(A[i]-A[i-1])

    # Solucionar sistema tridiagonal
    for i in range(1, n):
        l[i] = 2.0*(X[i+1]-X[i-1])-H[i-1]*mu[i-1]
        mu[i] = float(H[i])/l[i]
        z[i] = (alpha[i]-H[i-1]*z[i-1])/float(l[i])

    # Solucionar sistema tridiagonal
    for j in range(n-1, -1, -1):
        C[j] = z[j]-mu[j]*C[j+1]
        B[j] = (A[j+1]-A[j])/float(H[j])-H[j]*(C[j+1]+2*C[j])/3.0
        D[j] = (C[j+1]-C[j])/(3.0*H[j])

    # Retornar vectores $A$, $B$, $C$, $D$
    return A[:-1], B[:-1], C[:-1], D[:-1]



def trazadoresCubicosResult(datos):
    def interval(x,datos):
        xsel= -1;
        isel = -1;
        for i,p in enumerate(datos):
            if x<=p[0]:
                xsel = p[0]
                isel=i
                break
            else:
                if(i==len(datos)-1):
                    xsel=p[0]
                    isel=i
        return xsel,isel

    def solution(x):
        xsel,isel = interval(x, datos)
        cs = CubicSplines(datos)
        A,B,C,D = cs
        '''
        print(A)
        print(B)
        print(C)
        print(D)
        print(isel)
        '''
        return A[isel-1]+(B[isel-1]*(x-xsel))+(C[isel-1]*pow((x-xsel), 2))+(D[isel-1]*pow((x-xsel), 3))
    return solution

datos = [[1,2],[1.5,5],[2,3],[3,5]]
CS = trazadoresCubicosResult(datos)
print(CS(2.543))
