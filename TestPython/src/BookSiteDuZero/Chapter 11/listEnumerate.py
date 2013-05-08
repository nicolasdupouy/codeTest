#!/usr/bin/python3
# -*-coding:Utf-8 -*

'''
Created on May 7, 2013

@author: nicolas
'''

if __name__ == '__main__':
    ma_liste = ['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h']
    
    print("# test 1:")
    print("# -------")
    for i, elt in enumerate(ma_liste):
        print("A l'indice {} se trouve {}.".format(i, elt))
    
    print("# test 2:")
    print("# -------")
    for i, elt in enumerate(ma_liste):
        print("A l'indice {indice} se trouve {element}.".format(indice=i, element=elt))
    
    print("# test 3:")
    print("# -------")
    for elt in enumerate(ma_liste):
        print(elt)
    
    