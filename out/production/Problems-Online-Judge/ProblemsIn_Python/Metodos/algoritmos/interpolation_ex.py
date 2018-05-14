import numpy as np 
'''
import matplotlib.pyplot as plt
'''
import tcubicos as csp
import lagrange as lg
import newtonPol as dd

datos = [[-1,1.5],[0,2],[1,2.3],[2,5]];

pol   = csp.CubicSplines(datos);
lpol  = lg.LagrangePol(datos);
Table, ddpol = dd.NewtonPol(datos);

x  = np.arange(-2,2.1,0.1);
y  = np.zeros(np.size(x));
y2 = np.zeros(np.size(x)); 
y3 = np.zeros(np.size(x)); 
for i in range(np.size(x)):
    y[i]  = pol(x[i]);
    y2[i] = lpol(x[i]);
    y3[i] = ddpol(x[i]);

for p in datos:
    plt.scatter(p[0],p[1],s = 100)
plt.plot(x,y,label='Cubic Splines pol')
plt.plot(x,y2,'-o',label='Lagrange pol')
plt.plot(x,y3,'k',label='Newton pol')
plt.legend()
plt.show()
