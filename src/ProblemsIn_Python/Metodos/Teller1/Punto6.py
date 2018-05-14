'''
Created on 14 ago. 2017

@author: david
'''
from random import randint

def f(x):
    if (x%2)==0:
        return x/2.
    else:
        return  3.*x+1

if __name__ == '__main__':
    print 'Ingrese el numero m'
    m = input()
    x=m
    if m==0:
       x=randint(1.,10000.)
    print('x : '+str(x)+'\nsu valor es '+str(f(x)))
    pass 