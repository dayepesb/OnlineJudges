'''
Created on 13 ago. 2017

@author: david
'''
from cmath import exp


def f(x):return pow(x, 5)*exp(pow(x, 2)-x-7)

if __name__ == '__main__':
    print f(1)
    