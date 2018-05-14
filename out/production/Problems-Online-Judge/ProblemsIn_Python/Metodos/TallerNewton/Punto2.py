'''
Created on 20 ago. 2017

@author: david
'''
import numpy as np
from math import exp

def f(x):
    return exp(-x)-x
def fd(x):
    return -exp(-x)-1
def newtonRaphson(x0):
    niter = 3
    xlist = np.zeros(niter,'float32')
    xlist[0]=x0
    for i in range(niter-1):
        xlist[i+1]=xlist[i]-((f(xlist[i]))/(fd(xlist[i])))
    print xlist
    pass