'''
Created on 24/09/2017

@author: DAVID YEPES
         DANIEL FORERO
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

if __name__ == '__main__':
    datos=[[0.5,-0.69314],[0.8, -0.22314],[1.2, 0.18232],[1.4 ,0.33647],[1.6,0.47000],[1.8 ,0.58778],[2.0, 0.69314]]
    PL = LagrangePol(datos)
    print(PL(2.71028))
    print(PL(1))
    pass