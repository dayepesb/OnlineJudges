'''
Created on 15 ago. 2017

@author: david
'''
import numpy as np
from math import cos

def g(x): return cos(x)

if __name__ == '__main__':
    niter = 100
    x0 = 0.5
    xlist = np.zeros(niter,"float32")
    xlist[0]=x0
    for i in range(niter-1):
        xlist[i+1]=g(xlist[i])
    print xlist
    pass