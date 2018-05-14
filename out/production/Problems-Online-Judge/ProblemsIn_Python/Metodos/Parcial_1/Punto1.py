'''
Created on 29 ago. 2017

@author: david
'''
import numpy as np
from math import log

def f(x):
    a = (1.1129241 * (10 ^ (-3)))
    b = (1.1129241 * (10 ^ (-3)))
    c = (8.775468 * (10 ^ (-8)))
    log1 = log(x)
    log2 = log1*log1*log1
    
    if x <= 0.0:
        return - 1
    else:
        return (a + b* log1 + (c)*(log2)) * (-267)

def biseccionMethod():
    low = 0.4
    hi = 0.05
    iter = 0
    while iter < 99:
        mid = (hi + low) / 2.
        biseccion[iter] = mid
        if(f(low) * f(mid) <= 0):
            hi = mid
        else:
            low = mid
        iter += 1
    pass

def regulaFalsi():
    low = 0.1
    hi = 0.05
    ans = -1
    iter = 0;
    while (iter<=99):
        mid = low-f(low)*((hi-low)/(f(hi)-f(low)))
        regula[iter]=mid
        if(f(low)*f(mid))<=0:
            hi = mid
        else:
            low = mid
        if ans == mid :
             break
        ans=mid  
        iter+=1
    pass
def puntoFijo():
    niter = 100
    x0 = 0.5
    punto[0]=x0
    for i in range(niter-1):
        print punto[i]
        if(punto[i]>0.0):
            punto[i+1]=f(punto[i])
    pass
def secanteMethod():
    p0 = 1.0
    p1 = 1.2
    lengt = 10
    secante[0]=(p1)
    secante[1]=(p0)
    for i in range(2,lengt-1):
        p1=secante[i-1]
        p0=secante[i-2]
        secante[i] = secante[i-1]-((f(p1)*(p1-p0))/(f(p1)-f(p0)))
    
    pass
if __name__ == '__main__':
    niter = 100
    biseccion = np.zeros(niter, "float64")
    biseccionMethod()
    regula = np.zeros(niter, "float64")
    regulaFalsi()
    punto = np.zeros(niter, "float64")
    puntoFijo()
    secante = np.zeros(niter, "float64")
    secanteMethod()
    pass
