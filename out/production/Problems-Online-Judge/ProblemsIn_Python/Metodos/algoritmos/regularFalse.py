'''
Created on 14 ago. 2017

@author: david
'''
from cmath import exp

def f(x):return pow(x, 5)+1

def regulaFalsi(error):
    low = 0.
    hi = 1.
    ans = -1
    while (low+error)<hi:
        mid = low-f(low)*((hi-low)/(f(hi)-f(low)))
        print mid
        if(f(low)*f(mid))<=0:
            hi = mid
        else:
            low = mid
        if ans == mid :
             break
        ans=mid  
        
    return ans
if __name__ == '__main__':
    print regulaFalsi(1e-7)