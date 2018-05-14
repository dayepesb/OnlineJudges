'''
Created on 3/10/2017

@author: David
'''

import algoritmos.lagrange as la

if __name__ == '__main__':
    datos = [[-2,-1],[-1,0],[1,2],[2,3]]
    Pl = la.LagrangePol(datos);
    print(Pl(2))
    pass