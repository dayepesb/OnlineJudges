'''
Created on 29 ago. 2017

@author: david
'''
from math import pow, tan
import numpy
def f(x):
    return (x-(0.5 *tan(x)))

if __name__ == '__main__':
    p0 = 1.0
    p1 = 1.2
    lengt = 10
    method = numpy.zeros(lengt,"float64")
    method[0]=(p1)
    method[1]=(p0)
    print method
    for i in range(2,lengt-1):
        p1=method[i-1]
        p0=method[i-2]
        method[i] = method[i-1]-((f(p1)*(p1-p0))/(f(p1)-f(p0)))
    print method
    pass