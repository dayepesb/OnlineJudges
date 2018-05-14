'''
Created on 14 ago. 2017

@author: david
'''

def numerosTriangulares(n):
    i = 1
    for i in range(n):
        print (i * (i + 1)) / 2
    pass

if __name__ == '__main__':
    print 'Ingrese el numero n'
    n = input()
    numerosTriangulares(n)
    pass
