'''
Created on 24/09/2017

@author: DAVID YEPES
'''
def LagrangePol(datos):

    def L(k, x):  # pol $L_k(x)=\prod\limits_{i \neq k}\frac{x-x_i}{x_k-x_i}$
        out = 1.0
        for i, p in enumerate(datos):
            if i != k:
                out *= (x-p[0])/(datos[k][0]-p[0])
        return out

    def P(x):  # polinomio $P(x)=\sum\limits_{k}f(x_k)L_k(x)$
        lag = 0.0
        for k, p in enumerate(datos):
            lag += p[1]*L(k, x)
        return lag

    return P

def f(x):return pow(x, 3)-1
if __name__ == '__main__':
    nodos = [0,1,2,-1]
    arr = [];
    for i in range(4):
        arr.append([nodos[i],f(nodos[i])])
    PL = LagrangePol(arr)
    print(PL(4))
    pass