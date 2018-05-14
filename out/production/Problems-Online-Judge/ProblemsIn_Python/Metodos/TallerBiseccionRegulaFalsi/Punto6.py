'''
Created on 15 ago. 2017

@author: david
'''
import numpy as np
def f(x):
    return (pow(x,5)-3*pow(x,3)-8*pow(x, 2)-x-4)/(pow(x,3)+2*pow(x,2)+x+6)
def regulaFalsi(error):
    low = -1.
    hi = 2.
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
    
    A = np.zeros(26)
    r = -1
    for i in range(26):
        A[i]=f(r)
        r+=0.1
    print A
    
    print 'regula Falsi : '
    print '%.4f'%(regulaFalsi(1e-6))