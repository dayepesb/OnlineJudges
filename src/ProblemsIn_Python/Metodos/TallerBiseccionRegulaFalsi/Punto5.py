'''
Created on 15 ago. 2017

@author: david
'''
from math import log

def f(x):
    return pow(x-1, 4.5)-5*(x-1)-0.1
def g(x):
    return x*log(x+1)-2

def biseccionf(l,h,presicion):
    low = l
    hi = h
    iter= 0
    while (low+presicion)<hi:
        iter+=1
        mid = (hi+low)/2.
        if(f(low)*f(mid)<=0):
            hi = mid
        else:
            low = mid
    
    print '    iteraciones : '+str(iter)
    return (hi+low)/2.

def bisecciong(l,h,presicion):
    low = l
    hi = h
    iter = 0
    while (low+presicion)<hi:
        iter+=1
        mid = (hi+low)/2.

        if(g(low)*g(mid)<=0):
            hi = mid
        else:
            low = mid
    
    print '    iteraciones : '+str(iter)
    return (hi+low)/2.

def regulaFalsif(l,h,presicion):
    low = l
    hi = h
    ans = -1
    iter = 0
    while (low+presicion)<hi:
        iter+=1
        mid = low-f(low)*((hi-low)/(f(hi)-f(low)))
        if(f(low)*f(mid))<=0:
            hi = mid
        else:
            low = mid
        if ans == mid :
             break
        ans=mid  
        
    print '    iteraciones : '+str(iter)
    return ans

def regulaFalsig(l,h,presicion):
    low = l
    hi = h
    ans = -1
    iter = 0;
    while (low+presicion)<hi:
        iter+=1
        mid = low-g(low)*((hi-low)/(g(hi)-g(low)))
        if(g(low)*g(mid))<=0:
            hi = mid
        else:
            low = mid
        if ans == mid :
             break
        ans=mid  
        
    print '    iteraciones : '+str(iter)
    return ans

if __name__ == '__main__':
    presicion = 1e-6
    print 'punto a : '
    print '  biseccion : '
    print '    '+str(biseccionf(1,3,presicion))
    print '  Regula Falsi : '
    print '    '+str(regulaFalsif(1,3,presicion))
    print ''
    print 'punto b : '
    print '  biseccion : '
    print '    '+str(bisecciong(0,2,presicion))
    print '  Regula Falsi : '
    print '    '+str(regulaFalsig(0,2,presicion))  
    
    pass