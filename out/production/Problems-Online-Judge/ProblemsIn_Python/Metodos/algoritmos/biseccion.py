'''
Created on 14 ago. 2017

@author: david
'''
from math import exp
def f(x):return pow(x, 5)+1

def biseccion():
    low = 0
    hi = 1
    while (low+1e-7)<hi:
        mid = (hi+low)/2.
        if(f(low)*f(mid)<=0):
            hi = mid
        else:
            low = mid
    
    return (hi+low)/2.
if __name__ == '__main__':
    print biseccion()