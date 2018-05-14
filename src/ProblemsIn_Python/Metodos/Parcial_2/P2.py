'''
Created on 3/10/2017

@author: David Yepes 
'''
from math import pi
from math import sin
import difdiv as dd
import numpy as np
import matplotlib.pyplot as plt
from math import *
from pprint import pprint


if __name__ == '__main__':
    datos = [[-pi / 2, sin(-pi / 2)], [pi / 6, sin(pi / 6)], [pi / 4, sin(pi / 4)], [pi / 2, sin(pi / 2)]]
    # print datos
    T, P = dd.NewtonPol(datos)
    print "Tabla de diferencias divididas:"
    print(T)
    datosPol = [];
    datosSin = [];
    for i in np.arange(-(pi/2),(pi/2),0.001):
        xPol = i;
        yPol = P(i);
        xSin = i
        ySin = sin(i)
        datosPol.append([xPol,yPol])
        datosSin.append([xSin,ySin])
    plt.plot(datosPol)
    plt.plot(datosSin)
    plt.show()
    pass