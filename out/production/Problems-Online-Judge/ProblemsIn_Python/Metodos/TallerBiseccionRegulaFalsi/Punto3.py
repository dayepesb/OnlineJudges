'''
Created on 15 ago. 2017

@author: david
'''
def f(x):
    return 1/x
def biseccion(l,h,presicion):
    low = l
    hi = h
    while (low+presicion)<hi:
        mid = (hi+low)/2.
        print mid
        if(f(low)*f(mid)<=0):
            hi = mid
        else:
            low = mid
    
    return (hi+low)/2.

if __name__ == '__main__':
    print biseccion(-1, 1, 1e-7)
    '''
    la primera itteracion donde halla la mitad del inteervalo se vuelve cero y dado por ello
    la division es 1/0 y es una operacion invalida
    '''