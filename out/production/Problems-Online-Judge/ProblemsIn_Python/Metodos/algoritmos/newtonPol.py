'''
Created on 3/10/2017

@author: PC
'''
def NewtonPol(dat):
    n = len(dat)-1
    F = [[0 for x in dat] for x in dat]  # crear tabla nula

    for i, p in enumerate(dat):  # condiciones iniciales
        F[i][0] = p[1]

    for i in range(1, n+1):  # tabla de diferencias divididas
        for j in range(1, i+1):
            F[i][j] = (F[i][j-1]-F[i-1][j-1])/(dat[i][0]-dat[i-j][0])

    def L(k, x):  # polinomio $L_k(x)=\prod\limits_{i \leq k}(x-x_i)$
        out = 1.0
        for i, p in enumerate(dat):
            if i <= k:
                out *= (x-p[0])
        return out

    def P(x):  # $P(x)=f[x_0]+\sum_{k=1}^{n}f[x_0,x_1,\ldots,x_k]L_{k-1}(x)$
        newt = 0.0
        for i in range(1, n+1):
            newt += F[i][i]*L(i-1, x)
        return newt + F[0][0]

    return F, P
