'''
Created on 15 ago. 2017

@author: david
'''
from math import cos, exp
def f(x): return cos(exp(x))+x

def biseccion():
    low = -1
    hi = 0
    while (low+1e-7)<hi:
        mid = (hi+low)/2.
        if(f(low)*f(mid)<=0):
            hi = mid
        else:
            low = mid
    
    return (hi+low)/2.

if __name__ == '__main__':
    print (biseccion())
    pass