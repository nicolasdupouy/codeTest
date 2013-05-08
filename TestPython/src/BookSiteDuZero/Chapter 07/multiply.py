#!/usr/bin/python3
# -*-coding:Utf-8 -*

'''
Created on 13 mars 2013

@author: nicolasdupouy

Module multiply contenant la fonction table
'''

def table(nb, max=10):
    """Fonction affichant la table de multiplication par nb de
    1 * nb jusqu'à max * nb"""
    i = 1
    while i <= max:
        print(i, " * ", nb, " = ", i*nb)
        i+=1

if __name__ == '__main__':
    table(4)