'''
Created on 14 ago. 2017

@author: david
'''
def sumDigist(n):
    result = 0
    nCadena= str(n)
    for i in nCadena:
        result+=int(i)
    return result

if __name__ == '__main__':
    print 'Ingrese en numero n'
    print 'La suma de sus digitos es : '+str(sumDigist(input()))