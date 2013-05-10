#!/usr/bin/python3
# -*-coding:Utf-8 -*

'''
Created on May 7, 2013

@author: nicolas
'''

if __name__ == '__main__':
    autre_liste = [
                   [1, 'a'],
                   [2, 'b'],
                   [3, 'c'],
                   [4, 'd']
                   ]
    
    for nb, lettre in autre_liste:
        print("La lettre {} est la {}e de l'alphabet.".format(lettre, nb))
    
    