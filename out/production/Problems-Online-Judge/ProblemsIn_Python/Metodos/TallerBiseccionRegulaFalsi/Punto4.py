'''
Created on 15 ago. 2017

@author: david
'''
from math import exp
def f(x):
    return x*exp(-2*x)+x+1

def regulaFalsi(error):
    low = 0.
    hi = 1.
    ans = -1
    while (low+error)<hi:
        mid = low-f(low)*((hi-low)/(f(hi)-f(low)))
        if(f(low)*f(mid))<=0:
            hi = mid
        else:
            low = mid
        if ans == mid :
             break
        ans=mid  
        
    return ans

if __name__ == '__main__':
    print regulaFalsi(1e-6)