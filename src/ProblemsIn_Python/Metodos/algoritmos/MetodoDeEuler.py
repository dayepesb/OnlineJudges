'''
Created on 7/11/2017

@author: David Yepes
'''
import numpy as np;
def  f(x, y):
    return x + y;
x0 = 1;
y0 = 1;
F = np.zeros(100);
F[0] = f(x0,y0);
xf = 5;
deltax = (xf-x0)/100.0;
x = np.zeros(len(F));
y = np.zeros(len(F));
x[0]=x0;
y[0]=y0;
x[0]=xi = x0;
for i in range(1,len(F)):
    y[i]=F[i-1]*deltax+y[i-1];
    F[i] = f(x[i],y[i]);
    x[i]=xi=xi+deltax;

print(x);
print(F);
print(y);