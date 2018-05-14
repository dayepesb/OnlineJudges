'''
Created on 14 ago. 2017

@author: david
'''
import numpy as np
from numpy.linalg import solve

A = np.array([[2.,1.,-1.],[2.,-1.,2.],[1.,1.,-1.]])
B = np.array([2.,-1.,3.])

if __name__ == '__main__':
    s = solve(A,B)
    print 'La solcuion al sistema es :'
    print 'x : '+str(s[0])
    print 'y : '+str(s[1])
    print 'z : '+str(s[2])
        
