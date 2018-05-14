
# coding: utf-8

# In[2]:


# primero entendemos como usar la directiva enumerate en python 
# con el siguiente ejemplo sencillo sobre una lista pequena:
datos = [[0.1,3.2],[0.2,4.5],[0.3,5.1],[0.4,6.7],[0.5,7.1],[0.6,7.9]]
for i, p in enumerate(datos):
    print(i, p)


# In[3]:


# construimos nuestra funcion de interpolacion de Lagrange
# la funcion LagrangePol crea un objeto que evalua un polinomio
# en un cierto valor de x
def LagrangePol(datos):

    def L(k, x):  # pol $L_k(x)=\prod\limits_{i \neq k}\frac{x-x_i}{x_k-x_i}$
        out = 1.0
        for i, p in enumerate(datos):
            if i != k:
                out *= (x-p[0])/(datos[k][0]-p[0])
        return out

    def P(x):  # polinomio $P(x)=\sum\limits_{k}f(x_k)L_k(x)$
        lag = 0.0
        for k, p in enumerate(datos):
            lag += p[1]*L(k, x)
        return lag

    return P


# In[4]:


# aqui vemos como llamar la funcion para un valor especifico de x

# primero creamos el objeto para nuestra lista de datos:
Pl = LagrangePol(datos)

# luego lo evaluamos en un valor particular de x

Pl(0.55)


# In[6]:


# Vamos a graficar el polinomio resultante
# sobre un cierto intervalo [0.1,0.5].

import numpy as np
x = np.arange(0.1,0.6,0.1)
y = np.zeros(np.size(x))
for i in range(np.size(x)):
    y[i]=Pl(x[i])
    
import matplotlib.pyplot as plt
plt.plot(x,y)
plt.show()


# In[ ]:

