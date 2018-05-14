'''
Created on 3/10/2017

@author: PC
'''
import algoritmos.lagrange as la

if __name__ == '__main__':
    datos = [[8.0,1.25],[8.2,1.76],[8.3,1.46],[8.5,1.75]]
    Pl = la.LagrangePol(datos);
    print(Pl(8.4))
    pass