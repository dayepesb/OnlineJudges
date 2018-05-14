'''
Created on 21/11/2017

@author: DAVID YEPES BUITRAGO
'''
import numpy as np;
import math as m;
import matplotlib.pyplot as plt

def func(x):
    return 200 / (39 * m.exp(-2 * x) + 1);

def  f(x, y):
    return 0.1 * x * (200 - y);
def solve_Euler(x, y):
    x0 = x;
    y0 = y;
    F = np.zeros(100000);
    F[0] = f(x0, y0);
    xf = 20;
    deltax = (xf - x0) / 100000.0;
    x = np.zeros(len(F));
    y = np.zeros(len(F));
    x[0] = x0;
    y[0] = y0;
    x[0] = xi = x0;
    for i in range(1, len(F)):
        y[i] = F[i - 1] * deltax + y[i - 1];
        x[i] = xi = xi + deltax;
        F[i] = f(x[i], y[i]);

    return [x, y]
def exacta():
    x1 = np.zeros(100000);
    y1 = np.zeros(100000, 'float32');
    x1[0] = 0;
    y1[0] = 5;
    index = 1;
    for i in range(1, 100000):
        index = index + 0.0002;
        x[i] = index;
        y[i] = func(index);
    return [x, y]
        
x, y = solve_Euler(0, 5);
x1, y1 = exacta();
plt.plot(x, y, 'r--', label='Solución Numerica')
plt.plot(x1, y1, 'b', label='Solución exacta')
plt.legend()
plt.show()
'''
La solución numerica es al mi parecre exactamente y casi no tiene rango de error y la grafica lo demuesra
'''
