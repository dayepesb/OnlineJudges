'''
Created on 15 ago. 2017

@author: david
'''
from math import exp, cos, sin, tan
def f(x):
    '''-1,0'''
    return cos(exp(x))+x
def g(x):
    ''' -5,5 '''
    return pow(2, x)*(x-6)-x 
def h(x):
    ''' -8 , -1 '''
    return sin(3*x)-cos(2*x)-1
def i(x):
    ''' 1 , 2  '''
    return ((exp(x))/(x-3))+2*x

def j(x):
    ''' 3 , 4 '''
    return pow(x,-2)-tan(x)
def k(x):
    ''' (-2,-1) (-1,0) (1,2) '''
    return pow(x,3)-4*x*cos(x)+pow((2*sin(x)), 2)-3

def biseccionf(l,h,presicion):
    low = l
    hi = h
    while (low+presicion)<hi:
        mid = (hi+low)/2.
        if(f(low)*f(mid)<=0):
            hi = mid
        else:
            low = mid
    
    return (hi+low)/2.

def bisecciong(l,h,presicion):
    low = l
    hi = h
    while (low+presicion)<hi:
        mid = (hi+low)/2.
        if(g(low)*g(mid)<=0):
            hi = mid
        else:
            low = mid
    
    return (hi+low)/2.

def biseccioni(l,h,presicion):
    low = l
    hi = h
    while (low+presicion)<hi:
        mid = (hi+low)/2.
        if(i(low)*i(mid)<=0):
            hi = mid
        else:
            low = mid
    
    return (hi+low)/2.

def biseccionj(l,h,presicion):
    low = l
    hi = h
    while (low+presicion)<hi:
        mid = (hi+low)/2.
        if(j(low)*j(mid)<=0):
            hi = mid
        else:
            low = mid
    
    return (hi+low)/2.

def biseccionk(l,h,presicion):
    low = l
    hi = h
    while (low+presicion)<hi:
        mid = (hi+low)/2.
        if(k(low)*k(mid)<=0):
            hi = mid
        else:
            low = mid
    
    return (hi+low)/2.

def biseccionh(l,h,presicion):
    low = l
    hi = h
    while (low+presicion)<hi:
        mid = (hi+low)/2.
        if(h(low)*h(mid)<=0):
            hi = mid
        else:
            low = mid
    
    return (hi+low)/2.

if __name__ == '__main__':
    presicion = 1e-5
    print 'Punto a : '+str(biseccionf(-1, 0, presicion))
    print 'Punto b : '+str(bisecciong(-5, 5, presicion))
    print 'Punto c : '+str(biseccionh(-8, -1, presicion))
    print 'Punto d : '+str(biseccioni(1, 2, presicion))
    print 'Punto e : '+str(biseccionj(3, 4, presicion))
    print 'Punto f intervalo -2 -1 : '+str(biseccionk(-2, -1, presicion))
    print 'Punto f intervalo -1  0 : '+str(biseccionk(-1, 0, presicion))
    print 'Punto f intervalo  1  2 : '+str(biseccionk(1, 2, presicion))
    pass

