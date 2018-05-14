'''
Created on 15 ago. 2017

@author: david
'''
import numpy as np

def f(x):
    return (-1./10.)*pow(x,2)+3

def fd(x):
    return (-1./5.)*x

if __name__ == '__main__':
    x0=5.0
    niter=10
    
    xlist = np.zeros(niter,"float32")
    
    xlist[0]=x0
    
    for i in range(niter-1):
        xlist[i+1]=xlist[i]-((f(xlist[i]))/(fd(xlist[i])))
    
    print xlist