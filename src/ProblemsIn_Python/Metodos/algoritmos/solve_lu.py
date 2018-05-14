'''
Created on 31/10/2017

@author: PC
'''
import FactorizationLU as flu;
import numpy as np;
from numpy.core.fromnumeric import shape
from numpy.oldnumeric.random_array import random
def solve_lu(mA, mB):
#    A = np.array(mA);
    B = np.array(mB);
    L, U = flu.factorizationLU(mA);
    y = np.zeros(np.shape(B));
    x = np.zeros(np.shape(B));
    '''sustitucion progresia '''
    for i in range(np.shape(B)[0]):
        sum = B[i];
        for j in range(i):
            sum = sum - (L[i, j] * y[j]);
        sum = sum / L[i, i];
        y[i] = sum;
    ''' sustitucion regresiva '''
    for i in range(np.shape(B)[0] - 1, -1, -1):
        sum = y[i];
        for j in range(i + 1, np.shape(B)[0]):
            sum = sum - (U[i, j] * x[j]);
        sum = sum / U[i, i];
        x[i] = sum;
    return x;
